fun main() {
    // 테스트 케이스 1
    val n1 = 4
    val a1 = intArrayOf(1, 2, 4, 4, 3)
    val b1 = intArrayOf(2, 3, 1, 3, 1)
    println("Test Case 1: " + solution4(n1, a1, b1)) // 예상 결과: true

    // 테스트 케이스 2
    val n2 = 4
    val a2 = intArrayOf(1, 2, 1, 3)
    val b2 = intArrayOf(2, 4, 3, 4)
    println("Test Case 2: " + solution4(n2, a2, b2)) // 예상 결과: false

    // 테스트 케이스 3
    val n3 = 6
    val a3 = intArrayOf(2, 4, 5, 3)
    val b3 = intArrayOf(3, 5, 6, 4)
    println("Test Case 3: " + solution4(n3, a3, b3)) // 예상 결과: false

    // 테스트 케이스 4
    val n4 = 3
    val a4 = intArrayOf(1, 3)
    val b4 = intArrayOf(2, 2)
    println("Test Case 4: " + solution4(n4, a4, b4)) // 예상 결과: true
}

fun solution4(N: Int, A: IntArray, B: IntArray): Boolean {
    val graph = Array(N + 1) { BooleanArray(N + 1) { false } }

    for (i in A.indices) {
        graph[A[i]][B[i]] = true
        graph[B[i]][A[i]] = true
    }

    val visited = BooleanArray(N + 1) { false }
    visited[0] = true
    visited[1] = true

    for (i in 0 until N) {
        if (graph[i][i + 1] || graph[i + 1][i]) {
            visited[i] = true
        }
    }

    for (i in 1 until visited.size - 1) {
        if (!visited[i]) return false
    }

    return true
}