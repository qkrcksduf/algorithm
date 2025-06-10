package 코딩_테스트_합격자_되기.큐

import kotlin.collections.ArrayDeque

class Solution10 {
    // 1번 번호표를 가진 사람을 기준으로 K번째 사람을 없앤다.
    // 없앤 다음 사람 기준으로 다시 K번째 사람을 없앤다.
    // 가장 마지막에 남은 사람의 번호표를 반환한다.
    fun solution(n: Int, k: Int): Int {
        val queue = ArrayDeque<Int>()
        for (i in 1..n) {
            queue.add(i)
        }

        while (queue.size > 1) {
            for (i in 0 until k - 1) {
                queue.addLast(queue.removeFirst())
            }
            queue.removeFirst()
        }
        return queue.first()
    }


}

fun main() {
    println(Solution10().solution(5, 2))
}