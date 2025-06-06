package backjoon

import java.util.*

// 두개의 배열을 만들어서 없어지는 순서대로 새로운 배열에 값을 넣는다.
// 없어지는 순서는
// 처음 배열 size 되기전까지는 k의 배수 제거
// 사이즈 이후부터
fun main() {
    val scanner = Scanner(System.`in`)
    val n = scanner.nextInt()
    val k = scanner.nextInt()

    val newNumbers = mutableListOf<Int>()

    val markers = MutableList(n) { false }

    var count = 0
    var index = 0

    while (newNumbers.size != markers.size) {
        if (!markers[index]) {
            count++
        }

        if (count == k) {
            markers[index] = true
            newNumbers.add(index + 1)
            count = 0
        }

        if (index + 1 >= n) index = 0 else index++
    }

    println(newNumbers.joinToString(prefix = "<", separator = ", ", postfix = ">"))
}
