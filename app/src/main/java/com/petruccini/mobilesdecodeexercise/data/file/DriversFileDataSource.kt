package com.petruccini.mobilesdecodeexercise.data.file

import android.content.res.Resources
import com.google.gson.Gson
import com.petruccini.mobilesdecodeexercise.R
import com.petruccini.mobilesdecodeexercise.data.model.Drivers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import javax.inject.Inject

class DriversFileDataSource @Inject constructor(
    private val resources: Resources
) {

    fun getDrivers(): Flow<Drivers> {

        val driversString = resources.getJsonStringFromFile(R.raw.drivers)
        val drivers = Gson().fromJson(driversString, Drivers::class.java)
        return flowOf(drivers)
    }
}