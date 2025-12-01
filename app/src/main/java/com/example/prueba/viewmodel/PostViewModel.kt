package com.example.prueba.viewmodel

import androidx.lifecycle.viewModelScope
import androidx.lifecycle.ViewModel
import com.example.prueba.model.Post
import com.example.prueba.repository.PostRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch


class PostViewModel : ViewModel() {
    private val repository = PostRepository()
    private val _PostList = MutableStateFlow<List<Post>>(emptyList())
    val PostList: StateFlow<List<Post>> = _PostList

    init {
        fetchPosts()
    }
    private fun fetchPosts() {
        viewModelScope.launch {
            try {
                _PostList.value= repository.getPosts()
            } catch (e: Exception) {
               print("Error al obtener los posts: ${e.message}")
            }
        }
    }
}


