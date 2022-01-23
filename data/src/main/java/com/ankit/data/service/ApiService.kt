package com.ankit.data.service

import com.ankit.data.model.GalleryResponse
import com.ankit.data.model.GalleryTagsResponse
import com.ankit.data.params.Section
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET(EndPoints.GALLERY)
    suspend fun getGallery(
        @Path(EndPoints.SECTION) section: Section,
        @Query("album_previews") albumPreviews: Boolean? = true
    ): Response<GalleryResponse>

    @GET(EndPoints.ALL)
    suspend fun getGalleryTag(): Response<GalleryTagsResponse>
}