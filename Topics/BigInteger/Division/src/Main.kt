import java.math.BigInteger

fun main() {
    val (a, b) = Array(2) { BigInteger(readLine()!!)!! }
    val (q, r) = a.divideAndRemainder(b)
    print("$a = $b*$q + $r")
}