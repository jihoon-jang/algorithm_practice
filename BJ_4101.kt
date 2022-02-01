import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val sb = StringBuilder()

    while (true) {
        val stz = StringTokenizer(br.readLine())
        val number1 = stz.nextToken().toInt()
        val number2 = stz.nextToken().toInt()

        if (number1 > number2) {
            sb.append("Yes\n")
        } else if (number1 == 0 && number2 == 0) {
            break;
        } else {
            sb.append("No\n")
        }
    }

    print(sb.toString())
}