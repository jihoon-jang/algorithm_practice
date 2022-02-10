import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val word = br.readLine()
    val count = IntArray(26) { 0 }

    for (c in word) {
        count[c - 'a']++
    }

    count.forEach { print("$it ") }
}