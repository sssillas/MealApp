package com.example.mealapp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout

class CategoryDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category_detail)
        val title = intent.getStringExtra(EXTRA_TITLE)
        Toast.makeText(this,"$title", Toast.LENGTH_LONG).show()
    }

    //Kotlin não tem funções estáticas, mas podemos utilizar o companion object
    companion object {
        private const val EXTRA_TITLE = "EXTRA_TITLE"
        fun getStartIntent(context: Context, title: String): Intent {
            return Intent(context,CategoryDetailActivity::class.java).apply {
                putExtra(EXTRA_TITLE,title)
            }
        }
    }
}