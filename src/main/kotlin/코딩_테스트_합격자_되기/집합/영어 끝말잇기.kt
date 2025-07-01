package 코딩_테스트_합격자_되기.집합

class `영어 끝말잇기` {
    /** 2개인 단어가 있을 경우
     * 2개인 단어가 있는지 찾기 -> set 활용
     * 2개인 단어가 있을 경우 몇번째 사람인지 찾기 -> n 활용
     * 몇번째로 탈락했는지 찾기 -> 두번째 단어의 인덱스 찾기
     */

    /** 2개인 단어가 없을 경우
     * 시작하는 단어를 잘못 말한 사람이 있는지 찾기
     * 찾은 후 인덱스 확인
     */

    fun solution(n: Int, words: List<String>): IntArray {
        val used = mutableSetOf<String>()
        used.add(words[0])

        var lastChar = words[0].last()
        for (i in 1 until words.size) {
            if (words[i] in used || words[i].first() != lastChar) {
                return intArrayOf((i % n) + 1, (i / n) + 1)
            }

            lastChar = words[i].last()
            used.add(words[i])
        }
        return intArrayOf(0, 0)
    }
}

fun main() {
    println(
        `영어 끝말잇기`().solution(
            3,
            listOf("tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank")
        ).contentToString()
    )

    println(
        `영어 끝말잇기`().solution(
            3,
            listOf(
                "hello",
                "observe",
                "effect",
                "take",
                "either",
                "recognize",
                "encourage",
                "ensure",
                "establish",
                "hang",
                "gather",
                "refer",
                "reference",
                "estimate",
                "executive"
            )
        ).contentToString()
    )

    println(
        `영어 끝말잇기`().solution(
            2,
            listOf(
                "hello", "one", "even", "never", "now", "world", "draw"
            )
        ).contentToString()
    )

}