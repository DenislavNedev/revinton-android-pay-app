package com.revinton.pay.ui.create_reservation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.revinton.pay.repositories.places.PlacesRepository
import com.revinton.pay.utils.Constants.DEFAULT_QUANTITY
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

class CreateReservationViewModel @Inject constructor(
    application: Application,
    private val placesRepository: PlacesRepository
) : AndroidViewModel(application),
    OfferItemPresenter {

    private val _uiModel = MutableLiveData<CreateReservationUiModel>()
    val uiModel: LiveData<CreateReservationUiModel>
        get() = _uiModel

    fun initViewModel(placeId: String, name: String, imageUrl: String) {
        viewModelScope.launch {
            try {
                placesRepository.getOffers(placeId)?.let {
                    _uiModel.value = CreateReservationUiModel(it, getPeople()).apply {
                        placeName = name
                        placeImageUrl = imageUrl
                    }
                }
            } catch (exception: Exception) {
                //TODO show appropriate error message
            }
        }
    }

    //TODO Remove after demo
    private fun getPeople() = listOf(PeopleItemUiModel("id").apply {
        personName = "John"
        profilePictureUrl =
            "https://images.pexels.com/photos/1181391/pexels-photo-1181391.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500"
    },
        PeopleItemUiModel("id").apply {
            personName = "Travis"
            profilePictureUrl =
                "https://images.pexels.com/photos/2379005/pexels-photo-2379005.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940"
        },
        PeopleItemUiModel("id").apply {
            personName = "Darsi"
            profilePictureUrl =
                "https://images.pexels.com/photos/1130626/pexels-photo-1130626.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940"
        })

    override fun addOffer(offerItemUiModel: OfferItemUiModel) {
        offerItemUiModel.quantity++
    }

    override fun removeOffer(offerItemUiModel: OfferItemUiModel) {
        with(offerItemUiModel) {
            if (quantity != DEFAULT_QUANTITY) quantity--
        }
    }

}