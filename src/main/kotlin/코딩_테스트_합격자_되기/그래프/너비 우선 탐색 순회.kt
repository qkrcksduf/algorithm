package 코딩_테스트_합격자_되기.그래프

import java.util.LinkedList
import java.util.Queue

class `너비 우선 탐색 순회` {

    fun solution(graph: Array<IntArray>, start: Int, n: Int): IntArray {
        val queues: Array<MutableList<Int>> = Array<MutableList<Int>>(n + 1) { mutableListOf() }.apply {
            graph.forEach { this[it[0]].add(it[1]) }
        }

        println(queues.contentToString())

        val result = ArrayList<Int>()
        val visited = BooleanArray(n + 1)

        // 1을 돌때 2와 3을 먼저 찍는다
        // 2를 돌아서 4, 5를 찍는다.
        // 3을 돌아서 6을 찍는다.
        //
        fun bfs(start: Int) {
            val queue: Queue<Int> = LinkedList()
            queue.add(start)
            visited[start] = true

            while (queue.isNotEmpty()) {
                val current = queue.poll()
                result.add(current)

                for (neighbor in queues[current]) {
                    if (!visited[neighbor]) {
                        visited[neighbor] = true
                        queue.add(neighbor)
                    }
                }
            }
        }

        bfs(start)
        return result.toIntArray()
    }

}

fun main() {
    val result1 = `너비 우선 탐색 순회`().solution(
        arrayOf(
            intArrayOf(1, 2), intArrayOf(1, 3), intArrayOf(2, 4), intArrayOf(2, 5), intArrayOf(3, 6), intArrayOf(3, 7),
            intArrayOf(4, 8), intArrayOf(5, 8), intArrayOf(6, 9), intArrayOf(7, 9)
        ), 1, 9
    )

    val result2 = `너비 우선 탐색 순회`().solution(
        arrayOf(
            intArrayOf(1, 3),
            intArrayOf(3, 4),
            intArrayOf(3, 5),
            intArrayOf(5, 2),
        ), 1, 5
    )
    println(result1.contentToString())
    println(result2.contentToString())
}