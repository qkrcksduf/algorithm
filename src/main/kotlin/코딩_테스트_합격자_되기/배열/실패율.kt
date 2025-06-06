package 배열

class Solution4 {
    fun solution(N: Int, stages: IntArray): IntArray {
        var remainPerson = stages.size
        val failCount = IntArray(N)
        val failRateMap = mutableMapOf<Int, Double>()

        for (i in 1..N) {
            failCount[i - 1] = stages.count { it == i }
        }

        for (i in 1..N) {
            val currentFailCount = failCount[i - 1]
            val failRate = if (remainPerson > 0) {
                currentFailCount / remainPerson.toDouble()
            } else {
                0.0
            }
            failRateMap[i] = failRate
            remainPerson -= currentFailCount
        }

        val sortedFailRate =
            failRateMap.entries
                .sortedWith(compareByDescending<MutableMap.MutableEntry<Int, Double>> { it.value }
                    .thenBy { it.key })
        return sortedFailRate.map { it.key }.toIntArray()
    }
}

// 인덱스와 인덱스에 해당하는 실패율을 현재 알고 있음
// 이것을 정렬할때 실패율을 기준으로 내림차순 정렬을 하면된다.

fun main() {
    var n = 5
    var stages = intArrayOf(2, 1, 2, 6, 2, 4, 3, 3)

    println(Solution4().solution(n, stages).joinToString(" "))

    n = 4
    stages = intArrayOf(4, 4, 4, 4, 4)
    println(Solution4().solution(n, stages).joinToString(" "))
}

// 스테이지의 수
// 현재 사용자가 머물고 있는 스테이지의 번호
// 실패율이 같을 오름 차순 정렬