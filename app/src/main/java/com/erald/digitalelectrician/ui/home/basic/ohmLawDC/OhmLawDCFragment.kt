package com.erald.digitalelectrician.ui.home.basic.ohmLawDC

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.erald.digitalelectrician.CurrentCalculation
import com.erald.digitalelectrician.MainActivity
import com.erald.digitalelectrician.R
import com.erald.digitalelectrician.UnitConverter
import com.erald.digitalelectrician.databinding.OhmLawDCFragmentBinding
import com.erald.digitalelectrician.utils.DESnackBar
import com.google.android.material.snackbar.Snackbar
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
                currentFromVoltageAndResistance()
            }

            binding.buttonClear1.id -> {
                binding.editTextOhmLawDCVoltage.setText("")
                binding.editTextOhmLawDCResistance.setText("")
                binding.textViewResult1.text = "0"
            }
        }
    }

    private fun currentFromVoltageAndResistance() {
        val editTextVoltage = binding.editTextOhmLawDCVoltage.text.toString().toDoubleOrNull()
        val editTextResistance = binding.editTextOhmLawDCResistance.text.toString().toDoubleOrNull()

        if (!TextUtils.isEmpty(binding.editTextOhmLawDCVoltage.text)
            && !TextUtils.isEmpty(binding.editTextOhmLawDCResistance.text)
        ) {
            val voltageConverted = UnitConverter.voltageUnitConverter(
                editTextVoltage, binding.spinnerTextOhmLawDCVoltage.selectedItem.toString()
            )
            val resistanceConverted = UnitConverter.resistanceUnitConverter(
                editTextResistance, binding.spinnerTextOhmLawDCResistance.selectedItem.toString()
            )
            CurrentCalculation.calculateCurrentFromVoltageAndResistance(
                voltageConverted!!,
                resistanceConverted!!
            )
            binding.textViewResult1.text = CurrentCalculation.current.toString() + " A"
            //copyTextFromClipBoard(binding.textViewResult1)
        } else {
            Snackbar.make(binding.root, "Fields cannot be empty", Snackbar.LENGTH_SHORT).show()
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
        binding.buttonClear1.setOnClickListener(onClickListener)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}