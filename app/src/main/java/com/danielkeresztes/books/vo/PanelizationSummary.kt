package com.danielkeresztes.books.vo

import com.squareup.moshi.Json


data class PanelizationSummary (

    @Json(name = "containsEpubBubbles") val containsEpubBubbles: Boolean,
    @Json(name = "containsImageBubbles") val containsImageBubbles: Boolean

)