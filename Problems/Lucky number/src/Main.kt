fun main() {
    val str = readLine()!!
    val firstHalf = str.substring(0, str.length / 2)
    val secondHalf = str.substring(str.length / 2)

    print(if (sumNumbers(firstHalf) == sumNumbers(secondHalf)) "YES" else "NO")
}
fun sumNumbers(str: String): Int {
    var sum = 0
    for (i in str) {
        sum += i.toInt()
    }
    return sum
}