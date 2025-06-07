package 코딩_테스트_합격자_되기.스택

import java.util.*

// 1. 길이를 구한다
// 2. 0~인덱스 크기만큼 돌면서 회전시킨다.
// 3. 회전시킨 문자열의 괄호가 맞는지 확인한다.
class Solution8 {
    fun solution(s: String): Int {
        var answer = 0
        for (i in s.indices) {
            val rotated = s.substring(i) + s.substring(0, i)
            val stack = Stack<Char>()
            var isValid = true
            for (ch in rotated) {
                when (ch) {
                    '(', '[', '{' -> stack.push(ch)
                    ')' -> if (stack.isEmpty() || stack.pop() != '(') {
                        isValid = false
                        break
                    }

                    ']' -> if (stack.isEmpty() || stack.pop() != '[') {
                        isValid = false
                        break
                    }
                    '}' -> if (stack.isEmpty() || stack.pop() != '{') {
                        isValid = false
                        break
                    }
                }
            }
            if (isValid && stack.isEmpty()) answer++

        }


        return answer
    }
}

fun main() {
    println(Solution8().solution("[](){}")) // 3
    println(Solution8().solution("}]()[{")) // 2
    println(Solution8().solution("[)(]")) // 0
    println(Solution8().solution("}}}")) // 0
}
