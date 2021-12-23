package com.carroza.logistics.carroza_app.ui.auth.signup

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.carroza.logistics.carroza_app.databinding.FragmentOtpVerificationBinding

class OtpVerificationFragment : Fragment() {
    private lateinit var binding: FragmentOtpVerificationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentOtpVerificationBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.apply {
            btProceed.setOnClickListener { proceedToUserRegFragment() }
        }
    }

    private fun proceedToUserRegFragment() {
        val action =
            OtpVerificationFragmentDirections.actionOtpVerificationFragmentToUserRegistrationFragment()
        findNavController().navigate(action)
    }

}