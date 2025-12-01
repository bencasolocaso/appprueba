package com.example.prueba.remote

import com.example.prueba.model.Post
import retrofit2.http.GET

interface ApiServise{
    @GET("/posts")
    suspend fun getPosts(): List<Post>
}

