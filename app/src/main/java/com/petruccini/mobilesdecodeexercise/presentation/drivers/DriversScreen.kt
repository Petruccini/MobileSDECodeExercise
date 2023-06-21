package com.petruccini.mobilesdecodeexercise.presentation.drivers

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.petruccini.mobilesdecodeexercise.presentation.ktx.collectAsStateLifecycleAware
import kotlinx.coroutines.launch

@Composable
fun DriversScreen(
    viewModel: DriversViewModel = hiltViewModel(),
    navigateToDriverShipment: (String) -> Unit
) {
    val lifecycleOwner: LifecycleOwner = LocalLifecycleOwner.current
    val lifecycleScope = lifecycleOwner.lifecycleScope

    val driversState = viewModel.driversStateFlow.collectAsStateLifecycleAware()

    LaunchedEffect(Unit) {
        lifecycleScope.launch {
            lifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.getDrivers()
            }
        }
    }

    Column(modifier = Modifier.fillMaxSize()) {
        driversState.value.drivers.forEach { driver ->
            Row(modifier = Modifier
                .clickable { navigateToDriverShipment(driver) }) {
                Text(text = driver, modifier = Modifier.padding(16.dp).fillMaxWidth())
            }
        }
    }
}