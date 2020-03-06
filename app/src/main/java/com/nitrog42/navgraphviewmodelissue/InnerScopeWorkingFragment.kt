package com.nitrog42.navgraphviewmodelissue

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.observe
import androidx.navigation.fragment.findNavController
import androidx.navigation.navGraphViewModels

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class InnerScopeWorkingFragment : Fragment() {

    val viewModel: SharedViewModel by navGraphViewModels(R.id.scope)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_inner, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.newInstance.observe(viewLifecycleOwner) { newInstance ->
            if (!newInstance) {
                Toast.makeText(requireContext(), "New ViewModel Instance", Toast.LENGTH_SHORT).show()
                viewModel.newInstanceDisplayed()
            }
        }

        view.findViewById<Button>(R.id.button_second).setOnClickListener {
            findNavController().navigate(R.id.action_innerScopeWorkingFragment_to_exitFragment)
        }
    }
}