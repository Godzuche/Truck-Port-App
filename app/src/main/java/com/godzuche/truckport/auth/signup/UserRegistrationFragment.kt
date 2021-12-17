package com.godzuche.truckport.auth.signup

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.godzuche.truckport.R
import com.godzuche.truckport.databinding.FragmentUserRegistrationBinding

class UserRegistrationFragment : Fragment() {
    private lateinit var binding: FragmentUserRegistrationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentUserRegistrationBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.apply {
            btProceed.setOnClickListener { proceedToNextScreen() }
        }
    }

    private fun proceedToNextScreen() {
        val action = UserRegistrationFragmentDirections.actionUserRegistrationFragmentToWelcomeFragment()
        findNavController().navigate(action)
    }

}