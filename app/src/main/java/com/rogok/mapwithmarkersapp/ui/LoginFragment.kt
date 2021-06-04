package com.rogok.mapwithmarkersapp.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.rogok.mapwithmarkersapp.R
import com.rogok.mapwithmarkersapp.databinding.FragmentLoginBinding

class LoginFragment : Fragment(R.layout.fragment_login) {

    private lateinit var binding: FragmentLoginBinding

    @SuppressLint("RestrictedApi")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (requireActivity() as AppCompatActivity).supportActionBar?.apply {
            setShowHideAnimationEnabled(false)
            hide()
        }
        binding = FragmentLoginBinding.bind(view)
        binding.button.setOnClickListener {
            logUser()
        }
    }

    private fun logUser() {
        val userEmail = binding.etName.text.toString()
        val action = LoginFragmentDirections.actionLoginFragmentToMapFragment(userEmail)
        findNavController().navigate(action)

    }
}