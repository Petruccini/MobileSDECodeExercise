package com.petruccini.mobilesdecodeexercise.presentation.ui.drivers.shipment

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.petruccini.mobilesdecodeexercise.presentation.ktx.collectAsStateLifecycleAware

@Composable
fun ShipmentScreen(
    driverName: String,
    viewModel: ShipmentViewModel = hiltViewModel()
) {

    val bestShipmentState = viewModel.bestShipmentStateFlow.collectAsStateLifecycleAware()

    LaunchedEffect(Unit) {
        viewModel.getBestShipment(driverName)
    }

    Text(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        text = "The best shipment destination for $driverName is ${bestShipmentState.value}"
    )
}