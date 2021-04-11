import java.math.BigInteger

fun main() {
    val (a, b) = Array(2) { BigInteger(readLine()!!) }
    print((a + b + (a - b).abs()) / BigInteger.TWO)
}