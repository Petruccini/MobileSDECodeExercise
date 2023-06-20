package com.petruccini.mobilesdecodeexercise.presentation.drivers

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.petruccini.mobilesdecodeexercise.presentation.ktx.collectAsStateLifecycleAware
import kotlinx.coroutines.launch

@Composable
fun DriversScreen(
    viewModel: DriversViewModel = viewModel()
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
            Row(modifier = Modifier) {
                Text(text = driver)
            }
        }
    }
}