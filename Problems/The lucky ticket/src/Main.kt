fun main() {
    val ticketNumber = readLine()!!
    var firstHalf = 0
    var secondHalf = 0
    for (i in 0..2) {
        firstHalf += ticketNumber[i].toInt()
        secondHalf += ticketNumber[i + 3].toInt()
    }
    print(if (firstHalf == secondHalf) "Lucky" else "Regular")
}