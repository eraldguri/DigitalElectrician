package com.erald.digitalelectrician.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.erald.digitalelectrician.model.HomeModel
import com.erald.digitalelectrician.repository.HomeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * HomeViewModel.kt
 *
 * This class represents the ViewModel class that we use to pass data into HomeFragment.
 *
 * @param repository - The HomeRepository
 * */
@HiltViewModel
class HomeViewModel @Inject constructor(private val repository: HomeRepository) : ViewModel() {

    private val homeItemsEmitter = MutableLiveData<ArrayList<HomeModel>>()
    var homeItems : LiveData<ArrayList<HomeModel>> = homeItemsEmitter

    init {
        loadHomeItems()
    }

    private fun loadHomeItems() {
        homeItemsEmitter.value = repository.getHomeItems()
    }

}