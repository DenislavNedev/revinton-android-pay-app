package com.revinton.pay.ui.places

interface ItemPlacePresenter {
    fun createReservation(placeId: String, placeName: String, placeImageUrl: String)
}