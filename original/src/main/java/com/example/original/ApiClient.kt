package com.example.original

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import org.koin.dsl.module

interface ApiClient {
    fun fetchModels(): Flow<List<String>>
}

// Use Koin for dependency injection
val myModule = module {
    factory { FakeApiClient() }
}

class FakeApiClient : ApiClient {
    override fun fetchModels(): Flow<List<String>> = flow {
        emit(listOf("A", "B", "C"))
    }
}