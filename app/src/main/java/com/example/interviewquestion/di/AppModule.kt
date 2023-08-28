package com.example.interviewquestion.di

import com.example.interviewquestion.MainActivityViewModel
import com.example.data.repository.Repository
import com.example.data.repository.fake.FakeRepository
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val appModule = module {
    singleOf(::FakeRepository) { bind<Repository>() }
    viewModelOf(::MainActivityViewModel)
}