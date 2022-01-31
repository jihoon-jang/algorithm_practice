import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val rectangle = Array(101) { Array(101) { false } }

    repeat(4) {
        val points = br.readLine().split(" ")
        val x1: Int = points[0].toInt()
        val y1: Int = points[1].toInt()
        val x2: Int = points[2].toInt()
        val y2: Int = points[3].toInt()

        for (y in y1 until y2) {
            for (x in x1 until x2) {
                rectangle[x][y] = true
            }
        }
    }

    print(rectangle.sumOf { it.count { it } })
}
