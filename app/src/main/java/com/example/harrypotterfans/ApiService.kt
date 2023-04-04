package com.example.harrypotterfans

import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("/api/characters")
    fun getCharacters(): Call<MutableList<PostModel>>
}