package com.revinton.pay.ui.create_reservation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import javax.inject.Inject

class CreateReservationViewModel @Inject constructor(application: Application) :
    AndroidViewModel(application),
    OfferItemPresenter {

    private val _uiModel = MutableLiveData<CreateReservationUiModel>()
    val uiModel: LiveData<CreateReservationUiModel>
        get() = _uiModel

    fun initViewModel(placeId: String, placeName: String, placeImageUrl: String) {

    }

    override fun addOffer(offerItemUiModel: OfferItemUiModel) {
        offerItemUiModel.quantity++
    }

    override fun removeOffer(offerItemUiModel: OfferItemUiModel) {
        with(offerItemUiModel) {
            if (quantity != 0) quantity--
        }
    }

}