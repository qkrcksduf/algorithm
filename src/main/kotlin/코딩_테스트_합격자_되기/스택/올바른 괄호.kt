package 코딩_테스트_합격자_되기.스택

import java.util.Stack

//       스택에서 한개씩 빼면서 단순 문자열일 경우 없애
//        괄호 일경우 해당 괄호에 해당하는 닫기 괄호가 있는지 확인 닫기 괄호가 있으면 닫기 괄호와 해당 괄호를 제거
//        남은 스택 데이터로 다시 판단
// 맨 처음 들어가는게 )만 아니면 개수로 비교해도 될듯?
class Solution6 {
    fun solution(s: String): Boolean {
        val stack = Stack<Char>()
        for (i in s.indices) {
            if (s[i] == '(') {stack.push(s[i])}
            else if (s[i] == ')') {
                if (stack.isEmpty()) return false
                stack.pop()
            }
        }
        return stack.isEmpty()
    }
}

fun main() {
    println(Solution6().solution("()()"))
    println(Solution6().solution("(())()"))
    println(Solution6().solution(")()("))
    println(Solution6().solution("(()("))
    println(Solution6().solution("(()())"))
    println(Solution6().solution("((()()"))
}
