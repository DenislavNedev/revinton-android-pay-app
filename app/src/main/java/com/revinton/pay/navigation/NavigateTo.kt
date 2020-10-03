package com.revinton.pay.navigation

import android.os.Bundle

sealed class NavigateTo
class GraphNavigation(
    val actionId: Int,
    val bundle: Bundle? = null
) : NavigateTo()
