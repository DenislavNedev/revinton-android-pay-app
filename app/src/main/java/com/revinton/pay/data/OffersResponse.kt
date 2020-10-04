package com.revinton.pay.data

import com.revinton.pay.ui.create_reservation.OfferItemUiModel
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class OffersResponse(
    val id: String,
    val name: String,
    val image: String,
    val price: Double,
    val placeId: String
)

fun OffersResponse.convertToOfferItemUiModel() = OfferItemUiModel(id).apply {
    offerName = "$name : $price BGN"
    offerImageUrl = image
}