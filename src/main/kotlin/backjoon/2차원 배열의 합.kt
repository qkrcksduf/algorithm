package backjoon

import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)

    val n = scanner.nextInt()
    val m = scanner.nextInt()

    val matrix = Array(n) { IntArray(m) }

    for (i in 0 until n) {
        for (j in 0 until m) {
            matrix[i][j] = scanner.nextInt()
        }
    }

    val k = scanner.nextInt()
    scanner.nextLine()

    val sumList = mutableListOf<Int>()
    for (a in 0 until k) {
        val (i, j, x, y) = scanner.nextLine().split(" ").map { it.toInt() }
        var sum = 0
        for (b in i - 1 until x) {
            for (c in j - 1 until y) {
                sum += matrix[b][c]
            }
        }
        sumList.add(sum)
    }

    sumList.forEach { println(it) }
}
