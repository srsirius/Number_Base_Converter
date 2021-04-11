fun main() {
    val (str, num) = readLine()!!.split(" ")
    val number = num.toInt()
    if (number > str.length) {
        print(str)
    } else print(str.substring(number) + str.substring(0, number))
}