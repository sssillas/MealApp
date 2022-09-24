package com.example.mealapp

import android.app.Application
import com.example.mealapp.di.MainModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MealApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MealApplication)
            modules(listOf(MainModule))
        }
    }
}