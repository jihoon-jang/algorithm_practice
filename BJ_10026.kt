import java.io.BufferedReader
import java.io.InputStreamReader

val dx = intArrayOf(-1, 0, 1, 0)
val dy = intArrayOf(0, 1, 0, -1)

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val map = Array(n) { Array(n) { ' ' } }
    var visit = Array(n) { Array(n) { false } }

    for (i in 0 until n) {
        val line = br.readLine()
        for (j in 0 until n) {
            map[i][j] = line[j]
        }
    }

    val normal = getZoneCount(map, visit)
    convertMap(map)
    visit = Array(n) { Array(n) { false } }
    val abnormal = getZoneCount(map, visit)

    print("$normal $abnormal")
}

private fun getZoneCount(map: Array<Array<Char>>, visit: Array<Array<Boolean>>): Int {
    var count = 0
    for (i in map.indices) {
        for (j in map.indices) {
            if (!visit[i][j]) {
                count++
                dfs(map, visit, i, j, map[i][j])
            }
        }
    }

    return count
}

private fun dfs(map: Array<Array<Char>>, visit: Array<Array<Boolean>>, x: Int, y: Int, beforeChar: Char) {
    if (visit[x][y]) {
        return
    }
    visit[x][y] = true
    for (i in 0 until 4) {
        val nx = x + dx[i]
        val ny = y + dy[i]
        if (isValidPoint(Point(nx, ny), map.size) && beforeChar == map[nx][ny]) {
            dfs(map, visit, nx, ny, beforeChar)
        }
    }
}

private fun convertMap(map: Array<Array<Char>>) {
    for (i in map.indices) {
        for (j in map.indices) {
            if (map[i][j] == 'R') {
                map[i][j] = 'G'
            }
        }
    }
}

private fun isValidPoint(point: Point, n: Int): Boolean = point.x >= 0 && point.y >= 0 && point.x < n && point.y < n

private class Point(val x: Int, val y: Int)