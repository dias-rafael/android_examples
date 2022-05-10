package com.example.rafaeldias.nybooks.presentation.books

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.rafaeldias.nybooks.R
import com.example.rafaeldias.nybooks.data.model.Book
import com.example.rafaeldias.nybooks.databinding.ActivityBooksBinding

class BooksActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_books)

        val binding = ActivityBooksBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.toolbarMain.title = getString(R.string.books_title)

        setSupportActionBar(binding.toolbarMain)

        with(binding.recyclerViewItems) {
            layoutManager = LinearLayoutManager(this@BooksActivity, RecyclerView.VERTICAL, false)
            setHasFixedSize(true)
            adapter = BooksAdapter(getBooksMock())
        }
    }

    fun getBooksMock(): List<Book> {
        return listOf<Book>(
            Book("Title1", "Author 1"),
            Book("Title2", "Author 2"),
            Book("Title3", "Author 3"),
        )
    }
}