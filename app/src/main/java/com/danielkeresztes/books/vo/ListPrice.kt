package com.danielkeresztes.books.vo

import com.squareup.moshi.Json


data class ListPrice (

    @Json(name = "amount") val amount: Double,
    @Json(name = "currencyCode") val currencyCode: String

)