package com.danielkeresztes.books.di

import com.danielkeresztes.books.BookApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(
        AndroidSupportInjectionModule::class,
        ActivityBuilderModule::class,
        ApplicationModule::class))

interface ApplicationComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: BookApplication): Builder

        fun build(): ApplicationComponent
    }

    fun inject(app: BookApplication)
}
