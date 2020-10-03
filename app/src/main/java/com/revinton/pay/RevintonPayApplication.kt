package com.revinton.pay

import androidx.databinding.DataBindingUtil
import com.revinton.pay.di.DaggerAppComponent
import com.revinton.pay.ui.binding.AppDataBindingComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class RevintonPayApplication : DaggerApplication() {

    override fun onCreate() {
        super.onCreate()
        DataBindingUtil.setDefaultComponent(AppDataBindingComponent())
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> =
        DaggerAppComponent.builder().application(this@RevintonPayApplication).build()
}