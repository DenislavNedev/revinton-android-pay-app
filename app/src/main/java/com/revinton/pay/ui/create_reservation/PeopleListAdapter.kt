package com.revinton.pay.ui.create_reservation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import com.revinton.pay.R
import com.revinton.pay.databinding.ItemPeopleBinding
import com.revinton.pay.utils.DataBoundListAdapter

class PeopleListAdapter :
    DataBoundListAdapter<PeopleItemUiModel, ItemPeopleBinding>(PeopleDiffUtil()) {

    override fun createBinding(parent: ViewGroup, viewType: Int): ItemPeopleBinding =
        DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_people,
            parent,
            false
        )

    override fun bind(binding: ItemPeopleBinding, item: PeopleItemUiModel) {
        binding.uiModel = item
    }
}

class PeopleDiffUtil : DiffUtil.ItemCallback<PeopleItemUiModel>() {
    override fun areItemsTheSame(oldItem: PeopleItemUiModel, newItem: PeopleItemUiModel): Boolean =
        oldItem.id == newItem.id

    override fun areContentsTheSame(
        oldItem: PeopleItemUiModel,
        newItem: PeopleItemUiModel
    ): Boolean =
        oldItem == newItem

}