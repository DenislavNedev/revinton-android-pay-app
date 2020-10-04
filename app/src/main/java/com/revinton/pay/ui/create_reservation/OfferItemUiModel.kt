package com.revinton.pay.ui.create_reservation

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.library.baseAdapters.BR
import com.revinton.pay.utils.Constants.DEFAULT_QUANTITY
import com.revinton.pay.utils.Constants.EMPTY_STRING
import kotlin.properties.Delegates

data class OfferItemUiModel(val id: String) : BaseObservable() {

    @get:Bindable
    var offerName: String by Delegates.observable(EMPTY_STRING) { _, _, _ ->
        notifyPropertyChanged(BR.placeName)
    }

    @get:Bindable
    var quantity: Int by Delegates.observable(DEFAULT_QUANTITY) { _, _, _ ->
        notifyPropertyChanged(BR.quantity)
    }

    @get:Bindable
    var offerImageUrl: String by Delegates.observable(EMPTY_STRING) { _, _, _ ->
        notifyPropertyChanged(BR.offerImageUrl)
    }
}