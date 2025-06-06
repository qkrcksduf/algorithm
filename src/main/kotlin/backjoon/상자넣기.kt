package backjoon

import java.util.*

// 최장 증가 수열 (LIS 문제)
// 다음 순서로 가서 값을 넣을때 그 값이 더 작으면 그 값으로 대체 아니면 그 뒤에 나열
// 첫번째거는 바로 넣어.
// 두번째거 부터는 이전 값과 비교를 하면서 넣어.
// 넣을때의 위치도 고려해야돼
fun main() {
    val scanner = Scanner(System.`in`)
    val n = scanner.nextInt()
    val boxSizeArray = mutableListOf<Int>()
    for (i in 1..n) {
        val boxSize = scanner.nextInt()
        boxSizeArray.add(boxSize)
    }

    val newBoxArray = mutableListOf<Int>()
    newBoxArray.add(boxSizeArray[0])

    for (i in 1 until boxSizeArray.size) {
        if (newBoxArray.last() < boxSizeArray[i]) {
            newBoxArray.add(boxSizeArray[i])
        } else {
            val pos = binarySearch(newBoxArray, boxSizeArray[i])
            newBoxArray[pos] = boxSizeArray[i]
        }
    }

    println(newBoxArray)
    println(newBoxArray.size)
}

fun binarySearch(array: MutableList<Int>, key: Int): Int {
    var low = 0
    var high = array.size

    while (low < high) {
        val mid = (low + high) / 2
        if (array[mid] < key) {
            low = mid + 1
        } else {
            high = mid
        }
    }

    return low
}

//1 6 2 5 7 3 5 6 7
// 가장 많이 넣을 수 있는 경우를 찾아야함