package com.example.myapplicationdispaly.API

import com.example.myapplicationdispaly.Model.Post
import com.example.myapplicationdispaly.Model.PostResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface{
    @GET("/posts")
    suspend fun getPosts(): Response<List<Post>>
}



