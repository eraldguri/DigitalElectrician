package com.erald.digitalelectrician.ui.home.basic

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.erald.digitalelectrician.model.BasicModel
import com.erald.digitalelectrician.repository.HomeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * BasicViewModel.kt
 *
 * This class represents the ViewModel class that we use to pass data into BasicFragment.
 *
 * @param repository - The HomeRepository
 * */
@HiltViewModel
class BasicViewModel @Inject constructor(private val repository: HomeRepository) : ViewModel() {

    private val basicItemsEmitter = MutableLiveData<ArrayList<BasicModel>>()
    var basicItems : LiveData<ArrayList<BasicModel>> = basicItemsEmitter

    init {
        loadBasicItems()
    }

    private fun loadBasicItems() {
        basicItemsEmitter.value = repository.getBasicItems()
    }

}