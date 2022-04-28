package com.erald.digitalelectrician.repository

import com.erald.digitalelectrician.R
import com.erald.digitalelectrician.model.HomeModel

class HomeRepositoryImpl : HomeRepository {

    override fun getHomeItems(): ArrayList<HomeModel> {
        val items : ArrayList<HomeModel> = arrayListOf()
        items.add(HomeModel("Basic",        R.color.colorDodgerBlue))
        items.add(HomeModel("Capacitance",  R.color.colorColumbiaBlue))
        items.add(HomeModel("Resistance",   R.color.colorTiffanyBlue))
        items.add(HomeModel("Inductance",   R.color.colorHeavenlyBlue))
        items.add(HomeModel("PUE",          R.color.colorBlueGreen))
        items.add(HomeModel("NEC",          R.color.colorAquamarine))
        items.add(HomeModel("CEC",          R.color.colorTurquoise))
        items.add(HomeModel("IEC",          R.color.colorDarkCyan))
        items.add(HomeModel("Conductor",    R.color.colorDarkMint))
        items.add(HomeModel("Motor",        R.color.colorFallForestGreen))
        items.add(HomeModel("Cable",        R.color.colorNeonYellow))
        items.add(HomeModel("Converter",    R.color.colorBakersBrown))

        return items
    }

}