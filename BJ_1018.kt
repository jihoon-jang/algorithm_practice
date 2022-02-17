import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.math.min

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val stz = StringTokenizer(br.readLine())
    val n = stz.nextToken().toInt()
    val m = stz.nextToken().toInt()
    val board = Array(n) { Array(m) { ' ' } }
    val whiteBoard = Array(8) { Array(8) { 'W' } }
    val blackBoard = Array(8) { Array(8) { 'B' } }
    fillWhiteBoard(whiteBoard)
    fillBlackBoard(blackBoard)

    for (i in 0 until n) {
        val line = br.readLine()
        for (j in 0 until m) {
            board[i][j] = line[j]
        }
    }

    print(countDiff(whiteBoard, blackBoard, board))
}

fun fillWhiteBoard(whiteBoard: Array<Array<Char>>) {
    for (i in 0 until 8) {
        for (j in 0 until 8) {
            whiteBoard[i][j] = when ((i + j) % 2) {
                0 -> 'W'
                else -> 'B'
            }
        }
    }
}

fun fillBlackBoard(blackBoard: Array<Array<Char>>) {
    for (i in 0 until 8) {
        for (j in 0 until 8) {
            blackBoard[i][j] = when ((i + j) % 2) {
                1 -> 'W'
                else -> 'B'
            }
        }
    }
}

fun countDiff(whiteBoard: Array<Array<Char>>, blackBoard: Array<Array<Char>>, board: Array<Array<Char>>): Int {
    var whiteCount = 64
    var blackCount = 64

    for (i in 0..board.size - 8) {
        for (j in 0..board[0].size - 8) {
            var whiteTempCount = 0
            var blackTempCount = 0

            for (x in 0 until 8) {
                for (y in 0 until 8) {
                    val c = board[x + i][y + j]
                    val white = whiteBoard[x][y]
                    val black = blackBoard[x][y]

                    if (c != white) {
                        whiteTempCount++
                    }
                    if (c != black) {
                        blackTempCount++
                    }
                }
            }
            whiteCount = min(whiteTempCount, whiteCount)
            blackCount = min(blackTempCount, blackCount)

            if (whiteCount == 0 || blackCount == 0) {
                return 0
            }
        }
    }
    return min(whiteCount, blackCount)
}