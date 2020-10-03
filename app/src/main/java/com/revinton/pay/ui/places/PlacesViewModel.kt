package com.revinton.pay.ui.places

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import javax.inject.Inject

class PlacesViewModel @Inject constructor(application: Application) :
    AndroidViewModel(application) {

    private val _uiModel = MutableLiveData<PlacesUiModel>()
    val uiModel: LiveData<PlacesUiModel>
        get() = _uiModel
}