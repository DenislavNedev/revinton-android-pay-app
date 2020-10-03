package com.revinton.pay.ui.favorites

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.revinton.pay.R
import com.revinton.pay.databinding.FavoritesFragmentBinding
import dagger.android.support.DaggerFragment

class FavoritesFragment : DaggerFragment() {

    private lateinit var binding: FavoritesFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.favorites_fragment,
            container,
            false
        )
        return binding.root
    }
}