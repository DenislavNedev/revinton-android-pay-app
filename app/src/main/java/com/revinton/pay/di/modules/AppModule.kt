package com.revinton.pay.di.modules

import android.app.Application
import com.revinton.pay.RevintonPayApplication
import dagger.Module
import dagger.Provides

@Module
object AppModule {
    @Provides
    fun provideContext(application: RevintonPayApplication): Application = application
}
