import java.math.BigDecimal
import java.math.RoundingMode
import kotlin.math.pow

fun main() {
    val totalMoney = BigDecimal(readLine()!!)
    val rate = BigDecimal(readLine()!!).setScale(2, RoundingMode.CEILING)
    val totalYear = readLine()!!.toInt()
    val result = totalMoney * (BigDecimal.ONE + rate / BigDecimal(100)).pow(totalYear)
    print("Amount of money in the account: ${result.setScale(2, RoundingMode.CEILING)}")
}