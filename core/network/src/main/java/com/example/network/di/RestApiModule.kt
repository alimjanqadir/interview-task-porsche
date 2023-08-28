package com.example.network.di

import com.example.data.repository.Repository
import com.example.network.repository.RestApiRepository
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

fun provideApiClient(retrofit: Retrofit): com.example.network.ApiClient =
    retrofit.create(com.example.network.ApiClient::class.java)
