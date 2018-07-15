package com.danielkeresztes.books.di

import com.danielkeresztes.books.ui.details.BookDetailsActivity
import com.danielkeresztes.books.ui.list.BookListActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilderModule {

    @ContributesAndroidInjector()
    abstract fun bindBookListActivity(): BookListActivity

    @ContributesAndroidInjector()
    abstract fun bindBookDetailsActivity(): BookDetailsActivity

}