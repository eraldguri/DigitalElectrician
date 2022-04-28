package com.erald.digitalelectrician.repository

import com.erald.digitalelectrician.model.HomeModel

interface HomeRepository {
    fun getHomeItems(): ArrayList<HomeModel>
}