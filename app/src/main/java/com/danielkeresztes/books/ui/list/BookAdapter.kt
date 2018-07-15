package com.danielkeresztes.books.ui.list

import android.support.v4.view.ViewCompat
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.danielkeresztes.books.R
import com.danielkeresztes.books.vo.Item
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.list_item_book.view.*


class BookAdapter(private val itemList: List<Item>,
                  private val bookItemClickListener: BookItemClickListener) : RecyclerView.Adapter<BookAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.list_item_book, parent, false))
    }

    override fun getItemCount(): Int = itemList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item: Item = itemList[position]
        holder.bookTitle.text = item.volumeInfo.title
        Picasso.get().load(item.volumeInfo.imageLinks.smallThumbnail).into(holder.bookImage)

        ViewCompat.setTransitionName(holder.bookImage, item.volumeInfo.imageLinks.smallThumbnail)
        ViewCompat.setTransitionName(holder.bookTitle, item.volumeInfo.title)
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val bookImage: ImageView = view.itemBookImage
        val bookTitle: TextView = view.itemBookTitle

        init {
            itemView.setOnClickListener { bookItemClickListener.onBookCicked(itemList[adapterPosition],  bookImage, bookTitle) }
        }
    }

    interface BookItemClickListener {
        fun onBookCicked(item: Item, sharedImageView: View, sharedTextView: View)
    }
}