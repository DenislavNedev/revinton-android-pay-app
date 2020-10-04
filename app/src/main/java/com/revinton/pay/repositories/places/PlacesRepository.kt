package com.revinton.pay.repositories.places

import com.revinton.pay.data.OffersResponse
import com.revinton.pay.data.PlaceResponse
import com.revinton.pay.data.convertToItemPlaceUiModel
import com.revinton.pay.data.convertToOfferItemUiModel
import com.revinton.pay.di.modules.RepositoryModule
import retrofit2.Response
import javax.inject.Inject

class PlacesRepository @Inject constructor(
    @RepositoryModule.PlacesRemoteSourceData private val remoteSource: RemoteSource
) {
    interface RemoteSource {
        suspend fun getPlaces(): Response<List<PlaceResponse>>
        suspend fun getOffers(id: String): Response<List<OffersResponse>>
    }

    suspend fun getPlaces() = remoteSource.getPlaces().body()?.let {
        it.map { place -> place.convertToItemPlaceUiModel() }
    }

    suspend fun getOffers(id: String) = remoteSource.getOffers(id).body()?.let {
        it.map { offer -> offer.convertToOfferItemUiModel() }
    }
}