package com.petruccini.mobilesdecodeexercise.domain

import com.petruccini.mobilesdecodeexercise.data.model.Drivers
import com.petruccini.mobilesdecodeexercise.data.repositories.DriversRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import javax.inject.Inject

class GetDriversUseCase @Inject constructor(
    private val driversRepository: DriversRepository
) {

    operator fun invoke(): Flow<Drivers> {
        return driversRepository.getDrivers()
    }
}