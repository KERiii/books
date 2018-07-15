package com.danielkeresztes.books.ui.list

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.danielkeresztes.books.vo.VolumeResponse
import com.danielkeresztes.books.repository.BookRepository
import com.danielkeresztes.books.vo.Item
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.functions.Consumer
import javax.inject.Inject


class BookListViewModel @Inject constructor(private val bookRepository: BookRepository) : ViewModel() {

    private val disposable: CompositeDisposable = CompositeDisposable()
    var booksResult: MutableLiveData<List<Item>> = MutableLiveData()
    var booksError: MutableLiveData<String> = MutableLiveData()
    var isLoading: MutableLiveData<Boolean> = MutableLiveData()

    init {
        loadBooks()
    }

    private fun loadBooks() {
        disposable.add(bookRepository.loadBookList()
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe { isLoading.value = true }
                .doOnEvent { _, _ -> isLoading.value = false }
                .subscribe(
                        { response: VolumeResponse? -> booksResult.value = response?.items },
                        { t: Throwable? -> booksError.value = t?.message }
                )
        )

    }

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }
}