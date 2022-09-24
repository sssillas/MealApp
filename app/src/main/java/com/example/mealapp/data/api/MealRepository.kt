package com.example.mealapp.data.api

import android.util.Log
import com.example.mealapp.data.MealApi
import com.example.mealapp.data.network.Output
import com.example.mealapp.data.network.parseResponse
import com.example.mealapp.model.Category

class MealRepositoryImpl(private val service:MealApi): MealRepository{


    override suspend fun getCategories():List<Category> {

        val result = service.getCategories().parseResponse()
        return when (result) {
            is Output.Success -> {
                val categoryResponseList = result.value.categories
                Log.w("JJJJJJJJJJJJJJJJJJ","${categoryResponseList.toString()}")
                categoryResponseList.map {
                    it.toCategory()
                }

            }
            is Output.Failure -> throw GetCategoriesException()
        }
    }

}


interface MealRepository {
    suspend  fun getCategories(): List<Category>
}

class GetCategoriesException : Exception()