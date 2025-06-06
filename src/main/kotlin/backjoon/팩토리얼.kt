package backjoon

import java.util.*

fun main() {
    val n = Scanner(System.`in`).nextInt()
    var sum = 1

    for (i in n downTo 1) {
        sum *= i
    }
    println(sum)
}