package com.revinton.pay.navigation

import android.os.Bundle
import androidx.annotation.IdRes
import androidx.fragment.app.FragmentActivity
import androidx.navigation.fragment.findNavController
import com.revinton.pay.ui.main.MainActivity
import kotlinx.android.synthetic.main.activity_main.*

fun FragmentActivity.navigateTo(navigateTo: NavigateTo) {
    when (navigateTo) {
        is GraphNavigation -> navigateWithNavGraph(
            navigateTo.actionId,
            navigateTo.bundle
        )
    }
}

private fun FragmentActivity.navigateWithNavGraph(
    @IdRes actionId: Int,
    bundle: Bundle?
) {
    if (this is MainActivity) {
        nav_host_fragment.findNavController().navigate(actionId, bundle)
    }
}