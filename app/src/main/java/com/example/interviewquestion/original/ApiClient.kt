package com.example.interviewquestion.original

import kotlinx.coroutines.flow.Flow
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiClient {
    fun fetchModels(): Flow<List<String>>
}

// Use Koin for dependency injection
val myModule = module {
    factory { FakeApiClient() }
}

class FakeApiClient {
}
