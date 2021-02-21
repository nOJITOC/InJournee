package ru.mmteams91.quest.data.network.dto


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Location(
    @Json(name = "lat")
    val lat: Double,
    @Json(name = "lng")
    val lng: Double
)