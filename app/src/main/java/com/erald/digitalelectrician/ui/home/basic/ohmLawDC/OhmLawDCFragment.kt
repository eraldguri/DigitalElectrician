package com.erald.digitalelectrician.ui.home.basic.ohmLawDC

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.erald.digitalelectrician.CurrentCalculation
import com.erald.digitalelectrician.MainActivity
import com.erald.digitalelectrician.R
import com.erald.digitalelectrician.UnitConverter
import com.erald.digitalelectrician.databinding.OhmLawDCFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OhmLawDCFragment : Fragment() {

    private var _binding: OhmLawDCFragmentBinding? = null
    private lateinit var _context: Context

    private val args: OhmLawDCFragmentArgs by navArgs()

    private val binding get() = _binding!!

    private lateinit var current: String
    private lateinit var voltage: String
    private lateinit var power: String
    private lateinit var resistance:String

    private lateinit var firstAdapter: ArrayAdapter<String>
    private lateinit var secondAdapter: ArrayAdapter<String>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = OhmLawDCFragmentBinding.inflate(inflater, container, false)
        val root: View = binding.root

        _context = requireContext()

        (requireActivity() as MainActivity).supportActionBar?.title = args.title

        current     = context?.resources!!.getString(R.string.current)
        voltage     = context?.resources!!.getString(R.string.voltage)
        power       = context?.resources!!.getString(R.string.power)
        resistance  = context?.resources!!.getString(R.string.resistance)


        setupListeners()

        setupSpinner(R.array.voltageUnits, R.array.resistanceUnits)

        return root
    }

    private val onClickListener = View.OnClickListener { view ->
        when (view?.id) {
            binding.buttonCalculateCurrent1.id -> {
                val editTextVoltage = binding.editTextOhmLawDCVoltage.text.toString().toFloatOrNull()
                val editTextResistance = binding.editTextOhmLawDCResistance.text.toString().toFloatOrNull()

                val valueConverted = UnitConverter.voltageUnitConverter(
                    editTextVoltage, binding.spinnerTextOhmLawDCVoltage.selectedItem.toString())
                CurrentCalculation.voltageConverter(valueConverted!!)
                CurrentCalculation.calculateCurrentFromVoltageAndResistance(valueConverted, editTextResistance!!)
                binding.textViewResult1.text = CurrentCalculation.current.toString()
            }
        }
    }

    private fun setupSpinner(firstLayoutId: Int, secondLayoutId: Int) {
        firstAdapter = ArrayAdapter(
            _context,
            android.R.layout.simple_spinner_item,
            _context.resources.getStringArray(firstLayoutId)
        )
        firstAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerTextOhmLawDCVoltage.adapter = firstAdapter
        binding.spinnerTextOhmLawDCVoltage.setSelection(4)

        secondAdapter = ArrayAdapter(
            _context,
            android.R.layout.simple_spinner_item,
            _context.resources.getStringArray(secondLayoutId)
        )
        secondAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerTextOhmLawDCResistance.adapter = secondAdapter
        binding.spinnerTextOhmLawDCResistance.setSelection(4)
    }

    private fun setupListeners() {
        binding.buttonCalculateCurrent1.setOnClickListener(onClickListener)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}