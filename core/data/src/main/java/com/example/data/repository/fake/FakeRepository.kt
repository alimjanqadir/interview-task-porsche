package com.example.data.repository.fake

import com.example.data.repository.Repository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class FakeRepository : Repository {
    override val models: Flow<List<String>>
        get() = flow {
            emit(listOf("A", "B", "C"))
        }
}