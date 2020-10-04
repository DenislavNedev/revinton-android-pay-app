package com.revinton.pay.repositories.places

import com.revinton.pay.data.OffersResponse
import com.revinton.pay.data.PlaceResponse
import com.revinton.pay.network.PlacesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import javax.inject.Inject

class PlacesRemoteSource @Inject constructor(private val placesApi: PlacesApi) :
    PlacesRepository.RemoteSource {
    override suspend fun getPlaces(): Response<List<PlaceResponse>> = withContext(Dispatchers.IO) {
        placesApi.getPlaces()
    }

    override suspend fun getOffers(id: String): Response<List<OffersResponse>> =
        withContext(Dispatchers.IO) {
            placesApi.getOffers(id)
        }

}