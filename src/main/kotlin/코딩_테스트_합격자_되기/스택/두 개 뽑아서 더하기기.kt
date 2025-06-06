package 코딩_테스트_합격자_되기.스택

class Solution {
    fun solution(numbers: IntArray): IntArray {
        val answer: HashSet<Int> = hashSetOf()
        for (i in numbers.indices) {
            for (j in i + 1..numbers.indices.last) {
                answer += numbers[i] + numbers[j]
            }
        }

        return answer.sorted().toIntArray()
    }
}

fun main() {
    val input = intArrayOf(2, 1, 3, 4, 1)
    println(Solution().solution(input).joinToString(""))
}