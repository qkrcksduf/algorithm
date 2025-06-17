package 코딩_테스트_합격자_되기.트리

class Solution13 {
    // 전위 순회 (루트, 왼쪽 서브 트리, 오른쪽 서브 트리)
    fun preorder(nodes: IntArray, idx: Int): String {
        if (idx >= nodes.size) {
            return ""
        }

        return " " + nodes[idx]+
                preorder(nodes, 2 * idx + 1) +
                preorder(nodes, 2 * idx + 2)

    }
//    fun preorder(nodes: IntArray, idx: Int): String {
//        if (idx >= nodes.size) {
//            return ""
//        }
//
//        return " " + nodes[idx] +
//                preorder(nodes, 2 * idx + 1) +
//                preorder(nodes, 2 * idx + 2)
//    }

    // 중위 순회 (왼쪽, 부모, 오른쪽)
    fun inorder(nodes: IntArray, idx: Int): String {
        if (idx >= nodes.size) {
            return ""
        }

        return inorder(nodes, 2 * idx + 1) +
                nodes[idx] + " " +
                inorder(nodes, 2 * idx + 2)
    }

    // 후위 순회 (왼쪽, 오른쪽, 부모)
    fun postorder(nodes: IntArray, idx: Int): String {
        if (idx >= nodes.size) {
            return ""
        }
        return postorder(nodes, 2 * idx + 1) +
                postorder(nodes, 2 * idx + 2) +
                nodes[idx] + " "
    }


}

fun main() {
    val result: Array<String> = Array(6) { "" }
    val nodes = intArrayOf(1, 2, 3, 4, 5, 6, 7)
    result[0] = Solution13().preorder(nodes, 0).trim()
    result[1] = Solution13().inorder(nodes, 0).trim()
    result[2] = Solution13().postorder(nodes, 0).trim()
    for (i in result) {
        println(i)
    }
}