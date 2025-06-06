package backjoon

import java.util.Scanner

fun main() {
    val input = Scanner(System.`in`).next()
    if (input == input.reversed()) println(1)
    else println(0)
}