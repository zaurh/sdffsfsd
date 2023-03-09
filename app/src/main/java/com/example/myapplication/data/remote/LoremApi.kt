package com.example.myapplication.data.remote

import com.example.myapplication.data.remote.dto.LoremDTO
import retrofit2.http.GET

interface LoremApi {

    @GET("posts")
    suspend fun getPosts(): List<LoremDTO>

}