package com.example.prueba.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    val api: ApiServise by lazy {
        Retrofit.Builder()
            .baseUrl("http://localhost:9090/swagger-ui/index.html#/user-controller/login")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiServise::class.java)
    }
}