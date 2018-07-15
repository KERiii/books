package com.danielkeresztes.books.ui.list

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.app.ActivityOptionsCompat
import android.support.v4.util.Pair
import android.support.v4.view.ViewCompat
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.danielkeresztes.books.*
import com.danielkeresztes.books.ui.details.BookDetailsActivity
import com.danielkeresztes.books.vo.Item
import kotlinx.android.synthetic.main.activity_book_list.*


class BookListActivity : BaseActivity(), BookAdapter.BookItemClickListener {

    private lateinit var bookListViewModel: BookListViewModel
    private lateinit var adapter: BookAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_list)
        initView()
        bookListViewModel = ViewModelProviders.of(this, viewmodelFactory).get(BookListViewModel::class.java)
        bookListViewModel.isLoading.observe(this, Observer { isLoading ->
            if (isLoading!!) {
                booksProgressBar.visibility = View.VISIBLE
            } else {
                booksProgressBar.visibility = View.GONE
            }
        })

        bookListViewModel.booksResult.observe(this, Observer { items ->
            adapter = BookAdapter(items!!, this)
            booksRecyclerView.adapter = adapter
            adapter.notifyDataSetChanged()
        })

        bookListViewModel.booksError.observe(this, Observer { _ ->
            Snackbar.make(booksConstraintLayout, getString(R.string.loading_errror), Snackbar.LENGTH_LONG).show()
        })
    }

    private fun initView() {
        booksRecyclerView.layoutManager = LinearLayoutManager(this)
        booksRecyclerView.setHasFixedSize(true)
        booksRecyclerView.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
    }

    override fun onBookCicked(item: Item, sharedImageView: View, sharedTextView: View) {
        val intent = Intent(this, BookDetailsActivity::class.java)
        intent.putExtra(ARG_DETAILS_TITLE, item.volumeInfo.title)
        intent.putExtra(ARG_DETAILS_IMAGE_URL, item.volumeInfo.imageLinks.smallThumbnail)
        intent.putExtra(ARG_DETAILS_AUTHOR, item.volumeInfo.authors[0])
        intent.putExtra(ARG_DETAILS_DATE, item.volumeInfo.publishedDate)
        intent.putExtra(ARG_DETAILS_PUBLISHER, item.volumeInfo.publisher)
        intent.putExtra(ARG_DETAILS_DESCRIPTION, item.volumeInfo.description)
        intent.putExtra(ARG_DETAILS_IMAGE_TRANSITION_NAME, ViewCompat.getTransitionName(sharedImageView))
        intent.putExtra(ARG_DETAILS_TITLE_TRANSITION_NAME, ViewCompat.getTransitionName(sharedTextView))

        val options = ActivityOptionsCompat.makeSceneTransitionAnimation(
                this,
                Pair.create(sharedImageView, ViewCompat.getTransitionName(sharedImageView)),
                Pair(sharedTextView, ViewCompat.getTransitionName(sharedTextView)))

        startActivity(intent, options.toBundle())
    }
}
