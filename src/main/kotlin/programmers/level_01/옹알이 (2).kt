package programmers.level_01

import kotlin.math.min

fun main() {
    println(solution(arrayOf("aya", "yee", "u", "maa")))
    println(solution(arrayOf("ayaye", "uuu", "yeye", "yemawoo", "ayaayaa", "yeoryeye")))
    println(solution(arrayOf("yeoryeye")))
    println(solution(arrayOf("ayadowasdwoowoomama")))
}

private fun solution(babbling: Array<String>): Int {
    var totalCount = 0
    babbling.forEach {
        if (it.contains("ayaaya") || it.contains("yeye") || it.contains("woowoo") || it.contains("mama")) return@forEach
        if (it.replace("aya", " ").replace("ye", " ").replace("woo", " ")
                .replace("ma", " ").replace(" ", "").trim().isEmpty()
        ) totalCount++
    }
    return totalCount
}

fun check(word: String): Boolean {
    val ableWord = listOf("aya", "ye", "woo", "ma")

    ableWord.forEach {
        if (word.contains(it)) {
            val startIndex = word.indexOf(it)
            for (i in startIndex until word.length - it.length) {
                val current = word.substring(i, i + it.length)
                val nextLastIndex = min(i + it.length + it.length, word.length)
                val next = word.substring(i + it.length, nextLastIndex)
                if (current == next && current == it) return true
            }
        }
    }
    return false
}