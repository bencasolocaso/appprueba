package com.example.prueba.repository

import com.example.prueba.model.Post
import com.example.prueba.remote.RetrofitInstance

class PostRepository {
    suspend fun getPosts(): List<Post> {
        return RetrofitInstance.api.getPosts()
    }
}


