package com.revinton.pay.di.modules

import dagger.Module

@Module
class RepositoryModule {
    //TODO uncomment this seciton when repository is needed
//    @Qualifier
//    @Retention(AnnotationRetention.RUNTIME)
//    annotation class RevintonRemoteDataSource
//
//    @Singleton
//    @RevintonRemoteDataSource
//    @Provides
//    fun provideRevintonRemoteDataSource(revintonApi: RevintonApi): RevintonRepository.RemoteSource =
//        RevintonRemoteSource(revintonApi)
}