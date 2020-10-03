package com.revinton.pay.ui.create_reservation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.revinton.pay.R
import com.revinton.pay.databinding.CreateReservationFragmentBinding
import dagger.android.support.DaggerFragment

class CreateReservationFragment : DaggerFragment() {

    lateinit var binding: CreateReservationFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.create_reservation_fragment,
            container,
            false
        )
        return binding.root
    }

}