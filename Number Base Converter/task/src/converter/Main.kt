package converter

import java.math.BigDecimal
import java.math.BigInteger
import java.math.RoundingMode

fun convertFromDecimal(decimal: String, targetBase: Int): String {
    val base = BigInteger.valueOf(targetBase.toLong())
    var temp = BigDecimal(decimal).setScale(0, RoundingMode.DOWN).toBigInteger()
    var fractional = BigDecimal(decimal) - temp.toBigDecimal()
    val digits = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ"
    var resultInt = ""
    var resultFractional = ""

    if (decimal.indexOf(".") >= 0) {
        var str = decimal
        resultFractional = str.substring(str.indexOf(".") + 1)
    }

    if (temp == BigDecimal.ZERO) resultInt = "0"
    while (temp > BigInteger.ZERO) {
        resultInt += digits[(temp % base).toInt()]
        temp /= base
    }

    if (resultFractional.isNotEmpty()) {
        resultFractional = ""
        for (i in 0..4) {
            fractional *= base.toBigDecimal()
            if (fractional.toBigInteger() > BigInteger.ZERO) {
                    resultFractional += digits[fractional.setScale(0, RoundingMode.DOWN).toInt()]
            } else resultFractional += "0"
            fractional -= fractional.setScale(0, RoundingMode.DOWN)
        }
        return "${resultInt.reversed()}.$resultFractional"

    } else return resultInt.reversed()
}

fun convertToDecimal(sourceNumber: String, sourceBase: Int): String {
    val number = sourceNumber.toUpperCase()
    var tempInt = ""
    var tempFractional = ""
    if (number.indexOf(".") >= 0) {
        val (a, b) = number.split(".")
        tempInt = a.reversed()
        tempFractional = b
    } else tempInt = number.reversed()
    val base = BigDecimal(sourceBase)
    val digits = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ"
    var result = BigDecimal(digits.indexOf(tempInt[0]).toString())
    var resultFractional = BigDecimal(0.00000)
    var tempBase = base

    for (i in 1 until tempInt.length) {
        result += BigDecimal(digits.indexOf(tempInt[i]).toString()) * tempBase
        tempBase *= base
    }

    if (tempFractional.isNotEmpty()) {
        var tempBase = base
        for (i in tempFractional) {
            resultFractional += BigDecimal(digits.indexOf(i).toDouble() / tempBase.toDouble())
            tempBase *= base
        }
        val str = resultFractional.toString().substring(resultFractional.toString().indexOf(".") + 1)
        return "$result.$str"
    } else  return "$result"
}

fun main() {
    do {
        print("Enter two numbers in format: {source base} {target base} (To quit type /exit): ")
        var answer = readLine()!!
        if (answer != "/exit") {
            do {
                val (sourceBase, targetBase) = answer.split(" ").map { it.toInt() }
                print("Enter number in base $sourceBase to convert to base $targetBase (To go back type /back): ")
                val number = readLine()!!
                if (number != "/back") {
                    println(
                        "Conversion result: ${
                            convertFromDecimal(
                                convertToDecimal(number, sourceBase),
                                targetBase
                            )
                        }"
                    )
                }
                println("")
            } while (number != "/back")
        }
    } while (answer != "/exit")
}