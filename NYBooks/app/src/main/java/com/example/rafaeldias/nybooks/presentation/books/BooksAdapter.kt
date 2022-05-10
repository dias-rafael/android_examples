package com.example.rafaeldias.nybooks.presentation.books

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.rafaeldias.nybooks.data.model.Book
import com.example.rafaeldias.nybooks.databinding.ItemBookBinding

class BooksAdapter(private val books: List<Book>): RecyclerView.Adapter<BooksAdapter.BooksViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BooksViewHolder {
        //val view = LayoutInflater.from(parent.context).inflate(R.layout.item_book, parent,false)
        val view = ItemBookBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BooksViewHolder(view)
    }

    override fun onBindViewHolder(holder: BooksViewHolder, position: Int) {
        holder.bindView(books[position])
    }

    override fun getItemCount() = books.count()

    class BooksViewHolder(itemView: ItemBookBinding) : RecyclerView.ViewHolder(itemView.root) {

        private val title = itemView.textTitle
        private val author = itemView.textAuthor

        fun bindView(book: Book) {
            title.text = book.title
            author.text = book.author
        }
    }
}
