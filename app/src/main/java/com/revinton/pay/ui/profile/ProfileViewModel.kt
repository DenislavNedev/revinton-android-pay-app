package com.revinton.pay.ui.profile

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import javax.inject.Inject

class ProfileViewModel @Inject constructor(application: Application) :
    AndroidViewModel(application), ProfilePresenter {

    private val _uiModel = MutableLiveData<ProfileUiModel>()
    val uiModel: LiveData<ProfileUiModel>
        get() = _uiModel

    override fun showQrCode() {
        _uiModel.value?.currentImageUrl =
            _uiModel.value?.let {
                if (it.currentImageUrl == it.profilePictureUrl) it.qrCodeUrl
                else it.profilePictureUrl
            }
    }

    override fun openPaymentMethods() {
        //TODO("Not yet implemented")
    }
}