package com.erald.digitalelectrician.ui.home

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.erald.digitalelectrician.adapter.HomeAdapter
import com.erald.digitalelectrician.databinding.FragmentHomeBinding
import com.erald.digitalelectrician.model.HomeModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private lateinit var _context: Context

    private val viewModel: HomeViewModel by viewModels()

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        _context = requireContext()

        observeHomeItems()

        return root
    }

    private fun observeHomeItems() {
        viewModel.homeItems.observe(viewLifecycleOwner) {
            val homeAdapter = HomeAdapter(_context, it, onHomeClickListener)
            val recyclerView: RecyclerView = binding.homeRecyclerView
            recyclerView.layoutManager = GridLayoutManager(_context, 3)
            recyclerView.adapter = homeAdapter
        }
    }

    private val onHomeClickListener = object: HomeAdapter.OnHomeClickListener {
        override fun onClick(position: Int, items: MutableList<HomeModel>) {
            when (position) {
                0 -> {
                    val navigateToBasicFragment =
                        HomeFragmentDirections.actionNavHomeToBasicFragment(context!!.resources.getString(items[0].title))
                    findNavController().navigate(navigateToBasicFragment)
                }
            }

        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}