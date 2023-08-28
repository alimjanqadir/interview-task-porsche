package com.example.network

import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET

interface ApiClient {
    @GET("/models")
    fun fetchModels(): Flow<List<String>>
}



