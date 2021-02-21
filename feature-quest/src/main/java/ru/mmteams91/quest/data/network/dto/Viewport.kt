package ru.mmteams91.quest.data.network.dto


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Viewport(
    @Json(name = "northeast")
    val northeast: Location,
    @Json(name = "southwest")
    val southwest: Location
)