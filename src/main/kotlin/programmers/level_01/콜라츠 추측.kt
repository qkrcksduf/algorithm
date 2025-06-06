package programmers.level_01

fun main() {
    println(solution(626331))
}

private fun solution(num: Int): Int {
    var count = 0
    var value: Long = num.toLong()
    while (value != 1L) {
        if (value % 2 == 0L) value /= 2
        else value = value * 3 + 1

        count++
        if (count == 500) return -1
    }
    return count
}