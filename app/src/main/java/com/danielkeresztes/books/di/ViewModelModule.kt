package com.danielkeresztes.books.di

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.danielkeresztes.books.ui.list.BookListViewModel
import com.danielkeresztes.books.viewmodel.ViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(BookListViewModel::class)
    abstract fun bindBookListViewModel(bookListViewModel: BookListViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}