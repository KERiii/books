package com.danielkeresztes.books.vo

import com.squareup.moshi.Json


data class RetailPrice (

    @Json(name = "amount") val amount: Double,
    @Json(name = "currencyCode") val currencyCode: String

)