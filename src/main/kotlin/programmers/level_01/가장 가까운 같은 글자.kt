package programmers.level_01

fun main() {
    solution("banana") //[-1, -1, -1, 2, 2, 2]
    solution("foobar") //[-1, -1, 1, -1, -1, -1]
}

private fun solution(s: String): IntArray {
    val mutableList = mutableListOf<Int>()
    for (i in s.indices) {
        var flag = true
        for (j in i - 1 downTo 0) {
            if (s[i] == s[j] && j != -1) {
                println(s[i])
                mutableList.add(i-j)
                flag = false
                break
            }
        }
        if (flag) {
            mutableList.add(-1)
        }
    }
    return mutableList.toIntArray()
}