fun main() {
    val inputString = readLine()!!
    val vowels = "aeiouy"
    var str = inputString[0]
    var count = 1
    var countSummary = 0
    for (i in 1..inputString.lastIndex) {
        if (str in vowels && inputString[i] in vowels) {
            count++
        } else if (str !in vowels && inputString[i] !in vowels) {
            count++
        } else {
            if (count > 2) {
                countSummary += if (count % 2 == 0) count / 2 - 1 else count / 2
            }
            str = inputString[i]
            count = 1
        }
    }
    if (count > 2) {
        countSummary += if (count % 2 == 0) count / 2 - 1 else count / 2
    }
    print(countSummary)
}