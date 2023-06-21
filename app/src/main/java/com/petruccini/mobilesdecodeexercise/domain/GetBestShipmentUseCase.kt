package com.petruccini.mobilesdecodeexercise.domain

import com.petruccini.mobilesdecodeexercise.data.repositories.ShipmentsRepository
import javax.inject.Inject

class GetBestShipmentUseCase @Inject constructor(
    private val shipmentsRepository: ShipmentsRepository
) {

    suspend operator fun invoke(driverName: String): String {
        var bestShipment = ""
        var maxSS = 0.0

        shipmentsRepository.getShipments().collect {
            it.shipments.forEach { destination ->
                var baseSS: Double = if (destination.length % 2 == 0) {
                    driverName.vowelsCount() * 1.5
                } else {
                    driverName.consonantsCount().toDouble()
                }

                val driverAndDestinationCommonFactors = getCommonFactorsBesidesOne(driverName.length, destination.length)
                if (driverAndDestinationCommonFactors.isNotEmpty()) {
                    baseSS *= 1.5
                }

                if (baseSS > maxSS) {
                    maxSS = baseSS
                    bestShipment = destination
                }
            }
        }

        return bestShipment
    }

    private fun String.consonantsCount(): Int {
        val consonants = "bcdfghjklmnpqrstvwxyz"
        var count = 0
        for (char in this) {
            if (consonants.contains(char, true)) {
                count++
            }
        }
        return count
    }

    private fun String.vowelsCount(): Int {
        val vowels = "aeiou"
        var count = 0
        for (char in this) {
            if (vowels.contains(char, true)) {
                count++
            }
        }
        return count
    }

    private fun getCommonFactorsBesidesOne(number1: Int, number2: Int): List<Int> {
        val commonFactors = mutableListOf<Int>()
        for (i in 2..number1) {
            if (number1 % i == 0 && number2 % i == 0) {
                commonFactors.add(i)
            }
        }
        return commonFactors
    }
}