import java.math.BigInteger        

fun main() {
    val (a, b) = Array(2) { BigInteger(readLine()!!)!! }
    val sum = a + b
    print("${a * BigInteger.valueOf(100) / sum}% ${b * BigInteger.valueOf(100) / sum}%")

}