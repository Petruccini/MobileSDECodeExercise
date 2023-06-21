package com.petruccini.mobilesdecodeexercise.presentation.ui.drivers.shipment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.petruccini.mobilesdecodeexercise.domain.GetBestShipmentUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ShipmentViewModel @Inject constructor(
    private val getBestShipmentUseCase: GetBestShipmentUseCase
): ViewModel() {

    private val _bestShipmentStateFlow: MutableStateFlow<String> = MutableStateFlow("")
    val bestShipmentStateFlow = _bestShipmentStateFlow.asStateFlow()

    fun getBestShipment(driverName: String) {
        viewModelScope.launch {
            _bestShipmentStateFlow.value = getBestShipmentUseCase(driverName)
        }
    }
}