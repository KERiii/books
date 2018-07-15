package com.danielkeresztes.books.vo

import com.squareup.moshi.Json


data class SearchInfo (

    @Json(name = "textSnippet") val textSnippet: String

)