package com.erald.digitalelectrician.ui.home.basic.ohmLawDC

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.navigation.fragment.navArgs
import com.erald.digitalelectrician.MainActivity
import com.erald.digitalelectrician.R
import com.erald.digitalelectrician.databinding.OhmLawDCFragmentBinding

class OhmLawDCFragment : Fragment() {

    private var _binding: OhmLawDCFragmentBinding? = null
    private lateinit var _context: Context

    private lateinit var viewModel: OhmLawDCViewModel

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

        binding.textViewOhmLawDCValue.text = current
        binding.textViewOhmLawDCFirstItem.text = voltage
        binding.textViewOhmLawDCSecondItem.text = resistance

        setupListeners()

        setupSpinner(R.array.voltageUnits, R.array.resistanceUnits)

        return root
    }

    private fun setupSpinner(firstLayoutId: Int, secondLayoutId: Int) {
        firstAdapter = ArrayAdapter(
            _context,
            android.R.layout.simple_spinner_item,
            _context.resources.getStringArray(firstLayoutId)
        )
        firstAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerTextOhmLawDCFirstUnit.adapter = firstAdapter

        secondAdapter = ArrayAdapter(
            _context,
            android.R.layout.simple_spinner_item,
            _context.resources.getStringArray(secondLayoutId)
        )
        secondAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerTextOhmLawDCSecondUnit.adapter = secondAdapter
    }

    private fun setupListeners() {
        binding.spinnerTextOhmLawDCFirstUnit.onItemSelectedListener = onSpinnerItemSelected
        binding.spinnerTextOhmLawDCSecondUnit.onItemSelectedListener = onSpinnerItemSelected

        binding.button1OhmLawDC.setOnClickListener(onClickListener)
        binding.button2OhmLawDC.setOnClickListener(onClickListener)
        binding.button3OhmLawDC.setOnClickListener(onClickListener)
        binding.button4OhmLawDC.setOnClickListener(onClickListener)
        binding.button5OhmLawDC.setOnClickListener(onClickListener)
        binding.button6OhmLawDC.setOnClickListener(onClickListener)
        binding.button7OhmLawDC.setOnClickListener(onClickListener)
        binding.button8OhmLawDC.setOnClickListener(onClickListener)
        binding.button9OhmLawDC.setOnClickListener(onClickListener)
        binding.button10OhmLawDC.setOnClickListener(onClickListener)
        binding.button11OhmLawDC.setOnClickListener(onClickListener)
        binding.button12OhmLawDC.setOnClickListener(onClickListener)
    }

    private var onClickListener = View.OnClickListener { view ->
        when (view?.id) {
            binding.button1OhmLawDC.id -> {
                binding.textViewOhmLawDCValue.text = current
                binding.textViewOhmLawDCFirstItem.text = voltage
                binding.textViewOhmLawDCSecondItem.text = resistance
                setupSpinner(R.array.voltageUnits, R.array.resistanceUnits)
            }
            binding.button2OhmLawDC.id -> {
                binding.textViewOhmLawDCValue.text = current
                binding.textViewOhmLawDCFirstItem.text = power
                binding.textViewOhmLawDCSecondItem.text = voltage
                setupSpinner(R.array.powerUnits, R.array.voltageUnits)
            }
            binding.button3OhmLawDC.id -> {
                binding.textViewOhmLawDCValue.text = current
                binding.textViewOhmLawDCFirstItem.text = power
                binding.textViewOhmLawDCSecondItem.text = resistance
                setupSpinner(R.array.powerUnits, R.array.resistanceUnits)
            }
            binding.button4OhmLawDC.id -> {
                binding.textViewOhmLawDCValue.text = voltage
                binding.textViewOhmLawDCFirstItem.text = current
                binding.textViewOhmLawDCSecondItem.text = resistance
                setupSpinner(R.array.currentUnits, R.array.resistanceUnits)
            }
            binding.button5OhmLawDC.id -> {
                binding.textViewOhmLawDCValue.text = voltage
                binding.textViewOhmLawDCFirstItem.text = power
                binding.textViewOhmLawDCSecondItem.text = current
                setupSpinner(R.array.powerUnits, R.array.currentUnits)
            }
            binding.button6OhmLawDC.id -> {
                binding.textViewOhmLawDCValue.text = voltage
                binding.textViewOhmLawDCFirstItem.text = power
                binding.textViewOhmLawDCSecondItem.text = resistance
                setupSpinner(R.array.powerUnits, R.array.resistanceUnits)
            }
            binding.button7OhmLawDC.id -> {
                binding.textViewOhmLawDCValue.text = power
                binding.textViewOhmLawDCFirstItem.text = current
                binding.textViewOhmLawDCSecondItem.text = voltage
                setupSpinner(R.array.currentUnits, R.array.voltageUnits)
            }
            binding.button8OhmLawDC.id -> {
                binding.textViewOhmLawDCValue.text = power
                binding.textViewOhmLawDCFirstItem.text = current
                binding.textViewOhmLawDCSecondItem.text = resistance
                setupSpinner(R.array.currentUnits, R.array.resistanceUnits)
            }
            binding.button9OhmLawDC.id -> {
                binding.textViewOhmLawDCValue.text = power
                binding.textViewOhmLawDCFirstItem.text = voltage
                binding.textViewOhmLawDCSecondItem.text = resistance
                setupSpinner(R.array.powerUnits, R.array.voltageUnits)
            }
            binding.button10OhmLawDC.id -> {
                binding.textViewOhmLawDCValue.text = resistance
                binding.textViewOhmLawDCFirstItem.text = voltage
                binding.textViewOhmLawDCSecondItem.text = current
                setupSpinner(R.array.voltageUnits, R.array.currentUnits)
            }
            binding.button11OhmLawDC.id -> {
                binding.textViewOhmLawDCValue.text = resistance
                binding.textViewOhmLawDCFirstItem.text = power
                binding.textViewOhmLawDCSecondItem.text = current
                setupSpinner(R.array.powerUnits, R.array.currentUnits)
            }
            binding.button12OhmLawDC.id -> {
                binding.textViewOhmLawDCValue.text = resistance
                binding.textViewOhmLawDCFirstItem.text = voltage
                binding.textViewOhmLawDCSecondItem.text = power
                setupSpinner(R.array.voltageUnits, R.array.powerUnits)
            }
        }
    }

    private val onSpinnerItemSelected = object: AdapterView.OnItemSelectedListener {
        override fun onItemSelected(p0: AdapterView<*>?, p1: View?, position: Int, id: Long) {

        }

        override fun onNothingSelected(p0: AdapterView<*>?) {

        }

    }


}