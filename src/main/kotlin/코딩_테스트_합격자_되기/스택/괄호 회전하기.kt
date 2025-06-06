package 코딩_테스트_합격자_되기.스택

class Solution8 {
    fun solution(s: String): Int {
        var answer: Int = -1
        return answer
    }
}

fun main() {
    println(Solution8().solution("[](){}")) // 3
    println(Solution8().solution("}]()[{")) // 2
    println(Solution8().solution("[)(]")) // 0
    println(Solution8().solution("}}}")) // 0
}