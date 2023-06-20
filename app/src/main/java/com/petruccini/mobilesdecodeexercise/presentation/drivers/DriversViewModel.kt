package com.petruccini.mobilesdecodeexercise.presentation.drivers

import android.content.res.Resources
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.petruccini.mobilesdecodeexercise.data.model.Drivers
import com.petruccini.mobilesdecodeexercise.data.repositories.DriversRepository
import com.petruccini.mobilesdecodeexercise.domain.GetDriversUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DriversViewModel @Inject constructor(
    private val getDriversUseCase: GetDriversUseCase
) : ViewModel() {

    private val _driversStateFlow: MutableStateFlow<Drivers> = MutableStateFlow(Drivers(listOf()))
    val driversStateFlow = _driversStateFlow.asStateFlow()

    fun getDrivers() {
        viewModelScope.launch {
            getDriversUseCase().collect {
                _driversStateFlow.value = it
            }
        }
    }
}