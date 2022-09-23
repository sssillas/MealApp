package com.example.mealapp.data.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL = "https://www.themealdb.com/api/json/"
private const val API_VERSION = "v1/1/"

class Service {

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL+API_VERSION)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun <API> createService(apiClass: Class<API>): API {
        return retrofit.create(apiClass)
    }



}