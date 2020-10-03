package com.revinton.pay.ui.notifications

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.revinton.pay.R
import com.revinton.pay.databinding.NotificationsFragmentBinding
import dagger.android.support.DaggerFragment

class NotificationsFragment : DaggerFragment() {

    private lateinit var binding: NotificationsFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.notifications_fragment,
            container,
            false
        )
        return binding.root
    }
}