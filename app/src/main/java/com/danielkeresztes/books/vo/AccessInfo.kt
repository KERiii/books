package com.danielkeresztes.books.vo

import com.squareup.moshi.Json


data class AccessInfo (

    @Json(name = "country") val country: String,
    @Json(name = "viewability") val viewability: String,
    @Json(name = "embeddable") val embeddable: Boolean,
    @Json(name = "publicDomain") val publicDomain: Boolean,
    @Json(name = "textToSpeechPermission") val textToSpeechPermission: String,
    @Json(name = "epub") val epub: Epub,
    @Json(name = "pdf") val pdf: Pdf,
    @Json(name = "webReaderLink") val webReaderLink: String,
    @Json(name = "accessViewStatus") val accessViewStatus: String,
    @Json(name = "quoteSharingAllowed") val quoteSharingAllowed: Boolean

)