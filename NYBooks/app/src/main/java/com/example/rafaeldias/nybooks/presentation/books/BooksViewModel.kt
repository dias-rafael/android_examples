package com.example.rafaeldias.nybooks.presentation.books

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.rafaeldias.nybooks.data.ApiService
import com.example.rafaeldias.nybooks.data.model.Book
import com.example.rafaeldias.nybooks.data.response.BookBodyResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BooksViewModel : ViewModel() {

    val booksLiveData: MutableLiveData<List<Book>> = MutableLiveData()

    fun getBooks() {
        //booksLiveData.value = createBooksMock()
        ApiService.service.getBooks().enqueue(object: Callback<BookBodyResponse> { //forma assincrona
            override fun onResponse(
                call: Call<BookBodyResponse>,
                response: Response<BookBodyResponse>
            ) {
                if (response.isSuccessful) {
                    val books: MutableList<Book> = mutableListOf()
                    response.body()?.let { bookBodyResponse ->
                        for (results in bookBodyResponse.bookResults) {
                            val book: Book = Book(
                                title = results.bookDetails[0].title,
                                author = results.bookDetails[0].author
                            )

                            books.add(book)
                        }
                        booksLiveData.value = books
                    }
                }
            }

            override fun onFailure(call: Call<BookBodyResponse>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }

    fun createBooksMock(): List<Book> {
        return listOf<Book>(
            Book("Title1", "Author 1"),
            Book("Title2", "Author 2"),
            Book("Title3", "Author 3"),
        )
    }
}