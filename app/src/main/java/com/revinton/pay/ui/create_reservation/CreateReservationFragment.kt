package com.revinton.pay.ui.create_reservation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.revinton.pay.R
import com.revinton.pay.databinding.CreateReservationFragmentBinding
import com.revinton.pay.utils.Constants.EMPTY_STRING
import com.revinton.pay.utils.Constants.RESERVATION_PLACE_ID_KEY
import com.revinton.pay.utils.Constants.RESERVATION_PLACE_IMAGE_URL_KEY
import com.revinton.pay.utils.Constants.RESERVATION_PLACE_NAME_KEY
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.create_reservation_fragment.*
import javax.inject.Inject

class CreateReservationFragment : DaggerFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel: CreateReservationViewModel by activityViewModels { viewModelFactory }

    lateinit var binding: CreateReservationFragmentBinding
    private val offersListAdapter by lazy { SpecialOffersListAdapter(viewModel) }
    private val peopleListAdapter by lazy { PeopleListAdapter() }

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

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel.initViewModel(
            arguments?.getString(RESERVATION_PLACE_ID_KEY) ?: EMPTY_STRING,
            arguments?.getString(RESERVATION_PLACE_NAME_KEY) ?: EMPTY_STRING,
            arguments?.getString(RESERVATION_PLACE_IMAGE_URL_KEY) ?: EMPTY_STRING
        )
        observeUiModel()
        initRecyclerView()
    }

    private fun observeUiModel() {
        viewModel.uiModel.observe(viewLifecycleOwner, {
            binding.uiModel = it
            offersListAdapter.submitList(it.listOfOffers)
            peopleListAdapter.submitList(it.listOfPeople)
        })
    }

    private fun initRecyclerView() {
        with(offersRecyclerView) {
            layoutManager =
                LinearLayoutManager(
                    requireContext(),
                    LinearLayoutManager.HORIZONTAL, false
                )
            adapter = offersListAdapter
        }

        with(peopleRecyclerView) {
            layoutManager =
                LinearLayoutManager(
                    requireContext(),
                    LinearLayoutManager.HORIZONTAL, false
                )
            adapter = peopleListAdapter
        }
    }
}