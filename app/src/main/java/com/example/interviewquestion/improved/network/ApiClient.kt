package com.example.interviewquestion.improved.network

import kotlinx.coroutines.flow.Flow
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiClient {
    @GET("/models")
    fun fetchModels(): Flow<List<String>>
}



