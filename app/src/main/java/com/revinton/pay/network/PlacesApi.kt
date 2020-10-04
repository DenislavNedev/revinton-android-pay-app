package com.revinton.pay.network

import com.revinton.pay.data.OffersResponse
import com.revinton.pay.data.PlaceResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import javax.inject.Inject

interface PlacesApiService {
    @GET("api/places/")
    suspend fun getPlaces(): Response<List<PlaceResponse>>

    @GET("api/places/{uuid}/offers")
    suspend fun getOffersById(@Path("uuid") id: String): Response<List<OffersResponse>>
}

class PlacesApi @Inject constructor(private val apiService: PlacesApiService) {
    suspend fun getPlaces() = withContext(Dispatchers.IO) {
        apiService.getPlaces()
    }

    suspend fun getOffers(id: String) = withContext(Dispatchers.IO) {
        apiService.getOffersById(id)
    }
}

