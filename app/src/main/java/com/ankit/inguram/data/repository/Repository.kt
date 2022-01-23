package com.ankit.inguram.data.repository

import com.ankit.data.ApiClient
import com.ankit.data.model.GalleryResponse
import com.ankit.data.params.Section

class Repository {
    val api = ApiClient.apiService
    suspend fun getHotFeeds(): List<GalleryResponse.Data>? {
        val response = api.getGallery(Section.HOT)
        return response.body()?.data
    }

    suspend fun getTopFeeds(): List<GalleryResponse.Data>? {
        val response = api.getGallery(Section.TOP)
        return response.body()?.data
    }
}