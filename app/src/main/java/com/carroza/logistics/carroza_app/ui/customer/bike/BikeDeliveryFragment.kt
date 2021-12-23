package com.carroza.logistics.carroza_app.ui.customer.bike

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.carroza.logistics.carroza_app.databinding.FragmentBikeDeliveryBinding


class BikeDeliveryFragment : Fragment() {
    private lateinit var binding: FragmentBikeDeliveryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentBikeDeliveryBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.apply {
            btContinue.setOnClickListener { continueToDeliveryDetails() }
        }
    }

    private fun continueToDeliveryDetails() {
        val action = BikeDeliveryFragmentDirections.actionBikeDeliveryFragmentToDeliveryDetailsFragment()
        findNavController().navigate(action)
    }

}