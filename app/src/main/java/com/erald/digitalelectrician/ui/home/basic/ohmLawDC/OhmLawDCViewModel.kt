package com.erald.digitalelectrician.ui.home.basic.ohmLawDC

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.erald.digitalelectrician.repository.HomeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class OhmLawDCViewModel @Inject constructor() : ViewModel() {

    private val currentFromVoltageAndResistanceEmitter = MutableLiveData<Float>()

    var _currentFromVoltageAndResistance : LiveData<Float> = currentFromVoltageAndResistanceEmitter

    fun calculateCurrentFromVoltageAndResistance(voltage: Float, resistance: Float) {
        currentFromVoltageAndResistanceEmitter.value = voltage / resistance
    }

}