import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val year: Int = br.readLine().toInt()
    val minusValue: Int = 543

    print(year - minusValue)
}