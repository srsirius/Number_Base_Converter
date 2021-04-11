fun main() {
    val str = readLine()!!.toLowerCase()
    val alphabet = "abcdefghijklmnopqrstuvwxyz"

    print(if (str in alphabet) "true" else "false")
}