package com.danielkeresztes.books.vo

import com.squareup.moshi.Json


data class Offer (

    @Json(name = "finskyOfferType") val finskyOfferType: Int,
    @Json(name = "listPrice") val listPrice: ListPrice,
    @Json(name = "retailPrice") val retailPrice: RetailPrice

)
