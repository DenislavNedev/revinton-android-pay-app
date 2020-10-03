package com.revinton.pay.di.modules

import com.revinton.pay.ui.favorites.FavoritesFragment
import com.revinton.pay.ui.places.PlacesFragment
import com.revinton.pay.ui.main.MainActivity
import com.revinton.pay.ui.notifications.NotificationsFragment
import com.revinton.pay.ui.profile.ProfileFragment
import com.revinton.pay.ui.reservations.ReservationsFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface ApplicationBindingModule {

    @ContributesAndroidInjector
    fun mainActivity(): MainActivity

    @ContributesAndroidInjector
    fun placesFragment(): PlacesFragment

    @ContributesAndroidInjector
    fun profileFragment(): ProfileFragment

    @ContributesAndroidInjector
    fun favoritesFragment(): FavoritesFragment

    @ContributesAndroidInjector
    fun notificationsFragment(): NotificationsFragment

    @ContributesAndroidInjector
    fun reservationsFragment(): ReservationsFragment
}