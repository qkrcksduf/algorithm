import java.util.*

fun main() {
    // 테스트 케이스 1
    val n1 = 4
    val a1 = intArrayOf(1, 2, 4, 4, 3)
    val b1 = intArrayOf(2, 3, 1, 3, 1)
    println("Test Case 1: " + solution2(n1, a1, b1)) // 예상 결과: true

    // 테스트 케이스 2
    val n2 = 4
    val a2 = intArrayOf(1, 2, 1, 3)
    val b2 = intArrayOf(2, 4, 3, 4)
    println("Test Case 2: " + solution2(n2, a2, b2)) // 예상 결과: false

    // 테스트 케이스 3
    val n3 = 6
    val a3 = intArrayOf(2, 4, 5, 3)
    val b3 = intArrayOf(3, 5, 6, 4)
    println("Test Case 3: " + solution2(n3, a3, b3)) // 예상 결과: false

    // 테스트 케이스 4
    val n4 = 3
    val a4 = intArrayOf(1, 3)
    val b4 = intArrayOf(2, 2)
    println("Test Case 4: " + solution2(n4, a4, b4)) // 예상 결과: true
}

fun solution2(N: Int, A: IntArray, B: IntArray): Boolean {
    // 그래프를 인접 리스트로 변환
    val graph = Array(N + 1) { mutableListOf<Int>() }
    for (i in A.indices) {
        graph[A[i]].add(B[i])
        graph[B[i]].add(A[i])
    }

    // 방문 여부 배열 및 BFS 큐
    val visited = BooleanArray(N + 1)
    val queue: Queue<Int> = LinkedList()

    // 시작 정점 1을 큐에 추가하고 방문 처리
    queue.add(1)
    visited[1] = true

    // BFS 탐색
    while (queue.isNotEmpty()) {
        val currentNode = queue.poll()

        // 현재 노드와 연결된 노드들을 확인하고 오름차순으로 방문
        for (neighbor in graph[currentNode]) {
            // neighbor가 currentNode보다 크고 아직 방문하지 않은 경우에만 방문
            if (!visited[neighbor] && neighbor == currentNode + 1) {
                visited[neighbor] = true
                queue.add(neighbor)
            }
        }
    }

    // 정점 1부터 N까지 모두 방문할 수 있는지 확인
    return visited[N]
}


