import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

private fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val stz = StringTokenizer(br.readLine())
    val num1Str: String = stz.nextToken()
    val num2Str: String = stz.nextToken()

    print(
        "${num1Str.replace('6', '5').toInt() + num2Str.replace('6', '5').toInt()} " +
                "${num1Str.replace("5", "6").toInt() + num2Str.replace("5", "6").toInt()}"
    )
}