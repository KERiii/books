package com.danielkeresztes.books.vo

import com.squareup.moshi.Json


data class VolumeInfo (

    @Json(name = "title") val title: String,
    @Json(name = "subtitle") val subtitle: String,
    @Json(name = "authors") val authors: List<String>,
    @Json(name = "publisher") val publisher: String,
    @Json(name = "publishedDate") val publishedDate: String,
    @Json(name = "description") val description: String,
    @Json(name = "industryIdentifiers") val industryIdentifiers: List<IndustryIdentifier>,
    @Json(name = "readingModes") val readingModes: ReadingModes,
    @Json(name = "pageCount") val pageCount: Int,
    @Json(name = "printType") val printType: String,
    @Json(name = "categories") val categories: List<String>,
    @Json(name = "maturityRating") val maturityRating: String,
    @Json(name = "allowAnonLogging") val allowAnonLogging: Boolean,
    @Json(name = "contentVersion") val contentVersion: String,
    @Json(name = "imageLinks") val imageLinks: ImageLinks,
    @Json(name = "language") val language: String,
    @Json(name = "previewLink") val previewLink: String,
    @Json(name = "infoLink") val infoLink: String,
    @Json(name = "canonicalVolumeLink") val canonicalVolumeLink: String,
    @Json(name = "panelizationSummary") val panelizationSummary: PanelizationSummary,
    @Json(name = "averageRating") val averageRating: Double,
    @Json(name = "ratingsCount") val ratingsCount: Int

)