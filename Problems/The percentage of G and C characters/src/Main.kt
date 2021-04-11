fun main() {
    val str = readLine()!!.toLowerCase()
    var count: Double = 0.0
    for (i in str.indices) {
        if (str[i] == 'g' || str[i] == 'c') count++
    }
    print(count * 100 / str.length)
}