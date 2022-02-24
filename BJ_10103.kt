fun main() = with(System.out.bufferedWriter()) {
    val br = System.`in`.bufferedReader()
    var c = 100
    var s = 100

    repeat(br.readLine().toInt()) {
        val (cDice, sDice) = br.readLine().split(' ').map { it.toInt() }
        when {
            cDice > sDice -> s -= cDice
            cDice < sDice -> c -= sDice
        }
    }

    write("$c\n$s")
    close()
}