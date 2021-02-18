package ru.mmteams91.quest.data


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Geometry(
    @Json(name = "location")
    val location: Location,
    @Json(name = "viewport")
    val viewport: Viewport
)