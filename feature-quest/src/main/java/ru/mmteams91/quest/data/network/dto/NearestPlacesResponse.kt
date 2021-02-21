package ru.mmteams91.quest.data.network.dto


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class NearestPlacesResponse(
    @Json(name = "html_attributions")
    val htmlAttributions: List<Any>,
    @Json(name = "next_page_token")
    val nextPageToken: String,
    @Json(name = "results")
    val results: List<NearestPlaceItemResponse>,
    @Json(name = "status")
    val status: String
)