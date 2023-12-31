package com.petruccini.mobilesdecodeexercise.data.file


import android.content.res.Resources
import com.google.gson.Gson
import com.petruccini.mobilesdecodeexercise.R
import com.petruccini.mobilesdecodeexercise.data.model.Shipments
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import javax.inject.Inject


class ShipmentsRawDataSource @Inject constructor(
    private val resources: Resources
) {

    fun getShipments(): Flow<Shipments> {

        val shipmentsString = resources.getJsonStringFromFile(R.raw.shipments)
        val shipments = Gson().fromJson(shipmentsString, Shipments::class.java)
        return flowOf(shipments)
    }
}