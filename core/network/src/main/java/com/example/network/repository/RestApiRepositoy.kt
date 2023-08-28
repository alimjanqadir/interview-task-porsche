package com.example.network.repository

import com.example.data.repository.Repository
import com.example.network.ApiClient

class RestApiRepository(apiClient: ApiClient): Repository {
    override val models = apiClient.fetchModels()
}