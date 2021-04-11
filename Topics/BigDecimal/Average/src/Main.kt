import java.math.BigDecimal
import java.math.RoundingMode

fun main() {
    val (a, b, c) = Array(3) { BigDecimal(readLine()!!) }
    print((a + b + c).setScale(0, RoundingMode.HALF_DOWN) / BigDecimal(3))
}