package backjoon

import java.util.*

fun main() {
    // 1. 입력을 받기 위한 스캐너 객체 생성
    val scanner = Scanner(System.`in`)

    // 2. 입력으로 n을 받음
    val n = scanner.nextInt()

    // 3. 1부터 n까지의 합을 계산
    var sum = 0
    for (i in 1..n) {
        sum += i
    }

    // 4. 결과 출력
    println(sum)
}

