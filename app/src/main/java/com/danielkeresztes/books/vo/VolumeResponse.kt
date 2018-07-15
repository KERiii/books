package com.danielkeresztes.books.vo

import com.squareup.moshi.Json


data class VolumeResponse(

    @Json(name = "kind") val kind: String,
    @Json(name = "totalItems") val totalItems: Int,
    @Json(name = "items") val items: List<Item>

)