package com.example.interviewquestion.improved.data.repository

import kotlinx.coroutines.flow.Flow


interface Repository {
    val models: Flow<List<String>>
}

