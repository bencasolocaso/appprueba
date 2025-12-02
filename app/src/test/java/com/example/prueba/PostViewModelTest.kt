package com.example.prueba

import com.example.prueba.model.Post
import com.example.prueba.viewmodel.PostViewModel
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldContainExactly
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.jupiter.api.Test


@OptIn(ExperimentalCoroutinesApi::class)
class PostViewModelTest : StringSpec({
    @Test
    "postList debe tener los datos esperados despues de el fetchposts()"{
        val fakePosts = listOf(
            Post(1, 1, "Post 1", "Contenido del post 1"),
            Post(2, 2, "Post 2", "Contenido del post 2")
        )

        val testViewmodel = object : PostViewModel() {
             override fun fetchPosts() {
                _PostList.value = fakePosts
            }
        }
        testViewmodel.fetchPosts()
        testViewmodel.PostList.value shouldContainExactly fakePosts
    }
})


