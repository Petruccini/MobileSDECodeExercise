package com.petruccini.mobilesdecodeexercise.data.repositories

import android.content.res.Resources
import com.petruccini.mobilesdecodeexercise.data.file.ShipmentsRawDataSource

class ShipmentsRepository (
    private val shipmentsRawDataSource: ShipmentsRawDataSource,
    private val resources: Resources
    ) {

    fun getShipments() = shipmentsRawDataSource.getShipments(resources)

}