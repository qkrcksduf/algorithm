package 코딩_테스트_합격자_되기.그래프

class `깊이 우선 탐색 순회` {
    /**
     * 각 노드에 연결된 노드들을 인접 리스트로 연결한다.
     * dfs를 통해 방문한다
     * 방문할 경우 해당 결과를 저장한다.
     * 재귀를 통해 최대 깊이까지 탐색한다.
     */
    fun solution(graph: Array<IntArray>, start: Int, n: Int): IntArray {
        val adjList = Array(n + 1) { mutableListOf<Int>() }.apply {
            graph.forEach { this[it[0]].add(it[1]) }
        }

        println(adjList.contentToString())

        val visited = BooleanArray(n + 1)
        val answer = ArrayList<Int>()

        fun dfs(node: Int) {
            visited[node] = true
            answer.add(node)
            adjList[node].forEach { if (!visited[it]) dfs(it) }
        }

        dfs(start)

        return answer.toIntArray()
    }
}

fun main() {
    val result1 = `깊이 우선 탐색 순회`().solution(
        arrayOf(intArrayOf(1, 2), intArrayOf(2, 3), intArrayOf(3, 4), intArrayOf(4, 5)), 1, 5
    )

    val result2 = `깊이 우선 탐색 순회`().solution(
        arrayOf(
            intArrayOf(1, 2),
            intArrayOf(1, 3),
            intArrayOf(2, 4),
            intArrayOf(2, 5),
            intArrayOf(3, 6),
            intArrayOf(5, 6)
        ), 1, 6
    )
    println(result1.contentToString())
    println(result2.contentToString())
}