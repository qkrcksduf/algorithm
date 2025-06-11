package 코딩_테스트_합격자_되기.해시

class Solution12 {
    fun solution(participant: Array<String>, completion: Array<String>): String {
        // 참가자 수 카운트
        val participants = mutableMapOf<String, Int>()
        for (name in participant) {
            participants[name] = participants.getOrDefault(name, 0) + 1
        }

        // 완주자 수 빼기
        for (name in completion) {
            participants[name] = participants[name]!! - 1
        }

        // 완주 하지 못한 사람 반환 (1명)
        return participants.entries.first { it.value > 0 }.key
    }
}

fun main() {
    println(Solution12().solution(arrayOf("leo", "kiki", "eden", "kiki"), arrayOf("eden", "kiki", "leo")))
}