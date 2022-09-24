package com.example.mealapp.data

import com.example.mealapp.data.api.CategoryResponse
import com.example.mealapp.data.network.BaseResponse
import com.example.mealapp.model.Category
import retrofit2.Response
import retrofit2.http.GET

interface MealApi {
    @GET("categories.php")
    suspend fun getCategories(): Response<BaseResponse<CategoryResponse>>

}