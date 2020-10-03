package com.revinton.pay.ui.places

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.revinton.pay.R
import com.revinton.pay.databinding.PlacesFragmentBinding
import dagger.android.support.DaggerFragment

class PlacesFragment : DaggerFragment() {

    private lateinit var binding: PlacesFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.places_fragment,
            container,
            false
        )
        return binding.root
    }
}