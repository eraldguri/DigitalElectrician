package com.erald.digitalelectrician.repository

import com.erald.digitalelectrician.R
import com.erald.digitalelectrician.model.HomeModel

/**
 * HomeRepositoryImpl.kt
 *
 * This class provides implementations for the methods declared in the @link{HomeRepository} interface.
 * */
class HomeRepositoryImpl : HomeRepository {

    override fun getHomeItems(): ArrayList<HomeModel> {
        val items : ArrayList<HomeModel> = arrayListOf()
        items.add(HomeModel(R.string.basic,        R.color.colorDodgerBlue))
        items.add(HomeModel(R.string.capacitance,  R.color.colorColumbiaBlue))
        items.add(HomeModel(R.string.resistance,   R.color.colorTiffanyBlue))
        items.add(HomeModel(R.string.inductance,   R.color.colorHeavenlyBlue))
        items.add(HomeModel(R.string.pue,          R.color.colorBlueGreen))
        items.add(HomeModel(R.string.nec,          R.color.colorAquamarine))
        items.add(HomeModel(R.string.cec,          R.color.colorTurquoise))
        items.add(HomeModel(R.string.iec,          R.color.colorDarkCyan))
        items.add(HomeModel(R.string.conductor,    R.color.colorDarkMint))
        items.add(HomeModel(R.string.motor,        R.color.colorFallForestGreen))
        items.add(HomeModel(R.string.motor,        R.color.colorNeonYellow))
        items.add(HomeModel(R.string.converter,    R.color.colorBakersBrown))

        return items
    }

}