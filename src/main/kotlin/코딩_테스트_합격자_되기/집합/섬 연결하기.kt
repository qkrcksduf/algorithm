package 코딩_테스트_합격자_되기.집합

/**
 * 최소 신장 트리, 집합 문제
 * 각 섬 사이의 다리를 건설하는 비용을 오름차순으로 정렬
 * 비용이 작은 다리부터 선택해 섬을 연결
 * N개의 섬을 연결하려면 N-1의 다리가 필요하므로 N-1개의 다리가 선택될 때까지 위 두 과정을 반복
 * 비용을 최소화하기 위해 다리를 추가할 때 사이클을 형성하지 않도록 함
 */

data class Edge(val u: Int, val v: Int, val cost: Int)

class `섬 연결하기` {
    fun solution(n: Int, costs: Array<IntArray>): Int {
        // 1) 모든 간선 정보를 Edge 리스트로 만들고 비용 오름차순 정렬
        val edges = costs
            .map { Edge(it[0], it[1], it[2]) }
            .sortedBy { it.cost }

        println(edges)

        val parent = IntArray(n) { it }
        println(parent.contentToString())

        fun find(x: Int): Int {
            if (parent[x] != x) {
                parent[x] = find(parent[x])
            }
            return parent[x]
        }

        fun union(a: Int, b: Int): Boolean {
            val ra = find(a)
            val rb = find(b)
            if (ra == rb) return false
            parent[rb] = ra
            return true
        }

        var totalCost = 0
        var edgesUsed = 0

        for ((u, v, cost) in edges) {

            if (union(u, v)) {
                println(parent.contentToString())
                totalCost += cost
                edgesUsed++
                if (edgesUsed == n - 1) break
            }
        }
        return totalCost
    }
}

fun main() {
    val result = `섬 연결하기`().solution(
        4,
        arrayOf(intArrayOf(0, 1, 1), intArrayOf(0, 2, 2), intArrayOf(1, 3, 1), intArrayOf(2, 3, 8))
    )
    println(result)
}