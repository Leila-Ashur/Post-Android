package com.example.myapplicationdispaly.Repository

import com.example.myapplicationdispaly.Model.Post
import com.example.myapplicationdispaly.API.ApiClient
import com.example.myapplicationdispaly.API.ApiInterface
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import retrofit2.Response

class PostRepository {
    var apiClient= ApiClient.buildClient(ApiInterface::class.java)
    suspend fun getPosts():Response<List<Post>> {
        return withContext(Dispatchers.IO){
            apiClient.getPosts()
        }

    }
}

