package 배열

class Solution5 {
    fun solution(dirs: String): Int {
        var startX = 0
        var startY = 0
        var endX = 0
        var endY = 0
        val route = mutableSetOf<List<Int>>()

        for (i in dirs.indices) {
            startX = endX
            startY = endY

            if (dirs[i] == 'U' && endY != 5) {
                endY++
            } else if (dirs[i] == 'D' && endY != -5) {
                endY--
            } else if (dirs[i] == 'L' && endX != -5) {
                endX--
            } else if (dirs[i] == 'R' && endX != 5) {
                endX++
            }

            route.add(listOf(startX, startY, endX, endY))
            route.add(listOf(endX, endY, startX, startY))
        }

        return route.filterNot { it[0] == it[2] && it[1] == it[3] }.size / 2
    }
}

fun main() {
    var dirs = "ULURRDLLU"
    println(Solution5().solution(dirs))

    dirs = "LULLLLLLU"
    println(Solution5().solution(dirs))
}

// 이차원 배열로 정의
// 시작과 끝, 즉 선분을 저장하면 중복되었는지를 체크할 수 있음 (0,0) -> (0,1)