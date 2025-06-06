package programmers.level_01

import java.util.*

fun main() {
    println(solution(intArrayOf(2, 1, 1, 2, 3, 1, 2, 3, 1)))
    println(solution(intArrayOf(1, 3, 2, 1, 2, 1, 3, 1, 2)))
}

//size = 6
// 2 last = 3
private fun solution(ingredient: IntArray): Int {
    var result = 0
    val data = Stack<Int>()
    for (item in ingredient) {
        if (item == 1 && data.size >= 3 && data.lastIndexOf(3) == data.size - 1
            && data.lastIndexOf(2) == data.size - 2 && data.lastIndexOf(1) == data.size - 3
        ) {
            result++
            data.pop()
            data.pop()
            data.pop()
        } else {
            data.push(item)
        }
    }
    return result

}