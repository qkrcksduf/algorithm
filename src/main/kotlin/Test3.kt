fun main() {
    // 비행기 좌석 문제 테스트 케이스 1
    val n1 = 2
    val s1 = "1A 2F 1C"
    println("Flight Seat Test Case 1: " + solution3(n1, s1)) // 예상 결과: 2

    // 비행기 좌석 문제 테스트 케이스 2
    val n2 = 1
    val s2 = ""
    println("Flight Seat Test Case 2: " + solution3(n2, s2)) // 예상 결과: 2

    // 비행기 좌석 문제 테스트 케이스 3
    val n3 = 22
    val s3 = "1A 3C 2B 20G 5A"
    println("Flight Seat Test Case 3: " + solution3(n3, s3)) // 예상 결과: 41
}

fun solution3(N: Int, S: String): Int {
    // 예약된 좌석을 관리할 Set
    val reservedSeats = S.split(" ").filter { it.isNotEmpty() }.toSet()

    var availableFamilies = 0

    // 각 열에 대해 가능한 가족 좌석 확인
    for (row in 1..N) {
        val isBReserved = reservedSeats.contains("${row}B")
        val isCReserved = reservedSeats.contains("${row}C")
        val isDReserved = reservedSeats.contains("${row}D")
        val isEReserved = reservedSeats.contains("${row}E")
        val isFReserved = reservedSeats.contains("${row}F")
        val isGReserved = reservedSeats.contains("${row}G")
        val isHReserved = reservedSeats.contains("${row}H")
        val isJReserved = reservedSeats.contains("${row}J")

        // 구간 확인
        val segment1 = !isBReserved && !isCReserved && !isDReserved && !isEReserved
        val segment2 = !isDReserved && !isEReserved && !isFReserved && !isGReserved
        val segment3 = !isFReserved && !isGReserved && !isHReserved && !isJReserved

        // 가능한 가족 좌석 그룹 계산
        if (segment1) {
            availableFamilies += 1
        }
        if (segment2) {
            availableFamilies += 1
        } else if (!segment1 && segment3) {
            availableFamilies += 1
        }
    }

    return availableFamilies
}


