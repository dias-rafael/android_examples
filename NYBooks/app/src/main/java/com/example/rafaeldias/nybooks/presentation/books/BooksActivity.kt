package com.example.rafaeldias.nybooks.presentation.books

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.rafaeldias.nybooks.R
import com.example.rafaeldias.nybooks.databinding.ActivityBooksBinding

class BooksActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_books)

        val binding = ActivityBooksBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.toolbarMain.title = "Books"
        setSupportActionBar(binding.toolbarMain)
    }
}