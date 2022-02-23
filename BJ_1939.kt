import java.lang.Integer.min
import java.util.*

const val MAX = 1_000_000_000 + 1

fun main() = with(System.out.bufferedWriter()) {
    val br = System.`in`.bufferedReader()
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val bridges = Array(n + 1) { ArrayList<Pair<Int, Int>>() }
    for (i in 0 until m) {
        val (land1, land2, weight) = br.readLine().split(" ").map { it.toInt() }
        bridges[land1].add(Pair(land2, weight))
        bridges[land2].add(Pair(land1, weight))
    }
    val (start, end) = br.readLine().split(" ").map { it.toInt() }

    write("${getMaxWeight(start, end, n, bridges)}")
    close()
}

private fun getMaxWeight(start: Int, end: Int, n: Int, bridges: Array<ArrayList<Pair<Int, Int>>>): Int {
    val pq = PriorityQueue<Pair<Int, Int>>(kotlin.Comparator { a, b ->
        when {
            a.second < b.second -> 1
            a.second > b.second -> -1
            else -> 0
        }
    })
    val visit = BooleanArray(n + 1)
    var maxWeight = MAX
    pq.add(Pair(start, MAX))

    while (pq.isNotEmpty()) {
        val pair = pq.poll()
        visit[pair.first] = true
        maxWeight = min(maxWeight, pair.second)
        if (pair.first == end) {
            break
        }

        for (bridge in bridges[pair.first]) {
            if (!visit[bridge.first] && bridge.first != start) {
                pq.add(bridge)
            }
        }
    }

    return maxWeight
}