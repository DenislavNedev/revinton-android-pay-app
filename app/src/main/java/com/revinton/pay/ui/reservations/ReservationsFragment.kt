package com.revinton.pay.ui.reservations

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.revinton.pay.R
import com.revinton.pay.databinding.ReservationsFragmentBinding
import dagger.android.support.DaggerFragment

class ReservationsFragment : DaggerFragment() {

    private lateinit var binding: ReservationsFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.reservations_fragment,
            container,
            false
        )
        return binding.root
    }
}
