package 배열

class Solution3 {
    fun solution(arr1: Array<IntArray>, arr2: Array<IntArray>): Array<IntArray> {
        val answer = Array(arr1.size) { IntArray(arr2[0].size) }

        for (i in arr1.indices) {
            for (j in arr2[0].indices) {
                for (k in arr2.indices) {
                    answer[i][j] += arr1[i][k] * arr2[k][j]
                }
            }
        }
        return answer
    }
}

fun main() {
    val arr1: Array<IntArray> = arrayOf(intArrayOf(1, 4), intArrayOf(3, 2), intArrayOf(4, 1))
    val arr2: Array<IntArray> = arrayOf(intArrayOf(3, 3), intArrayOf(3, 3))
    val result = Solution3().solution(arr1, arr2)
    for (i in result.indices) {
        for (j in result[0].indices) {
            println(result[i][j])
        }
    }
}