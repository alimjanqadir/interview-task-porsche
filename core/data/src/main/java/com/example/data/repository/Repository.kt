package com.example.data.repository

import kotlinx.coroutines.flow.Flow


interface Repository {
    val models: Flow<List<String>>
}

