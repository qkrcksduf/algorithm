package programmers.level_01

fun main() {
    println(solution("banana"))
    println(solution("abracadabra"))
    println(solution("aaabbaccccabba"))
}


private fun solution(s: String): Int {
    var first = s[0]
    var firstCount = 0
    var notFirstCount = 0
    var totalCount = 0
    for (i in s.indices) {
        if (first == s[i]) {
            firstCount++
        } else notFirstCount++

        if (firstCount == notFirstCount) {
            if (i != s.lastIndex) {
                first = s[i + 1]
            }
            totalCount++
        }

        if (i == s.lastIndex && firstCount != notFirstCount) totalCount++
    }
    return totalCount
}
