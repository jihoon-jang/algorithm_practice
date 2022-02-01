import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.math.max

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val stz = StringTokenizer(br.readLine())

    var maxPrice: Int = 0
    repeat(stz.nextToken().toInt()) {
        maxPrice = max(maxPrice, roleDice(br.readLine()))
    }
    print(maxPrice)
}

fun roleDice(inputStr: String): Int {
    val stz = StringTokenizer(inputStr)
    val diceCount = Array(7) { 0 }
    var maxCount: Int = 0
    var diceValue: Int = 0

    repeat(3) {
        val diceNum = stz.nextToken().toInt()
        diceCount[diceNum]++
        if (diceCount[diceNum] > maxCount) {
            maxCount = diceCount[diceNum]
            diceValue = diceNum
        }
    }

    when (maxCount) {
        3 -> return 10000 + diceValue * 1000
        2 -> return 1000 + diceValue * 100
    }

    var sum: Int = 0
    for (i in 6 downTo 1) {
        if (diceCount[i] != 0) {
            sum = i * 100
            break
        }
    }

    return sum
}