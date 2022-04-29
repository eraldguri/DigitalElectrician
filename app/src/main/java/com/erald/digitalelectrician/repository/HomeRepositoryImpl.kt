package com.erald.digitalelectrician.repository

import com.erald.digitalelectrician.R
import com.erald.digitalelectrician.model.BasicModel
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

    override fun getBasicItems(): ArrayList<BasicModel> {
        val items: ArrayList<BasicModel> = arrayListOf()
        items.add(BasicModel(R.string.ohm_law_dc, R.color.colorDodgerBlue))
        items.add(BasicModel(R.string.ohm_law_ac, R.color.colorColumbiaBlue))
        items.add(BasicModel(R.string.lc_resonance, R.color.colorTiffanyBlue))
        items.add(BasicModel(R.string.y_delta_transform, R.color.colorHeavenlyBlue))
        items.add(BasicModel(R.string.electrical_energy, R.color.colorBlueGreen))
        items.add(BasicModel(R.string.current_density, R.color.colorAquamarine))
        items.add(BasicModel(R.string.ideal_transformer, R.color.colorTurquoise))
        items.add(BasicModel(R.string.ac_circuits, R.color.colorDarkCyan))
        items.add(BasicModel(R.string.contact_protection, R.color.colorNeonYellow))

        return items
    }

}