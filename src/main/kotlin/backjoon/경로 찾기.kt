package backjoon

import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)
    val n = scanner.nextInt()
    val graph = Array(n) { IntArray(n) }

    // 인접 행렬 입력 받기
    for (i in 0 until n) {
        for (j in 0 until n) {
            graph[i][j] = scanner.nextInt()
        }
    }

    // 플로이드-워셜 알고리즘 적용
    for (k in 0 until n) {
        for (i in 0 until n) {
            for (j in 0 until n) {
                if (graph[i][k] == 1 && graph[k][j] == 1) {
                    graph[i][j] = 1
                }
            }
        }
    }

    // 결과 출력
    for (i in 0 until n) {
        println(graph[i].joinToString(" "))
    }
}