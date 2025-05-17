fun main() {
    val initialMeasurement = 100.0
    val initialUnit = "Celsius"
    val finalUnit = "Fahrenheit"

    val conversionFormula: (Double) -> Double = { celsius -> celsius * 9 / 5 + 32 }

    printFinalTemperature(initialMeasurement, initialUnit, finalUnit, conversionFormula)
}


fun printFinalTemperature(
    initialMeasurement: Double, 
    initialUnit: String, 
    finalUnit: String, 
    conversionFormula: (Double) -> Double
) {
    val finalMeasurement = String.format("%.2f", conversionFormula(initialMeasurement)) // two decimal places
    println("$initialMeasurement degrees $initialUnit is $finalMeasurement degrees $finalUnit.")
}