package com.revinton.pay.network

import com.revinton.pay.data.PlaceResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import retrofit2.http.GET
import javax.inject.Inject

interface PlacesApiService {
    @GET("api/places/")
    suspend fun getPlaces(): Response<List<PlaceResponse>>
}

class PlacesApi @Inject constructor(private val apiService: PlacesApiService) {
    suspend fun getPlaces() = withContext(Dispatchers.IO) {
        apiService.getPlaces()
    }
}

