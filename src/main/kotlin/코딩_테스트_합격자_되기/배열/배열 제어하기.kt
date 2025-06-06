package 배열

fun main() {
    val input = arrayOf(4, 2, 2, 1, 3, 4)
    val result = solution2(input)
    println(result.joinToString(""))
}

fun solution2(intArray: Array<Int>): Array<Int> {
    return intArray.sortedArrayDescending().distinct().toTypedArray()
}