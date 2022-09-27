package com.example.mealapp.presenter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.mealapp.databinding.ItemProgrammingLanguageBinding
import com.example.mealapp.model.Category

//Função Lambda para o evento click: vai receber um category e vai retornar um Unit
class MealAdapter(private val onItemClickListener: ((category: Category) -> Unit)) : ListAdapter<Category,MealAdapter.MealAdapterViewHolder>(DIFF_CALLBACK) {


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MealAdapterViewHolder {
        return MealAdapterViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: MealAdapterViewHolder, position: Int) {
        holder.bind(getItem(position),onItemClickListener)
    }


    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Category>() {
            override fun areItemsTheSame(
                oldItem: Category,
                newItem: Category
            ): Boolean {
                return oldItem.name == newItem.name
            }

            override fun areContentsTheSame(
                oldItem: Category,
                newItem: Category
            ): Boolean {
                return oldItem == newItem
            }

        }
    }


    class MealAdapterViewHolder(
        private val itemBinding: ItemProgrammingLanguageBinding
    ) : RecyclerView.ViewHolder(itemBinding.root) {

        fun bind(category: Category,onItemClickListener: ((category: Category) -> Unit)) {
            itemBinding.run {
                tvTitle.text = category.name
                itemView.setOnClickListener {
                    onItemClickListener.invoke(category)
                }
            }
        }

        //FUNÇÃO PARA CONSTRUIR O VIEWHOLDER
        companion object {
            fun create(parent: ViewGroup): MealAdapterViewHolder {
                val itemBinding = ItemProgrammingLanguageBinding
                    .inflate(LayoutInflater.from(parent.context), parent, false)
                return MealAdapterViewHolder(itemBinding)
            }
        }
    }



}