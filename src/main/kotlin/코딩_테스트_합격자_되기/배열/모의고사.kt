package 코딩_테스트_합격자_되기.배열

class Solution2 {
    fun solution(answers: IntArray): IntArray {
        val number1 = intArrayOf(1, 2, 3, 4, 5)
        val number2 = intArrayOf(2, 1, 2, 3, 2, 4, 2, 5)
        val number3 = intArrayOf(3, 3, 1, 1, 2, 2, 4, 4, 5, 5)

        val countArray = IntArray(3)

        for (i in answers.indices) {
            if (answers[i] == number1[i % 5]) countArray[0]++
            if (answers[i] == number2[i % 8]) countArray[1]++
            if (answers[i] == number3[i % 10]) countArray[2]++
        }

        val max = countArray.maxOrNull()
        return countArray.toList()
            .mapIndexedNotNull { index, score -> if (score == max) index + 1 else null }
            .toTypedArray()
            .toIntArray()
    }
}

fun main() {
    println(Solution2().solution(intArrayOf(1, 2, 3, 4, 5)).joinToString(""))
    println(Solution2().solution(intArrayOf(1, 3, 2, 4, 2)).joinToString(""))
}