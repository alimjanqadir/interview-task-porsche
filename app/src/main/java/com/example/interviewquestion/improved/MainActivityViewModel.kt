package com.example.interviewquestion.improved

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.interviewquestion.improved.data.repository.Repository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn

class MainActivityViewModel(
    repo: Repository
) : ViewModel() {
    val models = repo.models
        .stateIn(
            scope = viewModelScope,
            initialValue = emptyList(),
            started = SharingStarted.WhileSubscribed(5_000),
        )
}