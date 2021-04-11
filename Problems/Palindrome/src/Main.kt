fun main() {
    val str = readLine()!!.toLowerCase()
    print(if (str == str.reversed()) "yes" else "no")
}