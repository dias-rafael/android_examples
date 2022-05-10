package com.example.rafaeldias.nybooks.presentation.books

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.rafaeldias.nybooks.data.model.Book

class BooksViewModel : ViewModel() {

    val booksLiveData: MutableLiveData<List<Book>> = MutableLiveData()

    fun getBooks() {
        booksLiveData.value = createBooksMock()
    }

    fun createBooksMock(): List<Book> {
        return listOf<Book>(
            Book("Title1", "Author 1"),
            Book("Title2", "Author 2"),
            Book("Title3", "Author 3"),
        )
    }
}