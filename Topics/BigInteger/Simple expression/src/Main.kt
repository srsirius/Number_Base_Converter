import java.math.BigInteger

fun main() {
    val (a, b, c, d) = Array(4) { readLine()!! }

    print(-BigInteger(a) * BigInteger(b) + BigInteger(c) - BigInteger(d))
}
