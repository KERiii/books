package com.danielkeresztes.books.di

import dagger.MapKey
import android.arch.lifecycle.ViewModel
import kotlin.reflect.KClass


@Target(
        AnnotationTarget.FUNCTION,
        AnnotationTarget.PROPERTY_GETTER,
        AnnotationTarget.PROPERTY_SETTER
)
@Retention(AnnotationRetention.RUNTIME)
@MapKey
annotation class ViewModelKey(val value: KClass<out ViewModel>)