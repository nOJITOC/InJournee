package ru.mmteams91.quest.data.network.dto


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class OpeningHours(
    @Json(name = "open_now")
    val openNow: Boolean
)