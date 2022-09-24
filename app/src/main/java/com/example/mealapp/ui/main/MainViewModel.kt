package com.example.mealapp.ui.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mealapp.model.Category
import com.example.mealapp.model.GetCategoriesUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(
    private val getCategoriesUseCase: GetCategoriesUseCase
) : ViewModel() {

    private val _categories = MutableLiveData<List<Category>>()
    val categories = _categories as LiveData<List<Category>>

    fun getCategories() {
        //Qualquer corrotina iniciada nesse escopo será cancelada automaticamente se o ViewModel for apagado
        viewModelScope.launch {
            //Só aceita uma função suspensa dentro de um escopo de Coroutine
            //Da mesma forma se tiver uma função suspensa, tudo tem que esta dentro de um contexto Courotines
            val categoryList = getCategoriesUseCase()

            _categories.value = categoryList//Após ter a lista da API aciona um livedata do arquiteto de componentes
        }

        //OUTRA OPÇÃO
        //Dispatchers.Main Significa que a thread esta ocorrendo na Main
        /*CoroutineScope(Dispatchers.Main).launch {
            val categoryList = getCategoriesUseCase()
            _categories.value = categoryList
        }*/
    }
}
