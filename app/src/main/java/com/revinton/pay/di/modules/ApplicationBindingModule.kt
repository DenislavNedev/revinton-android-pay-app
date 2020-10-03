package com.revinton.pay.di.modules

import com.revinton.pay.ui.main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface ApplicationBindingModule {

    @ContributesAndroidInjector
    fun mainActivity(): MainActivity
}