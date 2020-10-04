package com.revinton.pay.repositories.places

import com.revinton.pay.data.PlaceResponse
import com.revinton.pay.data.convertToItemPlaceUiModel
import com.revinton.pay.di.modules.RepositoryModule
import retrofit2.Response
import javax.inject.Inject

class PlacesRepository @Inject constructor(
    @RepositoryModule.PlacesRemoteSourceData private val remoteSource: RemoteSource
) {
    interface RemoteSource {
        suspend fun getPlaces(): Response<List<PlaceResponse>>
    }

    suspend fun getPlaces() = remoteSource.getPlaces().body()?.let {
        it.map { place -> place.convertToItemPlaceUiModel() }
    }

}