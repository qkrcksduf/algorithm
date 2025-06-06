import java.util.*

fun main() {
    val N = 6
    val A = intArrayOf(1, 1, 2, 2, 3, 4, 5)
    val B = intArrayOf(2, 3, 4, 5, 6, 6, 6)
    val graph = Array(N + 1) { mutableListOf<Int>() }
    for (i in A.indices) {
        graph[A[i]].add(B[i])
        graph[B[i]].add(A[i])
    }

    println("DFS Traversal: ")
    val visitedDfs = BooleanArray(N + 1)
    dfs(1, graph, visitedDfs)
    println("\nBFS Traversal: ")
    bfs(1, graph)
}

fun bfs(start: Int, graph: Array<MutableList<Int>>) {
    val visited = BooleanArray(graph.size)
    val queue: Queue<Int> = LinkedList()

    queue.add(start)
    visited[start] = true

    while (queue.isNotEmpty()) {
        val node = queue.poll()
        print("$node ")
        for (neighbor in graph[node]) {
            if (!visited[neighbor]) {
                queue.add(neighbor)
                visited[neighbor] = true
            }
        }
    }
}

fun dfs(node: Int, graph: Array<MutableList<Int>>, visited: BooleanArray) {
    visited[node] = true
    print("$node ")
    for (neighbor in graph[node]) {
        if (!visited[neighbor]) {
            dfs(neighbor, graph, visited)
        }
    }
}