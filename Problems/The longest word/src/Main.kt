fun main() {
    val listStr = readLine()!!.split(" ")
    var firstBiggest = 0
    var size = 0
    for (i in listStr.indices) {
        if (listStr[i].length > firstBiggest) {
            firstBiggest = i
            size = listStr[i].length
        }
    }
    print(firstBiggest)
}