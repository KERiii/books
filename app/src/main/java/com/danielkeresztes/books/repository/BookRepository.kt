package com.danielkeresztes.books.repository

import com.danielkeresztes.books.*
import com.danielkeresztes.books.vo.VolumeResponse
import com.danielkeresztes.books.network.BookService
import io.reactivex.Single
import javax.inject.Inject

class BookRepository @Inject constructor(private val bookService: BookService) {

    fun loadBookList() : Single<VolumeResponse> = bookService.search(hashMapOf(API_QUERY_PARAM to SEARCH_DEFAULT,
            API_QUERY_MAXRESULTS to SEARCH_MAXRESULTS))
}
