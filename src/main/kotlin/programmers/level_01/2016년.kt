package programmers.level_01

import java.time.Month
import java.util.*

fun main() {
    println(solution(5, 24))
}

private fun solution(a: Int, b: Int): String {
    val date = Date(23, a, b)
    val calendar = Calendar.getInstance()
    println(calendar)
    println(calendar.get(Calendar.DAY_OF_WEEK))
    calendar.set(2016, a - 1, b)
    println(calendar)
    println(calendar.get(Calendar.DATE))
    println(calendar.get(Calendar.DAY_OF_WEEK))

    return when(calendar.get(Calendar.DAY_OF_WEEK)) {
        1 -> "SUN"
        2 -> "MON"
        3 -> "TUE"
        4 -> "WED"
        5 -> "THU"
        6 -> "FRI"
        7 -> "SAT"
        else -> {""}
    }
}