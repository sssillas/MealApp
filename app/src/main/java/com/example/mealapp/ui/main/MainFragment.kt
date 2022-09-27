package com.example.mealapp.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Observer
import com.example.mealapp.CategoryDetailActivity
import com.example.mealapp.R
import com.example.mealapp.databinding.FragmentMainBinding
import com.example.mealapp.model.Category
import com.example.mealapp.presenter.MealAdapter
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class MainFragment : Fragment() {


    private lateinit var _binding: FragmentMainBinding
    private val viewModel: MainViewModel by sharedViewModel()
    private lateinit var mealAdapter: MealAdapter

    companion object {
        fun newInstance() = MainFragment()
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // TODO: Use the ViewModel
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //val viewModel2: MainViewModel = ViewModelProvider
        viewModel.categories.observe( viewLifecycleOwner, Observer { listCategoryUiModel ->
            //val t = Toast.makeText(view,"listCategoryUiModel.toString()",Toast.LENGTH_LONG)
            Toast.makeText(activity,listCategoryUiModel.toString(),Toast.LENGTH_LONG).show()
            displayMeals(listCategoryUiModel)
           Log.w("DDDDD",listCategoryUiModel.toString())
        })



        viewModel.getCategories()
    }

    private fun displayMeals(meals: List<Category>) {
        mealAdapter.submitList(meals)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding=FragmentMainBinding.inflate(inflater,container,false)
        mealAdapter = MealAdapter{
            val intent = CategoryDetailActivity.getStartIntent(requireContext(),it.name)
            startActivity(intent)
        }
        _binding.recyclerFeed.adapter = mealAdapter

        return _binding.root
    }

}

/*

    ESTRUTURA DAS PASTAS

    -data/api
    -data/model


    -domain/model










 */