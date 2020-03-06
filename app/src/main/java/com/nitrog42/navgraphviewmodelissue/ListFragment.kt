package com.nitrog42.navgraphviewmodelissue

import android.os.Bundle
import android.util.TypedValue
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.view.updatePadding
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_list.*

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class ListFragment : Fragment(R.layout.fragment_list) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        recycler_view.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = RAdapter() {
                findNavController().navigate(R.id.action_menu_list_to_scope)
            }
        }
    }

    class RAdapter(val onClick: () -> Unit) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
            return CustomVH(TextView(parent.context).apply {
                setOnClickListener {
                    onClick()
                }
                val padding = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 16f, parent.context.resources.displayMetrics).toInt()
                updatePadding(top = padding, bottom = padding)
                textSize = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 18f, parent.context.resources.displayMetrics)
            })
        }

        override fun getItemCount(): Int = 10

        override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
            (holder.itemView as TextView).text = "Playlist $position"
        }
    }

    class CustomVH(view: View) : RecyclerView.ViewHolder(view)
}