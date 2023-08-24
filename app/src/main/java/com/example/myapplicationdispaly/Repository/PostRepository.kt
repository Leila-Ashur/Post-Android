package com.example.myapplicationdispaly.Repository

import com.example.myapplicationdispaly.Model.Post
import com.example.myapplicationdispaly.API.ApiClient
import retrofit2.HttpException

class PostRepository {
    suspend fun getPosts(): List<Post> {



        try {
            val response = ApiClient.retrofit.create(ApiService::class.java).getPosts()
            if (response.isSuccessful) {
                return response.body() ?: emptyList()
            } else {

                throw HttpException(response)
            }
        } catch (e: Exception) {

            throw e
        }
    }
}

