package com.revinton.pay.ui.create_reservation

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.library.baseAdapters.BR
import com.revinton.pay.utils.Constants
import kotlin.properties.Delegates

data class CreateReservationUiModel(
    val listOfOffers: List<OfferItemUiModel>,
    val listOfPeople: List<PeopleItemUiModel>
) : BaseObservable() {

    @get:Bindable
    var placeName: String by Delegates.observable(Constants.EMPTY_STRING) { _, _, _ ->
        notifyPropertyChanged(BR.placeName)
    }

    @get:Bindable
    var placeImageUrl: String by Delegates.observable(Constants.EMPTY_STRING) { _, _, _ ->
        notifyPropertyChanged(BR.placeImageUrl)
    }
}