package com.danielkeresztes.books.vo

import com.squareup.moshi.Json


data class Pdf (

    @Json(name = "isAvailable") val isAvailable: Boolean,
    @Json(name = "acsTokenLink") val acsTokenLink: String

)
