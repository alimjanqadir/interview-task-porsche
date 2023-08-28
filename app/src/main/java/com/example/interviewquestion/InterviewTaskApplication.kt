package com.example.interviewquestion

import android.app.Application
import com.example.interviewquestion.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin

class InterviewTaskApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@InterviewTaskApplication)
            modules(appModule)
        }
    }
} 