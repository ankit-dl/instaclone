package com.ankit.data.service

import com.ankit.data.model.GalleryResponse
import com.ankit.data.model.GalleryTagsResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET(EndPoints.HOT)
    fun getTop(): Call<GalleryResponse>

    @GET(EndPoints.ALL)
    fun getGalleryTag(): Call<GalleryTagsResponse>
}