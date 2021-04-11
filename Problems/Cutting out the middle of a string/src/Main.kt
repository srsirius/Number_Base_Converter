fun main() {
    val inputString = readLine()!!
    var output = ""
    val center = inputString.length / 2
    if (inputString.length % 2 == 0) {
        output = inputString.substring(0, center - 1) + inputString.substring(center + 1)
    } else {
        output = inputString.substring(0, center) + inputString.substring(center + 1)
    }
    print(output)
}
