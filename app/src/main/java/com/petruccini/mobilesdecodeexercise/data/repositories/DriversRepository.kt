package com.petruccini.mobilesdecodeexercise.data.repositories

import android.content.res.Resources
import com.petruccini.mobilesdecodeexercise.data.file.DriversFileDataSource
import javax.inject.Inject

class DriversRepository @Inject constructor(
    private val driversFileDataSource: DriversFileDataSource,
    ) {

    fun getDrivers() = driversFileDataSource.getDrivers()
}