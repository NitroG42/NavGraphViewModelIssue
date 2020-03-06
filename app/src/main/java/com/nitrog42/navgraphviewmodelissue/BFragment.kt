package com.nitrog42.navgraphviewmodelissue

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.observe
import androidx.navigation.fragment.findNavController
import androidx.navigation.navGraphViewModels

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class BFragment : Fragment(R.layout.fragment_b) {
    val viewModel: SharedViewModel by navGraphViewModels(R.id.scope)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d(this::class.simpleName, "view model instance " + viewModel)
        viewModel.newInstance.observe(viewLifecycleOwner) { newInstance ->
            if (!newInstance) {
                Toast.makeText(requireContext(), "New ViewModel Instance", Toast.LENGTH_SHORT).show()
                viewModel.newInstanceDisplayed()
            }
        }

        view.findViewById<Button>(R.id.button_second).setOnClickListener {
            findNavController().navigate(R.id.action_BFragment_to_CFragment)
        }
    }
}