import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

val br = BufferedReader(InputStreamReader(System.`in`))
var stz = StringTokenizer("")
val computerCount = br.readLine().toInt()
val network = br.readLine().toInt()
val infection = Array(computerCount + 1) { false }
val connection = Array(computerCount + 1) { ArrayList<Int>() }
val queue = LinkedList<Int>()

private fun main() {
    for (i in 0 until network) {
        stz = StringTokenizer(br.readLine())
        val computer1 = stz.nextToken().toInt()
        val computer2 = stz.nextToken().toInt()

        connection[computer1].add(computer2)
        connection[computer2].add(computer1)
    }

    for (computerNo in connection[1]) {
        queue.push(computerNo)
    }
    infection[1] = true
    infect()
    print(count() - 1)
}

private fun infect() {
    while (queue.isNotEmpty()) {
        val computerNo = queue.poll()

        if (!infection[computerNo]) {
            infection[computerNo] = true

            for (nextComputer in connection[computerNo]) {
                queue.push(nextComputer)
            }
        }
    }
}

private fun count(): Int {
    var count = 0

    for (i in infection) {
        if (i) {
            count++
        }
    }
    return count
}