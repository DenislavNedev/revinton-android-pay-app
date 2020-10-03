package com.revinton.pay.ui.places

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.library.baseAdapters.BR
import com.revinton.pay.utils.Constants.EMPTY_STRING
import kotlin.properties.Delegates

data class ItemPlaceUiModel(val id: String) : BaseObservable() {

    @get:Bindable
    var placeName: String by Delegates.observable(EMPTY_STRING) { _, _, _ ->
        notifyPropertyChanged(BR.placeName)
    }

    @get:Bindable
    var placeImageUrl: String by Delegates.observable(EMPTY_STRING) { _, _, _ ->
        notifyPropertyChanged(BR.placeImageUrl)
    }

    @get:Bindable
    var placeAddress: String by Delegates.observable(EMPTY_STRING) { _, _, _ ->
        notifyPropertyChanged(BR.placeAddress)
    }

    //TODO add rating
}