package com.example.interviewquestion.improved.di

import com.example.interviewquestion.improved.MainActivityViewModel
import com.example.interviewquestion.improved.data.repository.Repository
import com.example.interviewquestion.improved.data.repository.fake.FakeRepository
import com.example.interviewquestion.improved.network.ApiClient
import okhttp3.OkHttpClient
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val appModule = module {
    singleOf(::FakeRepository) { bind<Repository>() }
    viewModelOf(::MainActivityViewModel)
}