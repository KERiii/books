package com.danielkeresztes.books.vo

import com.squareup.moshi.Json


data class Epub (

    @Json(name = "isAvailable") val isAvailable: Boolean,
    @Json(name = "acsTokenLink") val acsTokenLink: String

)