package com.revinton.pay.ui.binding

import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.StringRes
import androidx.databinding.BindingAdapter
import com.revinton.pay.R
import com.revinton.pay.utils.Constants.EMPTY_STRING
import com.squareup.picasso.Picasso

object AppBindingAdapter {
    @BindingAdapter("setTextResource")
    fun setTextResource(
        view: TextView,
        @StringRes stringResource: Int
    ) {
        if (stringResource != 0) {
            view.text = view.context.getString(stringResource)
        }
    }

    @BindingAdapter("setWelcomeMessage")
    fun setWelcomeMessage(
        view: TextView,
        username: String?
    ) {
        if (username != null) {
            view.text = view.context.getString(R.string.welcome_message, username)
        }
    }

    @BindingAdapter("setImageFromUrl")
    fun setImageFromUrl(
        view: ImageView,
        url: String?
    ) {
        if (url != EMPTY_STRING && url != null) {
            //TODO add placeholder
            Picasso.get()
                .load(url)
                .fit()
                .centerCrop()
                .into(view)
        }
    }
}