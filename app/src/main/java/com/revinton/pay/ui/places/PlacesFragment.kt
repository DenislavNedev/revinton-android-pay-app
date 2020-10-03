package com.revinton.pay.ui.places

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.revinton.pay.R
import com.revinton.pay.databinding.PlacesFragmentBinding
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.places_fragment.*
import javax.inject.Inject

class PlacesFragment : DaggerFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel: PlacesViewModel by activityViewModels { viewModelFactory }

    private lateinit var binding: PlacesFragmentBinding
    private val placesListAdapter by lazy { PlacesListAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.places_fragment,
            container,
            false
        )
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initRecyclerView()
        observeUiModel()
    }

    private fun observeUiModel() {
        viewModel.uiModel.observe(viewLifecycleOwner, {
            binding.uiModel = it
            placesListAdapter.submitList(it.listOfPlaces)
        })
    }

    private fun initRecyclerView() {
        with(placesRecyclerView) {
            layoutManager = LinearLayoutManager(context)
            adapter = placesListAdapter
        }
    }
}