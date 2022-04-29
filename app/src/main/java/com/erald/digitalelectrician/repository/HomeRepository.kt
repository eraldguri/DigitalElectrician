package com.erald.digitalelectrician.repository

import com.erald.digitalelectrician.model.HomeModel

/**
 * Interface for the methods which we are gonna use with viewModel
 * */
interface HomeRepository {

    /**
     * This methods allows us to get all the items we want to display in the HomeFragment.
     *
     * @return list of home items
     * */
    fun getHomeItems(): ArrayList<HomeModel>
}