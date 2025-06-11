package 코딩_테스트_합격자_되기.해시

class Solution11 {
    fun solution(n: HashSet<Int>, target: Int): Boolean {
        for (i in n) {
            if (target - i != i && n.contains(target - i)) return true
        }
        return false
    }
}

fun main() {
    println(Solution11().solution(hashSetOf(1, 2, 3, 4, 8), 6))
    println(Solution11().solution(hashSetOf(2, 3, 5, 9), 10))
}