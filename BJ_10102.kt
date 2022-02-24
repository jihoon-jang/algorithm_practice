fun main() = with(System.out.bufferedWriter()) {
    val br = System.`in`.bufferedReader()
    val v = br.readLine().toInt()
    val input = br.readLine()
    val aCount = input.count() { it == 'A' }
    val bCount = v - aCount

    write(if (aCount > bCount) "A" else if (aCount < bCount) "B" else "Tie")
    close()
}