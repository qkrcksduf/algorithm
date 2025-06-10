package 코딩_테스트_합격자_되기.큐

class Solution11 {
    // 뒤에 있는 기능은 앞에 있는 기능보다 먼저 개발될 수는 있으나, 앞에 있는 기능이 배포되어야 뒤에 있는 기능도 배포가 가능하다.
    fun solution(progresses: IntArray, speeds: IntArray): IntArray {
        val workDays = ArrayDeque<Int>()
        var answer = intArrayOf()
        for (i in progresses.indices) {
            val q = (100 - progresses[i]) / speeds[i]
            val r = (100 - progresses[i]) % speeds[i]
            val workDay = if (r != 0) q + 1 else q
            workDays.add(workDay)
        }
        while (workDays.isNotEmpty()) {
            var count = 1
            val deployWork = workDays.removeFirst()
            while (workDays.isNotEmpty() && deployWork >= workDays.first()) {
                count++
                workDays.removeFirst()
            }
            answer = answer.plus(count)
        }

        return answer
    }
}

fun main() {
    // 첫번째 작업 7일, 두번째 작업 3일, 3번째 작업 9일 필요
    // 작업 일정 7일에 두작업 배포 가능
    // 작업 일정 9일에 한 작업 배포 가능
    // 결과 (2,1)
    val result = Solution11().solution(intArrayOf(93, 30, 55), intArrayOf(1, 30, 5))
    for (i in result) {
        println(i)
    }
//    println(Solution11().solution(intArrayOf(93, 30, 55), intArrayOf(1, 30, 5)))
    // 작업 일정 5,10,1,1,20,1
    // 작업 일정 5일 뒤에 한개 작업 배포 가능
    // 작업 일정 10 일 뒤에 3개 작업 배포 가능
    // 작업 일정 20일 뒤에 2개 작업 배포 가능
    // 결과 (1,3,2)
    val result2 = Solution11().solution(intArrayOf(95, 90, 99, 99, 80, 99), intArrayOf(1, 1, 1, 1, 1, 1))
    for (i in result2) {
        println(i)
    }
//    println(Solution11().solution(intArrayOf(95, 90, 99, 99, 80, 99), intArrayOf(1, 1, 1, 1, 1, 1)))
}