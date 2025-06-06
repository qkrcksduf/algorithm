package 배열

fun main() {
    val intArray = arrayOf(4, 2, 3, 1, 5)
    println(solution1(intArray).joinToString(""))

}

fun solution1(intArray: Array<Int>): Array<Int> {
    return intArray.sortedArray()
}