package com.godzuche.truckport.ui.customer.bike

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import com.godzuche.truckport.R
import com.godzuche.truckport.databinding.FragmentDeliveryDetailsBinding
import com.google.android.material.bottomsheet.BottomSheetBehavior


class DeliveryDetailsFragment : Fragment() {
    private lateinit var binding: FragmentDeliveryDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDeliveryDetailsBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        binding.apply {
        }
        setupDropDownMenus()
    }

    private fun setupDropDownMenus() {
        val adapter = ArrayAdapter(requireContext(), R.layout.drop_down_menu_item, resources.getStringArray(R.array.payment_methods))
        (binding.ilPaymentMethod.editText as? AutoCompleteTextView)?.setAdapter(adapter)
    }

}