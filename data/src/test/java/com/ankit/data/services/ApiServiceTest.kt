package com.ankit.data.services

import com.ankit.data.ApiClient
import com.ankit.data.params.Section
import com.ankit.data.service.ApiService
import junit.framework.Assert.assertNotNull
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class ApiServiceTest {
    lateinit var apiService: ApiService

    @Before
    fun setup() {
        apiService = ApiClient.apiService

    }

    @Test
    fun `get tags`() = runBlocking {
        val response = apiService.getGalleryTag()
        println(response.body())


    }

    @Test
    fun `get tops`() = runBlocking {
        val response = apiService.getGallery(Section.TOP)
        print("data ---${response.body()?.data?.size}")


    }

    @Test
    fun `get hots`() = runBlocking {
        val response = apiService.getGallery(Section.HOT)
        assertNotNull(response.body())


    }


}