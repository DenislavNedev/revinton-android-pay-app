package com.revinton.pay.di.modules

import androidx.lifecycle.ViewModel
import com.revinton.pay.di.ViewModelKey
import com.revinton.pay.ui.places.PlacesViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(PlacesViewModel::class)
    abstract fun bindPlacesViewModel(viewModel: PlacesViewModel): ViewModel

}