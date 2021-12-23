package com.carroza.logistics.carroza_app.ui.customer.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.carroza.logistics.carroza_app.databinding.FragmentCustomerDashboardBinding

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