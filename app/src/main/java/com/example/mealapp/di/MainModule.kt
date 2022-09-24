package com.example.mealapp.di

import com.example.mealapp.data.MealApi
import com.example.mealapp.data.api.MealRepository
import com.example.mealapp.data.api.MealRepositoryImpl
import com.example.mealapp.data.network.Service
import com.example.mealapp.model.GetCategories
import com.example.mealapp.model.GetCategoriesUseCase
import com.example.mealapp.ui.main.MainViewModel
import org.koin.dsl.module

val MainModule = module {
    single { Service().createService(MealApi::class.java) }

    //class MealRepository(private val service:MealApi): IMealRepository{
    single { MealRepositoryImpl(get()) }

    //class GetCategories(private val mealRepository: MealRepository) : GetCategoriesUseCase {
    single<GetCategoriesUseCase> { GetCategories(get()) }

    single { MainViewModel(get()) }
}