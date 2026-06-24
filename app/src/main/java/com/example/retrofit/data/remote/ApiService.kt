package com.example.retrofit.data.remote

import com.example.retrofit.data.model.meal
import retrofit2.http.GET

interface ApiService {

    @GET("meals")
    suspend fun getMeals(): List<meal>

}

