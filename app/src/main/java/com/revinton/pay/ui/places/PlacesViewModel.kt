package com.revinton.pay.ui.places

import android.app.Application
import androidx.core.os.bundleOf
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.revinton.pay.R
import com.revinton.pay.navigation.GraphNavigation
import com.revinton.pay.navigation.NavigateTo
import com.revinton.pay.utils.Constants.RESERVATION_PLACE_ID_KEY
import com.revinton.pay.utils.SingleLiveEvent
import javax.inject.Inject

class PlacesViewModel @Inject constructor(application: Application) :
    AndroidViewModel(application),
    ItemPlacePresenter {

    private val _uiModel = MutableLiveData<PlacesUiModel>()
    val uiModel: LiveData<PlacesUiModel>
        get() = _uiModel

    private val _navigation = SingleLiveEvent<NavigateTo>()
    val navigation: LiveData<NavigateTo>
        get() = _navigation

    init {
        _uiModel.value = PlacesUiModel(listOf(ItemPlaceUiModel("dsadas").apply {
            placeImageUrl = "sadeads"
            placeAddress = "dsadea"
            placeName = "sdadeasdeas"
        }))
    }

    override fun createReservation(placeId: String) {
        _navigation.value = GraphNavigation(
            R.id.action_places_to_createReservationFragment,
            bundleOf(RESERVATION_PLACE_ID_KEY to placeId)
        )
    }
}