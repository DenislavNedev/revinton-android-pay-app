package com.revinton.pay.data

import com.revinton.pay.ui.places.ItemPlaceUiModel
import com.squareup.moshi.JsonClass
import java.util.*

@JsonClass(generateAdapter = true)
data class PlaceResponse(
    val id: String,
    val name: String,
    val address: String,
    val rating: Double,
    val image: String
)

fun PlaceResponse.convertToItemPlaceUiModel() = ItemPlaceUiModel(id).apply {
    placeName = name.toUpperCase(Locale.getDefault())
    placeAddress = address
    placeImageUrl = image
}