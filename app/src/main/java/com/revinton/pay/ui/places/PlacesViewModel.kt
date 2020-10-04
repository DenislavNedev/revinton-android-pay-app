package com.revinton.pay.ui.places

import android.app.Application
import androidx.core.os.bundleOf
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.revinton.pay.R
import com.revinton.pay.navigation.GraphNavigation
import com.revinton.pay.navigation.NavigateTo
import com.revinton.pay.repositories.places.PlacesRepository
import com.revinton.pay.utils.Constants.RESERVATION_PLACE_ID_KEY
import com.revinton.pay.utils.Constants.RESERVATION_PLACE_IMAGE_URL_KEY
import com.revinton.pay.utils.Constants.RESERVATION_PLACE_NAME_KEY
import com.revinton.pay.utils.Constants.USERNAME
import com.revinton.pay.utils.SingleLiveEvent
import kotlinx.coroutines.launch
import javax.inject.Inject

class PlacesViewModel @Inject constructor(
    application: Application,
    private val placesRepository: PlacesRepository
) : AndroidViewModel(application),
    ItemPlacePresenter {

    private val _uiModel = MutableLiveData<PlacesUiModel>()
    val uiModel: LiveData<PlacesUiModel>
        get() = _uiModel

    private val _navigation = SingleLiveEvent<NavigateTo>()
    val navigation: LiveData<NavigateTo>
        get() = _navigation

    init {
        viewModelScope.launch {
            try {
                placesRepository.getPlaces()?.let {
                    _uiModel.value = PlacesUiModel(it).apply {
                        username = USERNAME
                    }
                }
            } catch (exception: Exception) {
                //TODO show appropriate error message
            }
        }
    }

    override fun createReservation(
        placeId: String,
        placeName: String,
        placeImageUrl: String
    ) {
        _navigation.value = GraphNavigation(
            R.id.action_places_to_createReservationFragment,
            bundleOf(
                RESERVATION_PLACE_ID_KEY to placeId,
                RESERVATION_PLACE_IMAGE_URL_KEY to placeImageUrl,
                RESERVATION_PLACE_NAME_KEY to placeName
            )
        )
    }
}