import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

private fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val stz = StringTokenizer(br.readLine());
    val loop = stz.nextToken()!!.toInt()

    repeat(loop) {
        println("%.2f".format(calculator(br.readLine())))
    }
}

private fun calculator(inputLine: String): Double {
    val stz = StringTokenizer(inputLine)
    var number = stz.nextToken().toDouble()

    while (stz.hasMoreTokens()) {
        when (stz.nextToken()) {
            "@" -> number *= 3
            "%" -> number += 5
            "#" -> number -= 7
        }
    }

    return number
}