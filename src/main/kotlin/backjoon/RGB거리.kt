package backjoon


//fun main() {
//    val n = readln().toInt() // 집의 개수 입력
//    val costs = Array(n) { readln().split(" ").map { it.toInt() } } // 비용 입력
//
//    // DP 배열 초기화
//    val dp = Array(n) { IntArray(3) }
//    dp[0][0] = costs[0][0]
//    dp[0][1] = costs[0][1]
//    dp[0][2] = costs[0][2]
//
//    // DP 계산
//    for (i in 1 until n) {
//        dp[i][0] = costs[i][0] + minOf(dp[i - 1][1], dp[i - 1][2])
//        dp[i][1] = costs[i][1] + minOf(dp[i - 1][0], dp[i - 1][2])
//        dp[i][2] = costs[i][2] + minOf(dp[i - 1][0], dp[i - 1][1])
//    }
//
//    // 최소 비용 출력
//    println(minOf(dp[n - 1][0], dp[n - 1][1], dp[n - 1][2]))
//}

fun main() {
    val n = readln().toInt()
    val costs = Array(n) { readln().split(" ").map { it.toInt() } }

    // DP 배열 초기화
    val dp = Array(n) { IntArray(3) }
    dp[0][0] = costs[0][0]
    dp[0][1] = costs[0][1]
    dp[0][2] = costs[0][2]

    for (i in 1 until n) {
        dp[i][0] = costs[i][0] + minOf(dp[i - 1][1], dp[i - 1][2])
        dp[i][1] = costs[i][1] + minOf(dp[i - 1][0], dp[i - 1][2])
        dp[i][2] = costs[i][2] + minOf(dp[i - 1][0], dp[i - 1][1])
    }

    println(minOf(dp[n - 1][0], dp[n - 1][1], dp[n - 1][2]))
    println("${dp[n - 1][0]}, ${dp[n - 1][1]}, ${dp[n - 1][2]}")
}

// 첫째 줄에 집의 수 N이 주어진다.
// 둘째 줄부터 N개의 줄에는 각 집을 빨강, 초록, 파랑으로 칠하는 비용이 1번 집부터 한 줄에 하나씩 주어진다.

// 3
// 26 40 83
// 49 60 57
// 13 89 99
// 인접한 것과는 하지 않는다.

// 빨강인 경우
// 26 + 57 + 13

// 1 + 1 + 1

// 1 + 100 + 1

// 5 + 64 + 19 + 4 + 84 + 32

// 최단 거리 알고리즘

// 점심먹고 커피먹어야겠다.