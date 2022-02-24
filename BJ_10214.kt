fun main() = with(System.out.bufferedWriter()) {
    val br = System.`in`.bufferedReader()
    val sb = StringBuilder()

    with(sb) {
        repeat(br.readLine().toInt()) {
            var yonsei = 0
            var korea = 0
            repeat(9) {
                val (y, k) = br.readLine().split(' ').map { it.toInt() }
                yonsei += y
                korea += k
            }
            when {
                yonsei > korea -> append("Yonsei\n")
                yonsei < korea -> append("Korea\n")
                else -> append("Draw\n")
            }
        }
    }

    write(sb.toString())
    close()
}