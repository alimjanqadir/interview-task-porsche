package com.example.interviewquestion.improved.di

import com.example.interviewquestion.improved.data.repository.Repository
import com.example.interviewquestion.improved.data.repository.RestApiRepository
import com.example.interviewquestion.improved.network.ApiClient
import okhttp3.OkHttpClient
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val restApiModule = module {
    factoryOf(::provideApiClient)
    singleOf(::provideRetrofit)
    singleOf(::RestApiRepository) { bind<Repository>() }
}

fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
    return Retrofit.Builder().baseUrl("example.com").client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create()).build()
}

fun provideApiClient(retrofit: Retrofit): ApiClient = retrofit.create(ApiClient::class.java)
