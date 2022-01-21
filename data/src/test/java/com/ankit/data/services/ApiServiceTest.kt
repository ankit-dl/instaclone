package com.ankit.data.services

import com.ankit.data.service.ApiService
import com.ankit.data.service.EndPoints
import junit.framework.Assert.assertNotNull
import okhttp3.OkHttpClient
import org.junit.Before
import org.junit.Test
import org.junit.internal.runners.JUnit4ClassRunner
import org.junit.runner.RunWith
import org.junit.runners.BlockJUnit4ClassRunner
import org.junit.runners.JUnit4
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class ApiServiceTest {
    lateinit var apiService: ApiService

    @Before
    fun setup() {
        val client = OkHttpClient.Builder().addInterceptor {
            val response = it.request().newBuilder()
                .addHeader("Authorization", "Client-ID 3fc3980c61cb285")
                .build()
            it.proceed(response)

        }.build()
        val retrofit = Retrofit.Builder()
            .baseUrl(EndPoints.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .client(client)
            .build()

        apiService = retrofit.create(ApiService::class.java)

    }

    @Test
    fun `get tags`() {
        val response = apiService.getGalleryTag().execute()
        println(response.raw().toString())


    }  @Test
    fun `get tops`() {
        val response = apiService.getTop().execute()
        println(response.raw().toString())


    }


}