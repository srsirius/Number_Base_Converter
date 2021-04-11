import java.math.BigDecimal
import java.math.RoundingMode

fun main() {             
    print(BigDecimal(readLine()!!).setScale(readLine()!!.toInt(), RoundingMode.CEILING))
}