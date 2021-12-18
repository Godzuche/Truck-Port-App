package com.godzuche.truckport.ui.dashboard.customer

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.godzuche.truckport.R
import com.godzuche.truckport.databinding.FragmentCustomerDashboardBinding

class CustomerDashboardFragment : Fragment() {
    private lateinit var binding: FragmentCustomerDashboardBinding
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentCustomerDashboardBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        recyclerView = binding.rvServices
        recyclerView.adapter = CustomerDbRecyclerAdapter(requireContext())
        recyclerView.setHasFixedSize(true)
    }

}