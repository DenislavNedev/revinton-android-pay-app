package com.revinton.pay.ui.create_reservation

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.library.baseAdapters.BR
import com.revinton.pay.utils.Constants
import kotlin.properties.Delegates

data class PeopleItemUiModel(val id: String) : BaseObservable() {

    @get:Bindable
    var personName: String by Delegates.observable(Constants.EMPTY_STRING) { _, _, _ ->
        notifyPropertyChanged(BR.placeName)
    }

    @get:Bindable
    var profilePictureUrl: Int by Delegates.observable(Constants.DEFAULT_QUANTITY) { _, _, _ ->
        notifyPropertyChanged(BR.quantity)
    }
}