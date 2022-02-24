fun main() = with(System.out.bufferedWriter()) {
    val br = System.`in`.bufferedReader()
    val sb = StringBuilder()

    with(sb) {
        while (true) {
            val number = br.readLine().toInt()
            if (number == -1) {
                break
            }
            val divisor = ArrayList<Int>()

            for (i in 1..number / 2) {
                if (number % i == 0) {
                    divisor.add(i)
                }
            }
            if (number == divisor.sum()) {
                append("$number = ${divisor.joinToString(" + ")}\n")
            } else {
                append("$number is NOT perfect.\n")
            }
        }
    }

    write(sb.toString())
    close()
}