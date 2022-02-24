fun main() = with(System.out.bufferedWriter()) {
    val br = System.`in`.bufferedReader()
    val sb = StringBuilder()

    repeat(br.readLine().toInt()) {
        var name = ""
        var amount = 0
        repeat(br.readLine().toInt()) {
            val (schoolName, alcohol) = br.readLine().split(' ')
            if (alcohol.toInt() > amount) {
                amount = alcohol.toInt()
                name = schoolName
            }
        }
        sb.append("$name\n")
    }

    write(sb.toString())
    close()
}