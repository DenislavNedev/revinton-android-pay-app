package com.revinton.pay.ui.places

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import com.revinton.pay.R
import com.revinton.pay.databinding.ItemPlaceLayoutBinding
import com.revinton.pay.utils.DataBoundListAdapter

class PlacesListAdapter(private val presenter: ItemPlacePresenter) :
    DataBoundListAdapter<ItemPlaceUiModel, ItemPlaceLayoutBinding>(PlaceItemDiffUtil()) {

    override fun createBinding(parent: ViewGroup, viewType: Int): ItemPlaceLayoutBinding =
        DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_place_layout,
            parent,
            false
        )

    override fun bind(binding: ItemPlaceLayoutBinding, item: ItemPlaceUiModel) {
        binding.uiModel = item
        binding.presenter = presenter
    }
}

class PlaceItemDiffUtil : DiffUtil.ItemCallback<ItemPlaceUiModel>() {
    override fun areItemsTheSame(oldItem: ItemPlaceUiModel, newItem: ItemPlaceUiModel): Boolean =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: ItemPlaceUiModel, newItem: ItemPlaceUiModel): Boolean =
        oldItem == newItem

}
