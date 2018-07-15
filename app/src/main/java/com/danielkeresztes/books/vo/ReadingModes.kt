package com.danielkeresztes.books.vo

import com.squareup.moshi.Json


data class ReadingModes (

    @Json(name = "text") val text: Boolean,
    @Json(name = "image") val image: Boolean

)