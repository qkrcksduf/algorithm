package programmers.level_01

fun main() {
    println(solution("12321", "42531"))
}

private fun solution(X: String, Y: String): String {
    val commonString = mutableListOf<Int>()
    var replaceY = Y

    for (i in X.indices) {
        if (replaceY.contains(X[i])) {
            replaceY = replaceY.replaceFirst(X[i].toString(), "")
            commonString.add(X[i].toString().toInt())
        }
    }

    var answer = ""
    if (commonString.isEmpty()) return "-1"
    commonString.sort()
    commonString.sortedDescending().forEach { answer += it }

    if (answer.replace("0", "").isEmpty()) return "0"
    return answer
}