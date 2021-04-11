fun main() {
    val inputString = readLine()!!
    var count = 1
    var output = ""
    var sum = 0

    for (i in 1..inputString.lastIndex) {
        if (inputString[i] == inputString[i - 1]) {
            count += 1
            if (i < inputString.lastIndex) continue
        }
        output += inputString[i - 1] + count.toString()
        sum += count
        count = 1
    }
    output += if (sum != inputString.length) inputString.last() + "1" else ""
    print(output)


}