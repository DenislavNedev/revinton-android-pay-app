package com.revinton.pay.ui.create_reservation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import com.revinton.pay.R
import com.revinton.pay.databinding.ItemSpecialOfferBinding
import com.revinton.pay.utils.DataBoundListAdapter

class SpecialOffersListAdapter(private val presenter: OfferItemPresenter) :
    DataBoundListAdapter<OfferItemUiModel, ItemSpecialOfferBinding>(SpecialOffersDiffUtil()) {

    override fun createBinding(parent: ViewGroup, viewType: Int): ItemSpecialOfferBinding =
        DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_special_offer,
            parent,
            false
        )

    override fun bind(binding: ItemSpecialOfferBinding, item: OfferItemUiModel) {
        binding.uiModel = item
        binding.presenter = presenter
    }
}

class SpecialOffersDiffUtil : DiffUtil.ItemCallback<OfferItemUiModel>() {
    override fun areItemsTheSame(oldItem: OfferItemUiModel, newItem: OfferItemUiModel): Boolean =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: OfferItemUiModel, newItem: OfferItemUiModel): Boolean =
        oldItem == newItem

}