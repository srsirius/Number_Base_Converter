fun main() {
    val str = readLine()!!
    val subStr = readLine()!!
    var count = 0
    var firstIndex = str.indexOf(subStr)

    for (i in 0..str.length) {
        if (firstIndex >= 0) {
            count++
            firstIndex = str.indexOf(subStr, firstIndex + 1)
        }
    }

    print(count)
}