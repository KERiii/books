package com.danielkeresztes.books.vo

import com.squareup.moshi.Json


data class Item (

    @Json(name = "kind") val kind: String,
    @Json(name = "id") val id: String,
    @Json(name = "etag") val etag: String,
    @Json(name = "selfLink") val selfLink: String,
    @Json(name = "volumeInfo") val volumeInfo: VolumeInfo,
    @Json(name = "saleInfo") val saleInfo: SaleInfo,
    @Json(name = "accessInfo") val accessInfo: AccessInfo,
    @Json(name = "searchInfo") val searchInfo: SearchInfo

)