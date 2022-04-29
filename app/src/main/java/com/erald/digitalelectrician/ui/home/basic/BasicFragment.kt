package com.erald.digitalelectrician.ui.home.basic

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.erald.digitalelectrician.MainActivity
import com.erald.digitalelectrician.adapter.BasicAdapter
import com.erald.digitalelectrician.databinding.BasicFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BasicFragment : Fragment() {

   private var _binding: BasicFragmentBinding? = null
    private lateinit var _context: Context

    private val viewModel: BasicViewModel by viewModels()

    private val arg: BasicFragmentArgs by navArgs()

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = BasicFragmentBinding.inflate(inflater, container, false)
        val root: View = binding.root

        _context = requireContext()

        // set actionbar title
        (requireActivity() as MainActivity).supportActionBar?.title = arg.title

        observeBasicItems()

        return root
    }

    private fun observeBasicItems() {
        viewModel.basicItems.observe(viewLifecycleOwner) {
            val basicAdapter = BasicAdapter(_context, it, onBasicClickListener)
            val recyclerView: RecyclerView = binding.basicRecyclerview
            recyclerView.layoutManager = LinearLayoutManager(_context)
            recyclerView.adapter = basicAdapter
        }
    }

    private var onBasicClickListener = object : BasicAdapter.OnBasicClickListener {
        override fun onClick(position: Int) {

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}