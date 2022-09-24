package com.example.mealapp.model

import com.example.mealapp.data.api.MealRepository
import com.example.mealapp.data.api.MealRepositoryImpl

class GetCategories(
    private val mealRepositoryImpl: MealRepositoryImpl
) : GetCategoriesUseCase {

    override suspend fun invoke(): List<Category> = try {

        mealRepositoryImpl.getCategories()
    } catch (ex: Exception) {
        listOf()

    }
}

interface GetCategoriesUseCase {
    suspend operator fun invoke(): List<Category>
}