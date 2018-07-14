package com.danielkeresztes.books.di

import com.danielkeresztes.books.ui.list.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilderModule {

    @ContributesAndroidInjector()
    abstract fun bindMainActivity(): MainActivity

}