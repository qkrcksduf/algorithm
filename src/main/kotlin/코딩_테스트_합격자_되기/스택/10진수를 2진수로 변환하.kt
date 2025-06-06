package 코딩_테스트_합격자_되기.스택

import java.util.Stack

class Solution7 {
    fun solution(n: Int): String {
        var number = n
        val stack = Stack<Int>()
        while (number > 0) {
            val value = number % 2
            stack.push(value)
            number /= 2
        }
        val answer: StringBuilder = StringBuilder()
        while (!stack.isEmpty()) {
            answer.append(stack.pop())
        }
        return answer.toString()
    }
}

fun main() {
    println(Solution7().solution(10)) // 1010
    println(Solution7().solution(27)) //11011
    println(Solution7().solution(12345)) // 11000000111001
}
