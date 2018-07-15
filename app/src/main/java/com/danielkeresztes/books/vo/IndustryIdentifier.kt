package com.danielkeresztes.books.vo

import com.squareup.moshi.Json


data class IndustryIdentifier (

    @Json(name = "type") val type: String,
    @Json(name = "identifier") val identifier: String

)
