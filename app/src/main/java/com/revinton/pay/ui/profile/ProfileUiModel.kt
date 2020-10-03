package com.revinton.pay.ui.profile

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.library.baseAdapters.BR
import kotlin.properties.Delegates

data class ProfileUiModel(
    val qrCodeUrl: String,
    val profilePictureUrl: String
) : BaseObservable() {

    @get:Bindable
    var currentImageUrl: String? by Delegates.observable(null) { _, _, _ ->
        notifyPropertyChanged(BR.currentImageUrl)
    }
}