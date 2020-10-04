package com.revinton.pay.di.modules

import com.revinton.pay.network.PlacesApi
import com.revinton.pay.repositories.places.PlacesRemoteSource
import com.revinton.pay.repositories.places.PlacesRepository
import dagger.Module
import dagger.Provides
import javax.inject.Qualifier
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Qualifier
    @Retention(AnnotationRetention.RUNTIME)
    annotation class PlacesRemoteSourceData

    @Singleton
    @PlacesRemoteSourceData
    @Provides
    fun providePlacesRemoteSource(placesApi: PlacesApi): PlacesRepository.RemoteSource =
        PlacesRemoteSource(placesApi)
}