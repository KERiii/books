package com.danielkeresztes.books.vo

import com.squareup.moshi.Json


data class SaleInfo (

    @Json(name = "country") val country: String,
    @Json(name = "saleability") val saleability: String,
    @Json(name = "isEbook") val isEbook: Boolean,
    @Json(name = "listPrice") val listPrice: ListPrice,
    @Json(name = "retailPrice") val retailPrice: RetailPrice,
    @Json(name = "buyLink") val buyLink: String,
    @Json(name = "offers") val offers: List<Offer>

)
