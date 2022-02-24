fun main() = with(System.out.bufferedWriter()) {
    val br = System.`in`.bufferedReader()
    val count = IntArray(5)

    repeat(br.readLine().toInt()) {
        val (x, y) = br.readLine().split(' ').map { it.toInt() }
        when {
            x > 0 && y > 0 -> count[1]++
            x < 0 && y > 0 -> count[2]++
            x < 0 && y < 0 -> count[3]++
            x > 0 && y < 0 -> count[4]++
            else -> count[0]++
        }
    }

    write("Q1: ${count[1]}\n" +
            "Q2: ${count[2]}\n" +
            "Q3: ${count[3]}\n" +
            "Q4: ${count[4]}\n" +
            "AXIS: ${count[0]}")
    close()
}