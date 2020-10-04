package com.revinton.pay.di.modules

import androidx.lifecycle.ViewModel
import com.revinton.pay.di.ViewModelKey
import com.revinton.pay.ui.create_reservation.CreateReservationViewModel
import com.revinton.pay.ui.places.PlacesViewModel
import com.revinton.pay.ui.profile.ProfileViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(PlacesViewModel::class)
    abstract fun bindPlacesViewModel(viewModel: PlacesViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(ProfileViewModel::class)
    abstract fun bindProfileViewModel(viewModel: ProfileViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(CreateReservationViewModel::class)
    abstract fun bindCreateReservationViewModel(viewModel: CreateReservationViewModel): ViewModel
}