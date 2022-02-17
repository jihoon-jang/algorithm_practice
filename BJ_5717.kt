import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var stz: StringTokenizer
    val sb = StringBuilder()

    while (true) {
        stz = StringTokenizer(br.readLine())
        val m = stz.nextToken().toInt()
        val f = stz.nextToken().toInt()

        if (m == 0 && f == 0) {
            break
        }
        sb.append(m + f).append("\n")
    }

    print(sb.toString())
}