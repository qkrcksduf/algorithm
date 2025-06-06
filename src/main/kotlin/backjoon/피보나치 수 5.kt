package backjoon

import java.util.Scanner

fun main() {
    val n = Scanner(System.`in`).nextInt()
    println(fibonachi5(n))
}

fun fibonachi5(n: Int): Int {
    if (n == 0 || n == 1) return n

    var prev = 0
    var current = 1

    for (i in 2..n) {
        val next = prev + current
        prev = current
        current = next
    }
    return current
}