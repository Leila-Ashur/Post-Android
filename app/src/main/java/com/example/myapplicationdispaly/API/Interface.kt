package com.example.myapplicationdispaly.API

import com.example.myapplicationdispaly.Model.Post
import retrofit2.http.GET

interface ApiServiceInterface {
    @GET("posts")
    suspend fun getPosts(): List<Post>
}



