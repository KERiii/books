package com.danielkeresztes.books.ui.details

import android.os.Bundle
import com.danielkeresztes.books.*
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_book_details.*
import android.os.Build


class BookDetailsActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_details)

        val extras = intent.extras

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val imageTransitionName = extras.getString(ARG_DETAILS_IMAGE_TRANSITION_NAME)
            val titleTransitionName = extras.getString(ARG_DETAILS_TITLE_TRANSITION_NAME)
            bookDetailsImage.transitionName = imageTransitionName
            bookDetailsTitle.transitionName = titleTransitionName
        }

        Picasso.get().load(extras.getString(ARG_DETAILS_IMAGE_URL)).into(bookDetailsImage)
        bookDetailsTitle.text = extras.getString(ARG_DETAILS_TITLE)
        bookDetailsAuthor.text = extras.getString(ARG_DETAILS_AUTHOR)
        bookDetailsPublisher.text = extras.getString(ARG_DETAILS_PUBLISHER)
        bookDetailsPublishDate.text = extras.getString(ARG_DETAILS_DATE)
        bookDetailsDescription.text = extras.getString(ARG_DETAILS_DESCRIPTION)

    }
}
