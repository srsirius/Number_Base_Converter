
fun mix(str: String, size: Int): String {
    var mixSize = size
    var tempStr = str
    var tempPass = ""
    while (mixSize != 0) {
        tempStr = tempStr.last() + tempStr.substring(0, tempStr.lastIndex)
        mixSize -= 1
    }
    for (i in 0 until size) {
        tempPass += tempStr.last()
        tempStr = tempStr.last() + tempStr.substring(0, tempStr.lastIndex)
    }

    return tempPass
}

fun sumLow(list: List<Int>): Int {
    var sum = 0
    for (i in 0 until list.lastIndex) {
        sum += list[i]
    }
    return list.last() - sum + list[1]
}

fun concatPass(upper: String, digit: String, lower: String, lenghtPass: Int): String {
    var pass = ""
    var tempUpper = upper
    var tempDigit = digit
    var tempLower = lower
    var len = lenghtPass
    while (len != 0) {
        if (tempUpper.isNotEmpty()) {
            pass += tempUpper.last()
            tempUpper = tempUpper.substring(0, tempUpper.lastIndex)
            len -= 1
        }
        if (tempDigit.isNotEmpty()) {
            pass += tempDigit.last()
            tempDigit = tempDigit.substring(0, tempDigit.lastIndex)
            len -= 1
        }
        if (tempLower.isNotEmpty()) {
            pass += tempLower.last()
            tempLower = tempLower.substring(0, tempLower.lastIndex)
            len -= 1
        }
    }
    return pass
}

fun main() {
    val passwordProtection = readLine()!!.split(" ").map { it.toInt() }
    val upperCase = ('A'..'Z').joinToString("")
    val lowCase = ('a'..'z').joinToString("")
    val number = "1234567890"
    val lowCaseLenght = sumLow(passwordProtection)

    val password = concatPass(mix(upperCase, passwordProtection[0]), mix(number, passwordProtection[2]),
        mix(lowCase, lowCaseLenght), passwordProtection[3])

    print(password)
}