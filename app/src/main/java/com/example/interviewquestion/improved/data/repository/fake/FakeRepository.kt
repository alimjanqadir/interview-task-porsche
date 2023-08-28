package com.example.interviewquestion.improved.data.repository.fake

import com.example.interviewquestion.improved.data.repository.Repository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class FakeRepository : Repository {
    override val models: Flow<List<String>>
        get() = flow {
            emit(listOf("A", "B", "C"))
        }
}