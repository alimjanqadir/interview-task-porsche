package com.example.interviewquestion.improved.data.repository

import com.example.interviewquestion.improved.network.ApiClient

class RestApiRepository(apiClient: ApiClient): Repository {
    override val models = apiClient.fetchModels()
}