package ru.mmteams91.quest.data


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class NearestPlaceItemResponse(
    @Json(name = "business_status")
    val businessStatus: String,
    @Json(name = "geometry")
    val geometry: Geometry,
    @Json(name = "icon")
    val icon: String,
    @Json(name = "name")
    val name: String,
    @Json(name = "opening_hours")
    val openingHours: OpeningHours,
    @Json(name = "photos")
    val photos: List<Photo>,
    @Json(name = "place_id")
    val placeId: String,
    @Json(name = "plus_code")
    val plusCode: PlusCode,
    @Json(name = "price_level")
    val priceLevel: Int,
    @Json(name = "rating")
    val rating: Double,
    @Json(name = "reference")
    val reference: String,
    @Json(name = "scope")
    val scope: String,
    @Json(name = "types")
    val types: List<String>,
    @Json(name = "user_ratings_total")
    val userRatingsTotal: Int,
    @Json(name = "vicinity")
    val vicinity: String
)