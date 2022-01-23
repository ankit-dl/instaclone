package com.ankit.data

import com.ankit.data.converters.EnumConverterFactory
import com.ankit.data.service.ApiService
import com.ankit.data.service.EndPoints
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object ApiClient {

    private val client: OkHttpClient by lazy {
        OkHttpClient.Builder().addInterceptor {
            val response = it.request().newBuilder()
                .addHeader("Authorization", "Client-ID 3fc3980c61cb285")
                .build()
            it.proceed(response)

        }.build()
    }
    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(EndPoints.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .addConverterFactory(EnumConverterFactory())
            .client(client)
            .build()
    }
    val apiService = retrofit.create(ApiService::class.java)
}