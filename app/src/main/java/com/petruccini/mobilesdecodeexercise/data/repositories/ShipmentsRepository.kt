package com.petruccini.mobilesdecodeexercise.data.repositories

import android.content.res.Resources
import com.petruccini.mobilesdecodeexercise.data.file.ShipmentsRawDataSource
import javax.inject.Inject

class ShipmentsRepository @Inject constructor(
    private val shipmentsFileDataSource: ShipmentsRawDataSource,
    ) {

    fun getShipments() = shipmentsFileDataSource.getShipments()
}