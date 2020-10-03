package com.revinton.pay.ui.places

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.library.baseAdapters.BR
import com.revinton.pay.utils.Constants.DEFAULT_EDIT_TEXT_VALUE
import kotlin.properties.Delegates

class PlacesUiModel(val listOfPlaces: List<ItemPlaceUiModel>) : BaseObservable() {

    @get:Bindable
    var username: String by Delegates.observable(DEFAULT_EDIT_TEXT_VALUE) { _, _, _ ->
        notifyPropertyChanged(BR.username)
    }
}