package backjoon
import java.util.*

data class DragonCurve(val x: Int, val y: Int, val d: Int, val g: Int)

fun main() {
    val scanner = Scanner(System.`in`)
    val n = scanner.nextInt()
    val dragonCurves = mutableListOf<DragonCurve>()

    repeat(n) {
        val x = scanner.nextInt()
        val y = scanner.nextInt()
        val d = scanner.nextInt()
        val g = scanner.nextInt()
        dragonCurves.add(DragonCurve(x, y, d, g))
    }

    val grid = Array(101) { BooleanArray(101) }
    val directions = arrayOf(Pair(1, 0), Pair(0, -1), Pair(-1, 0), Pair(0, 1))

    for (curve in dragonCurves) {
        val points = mutableListOf<Pair<Int, Int>>()
        points.add(Pair(curve.x, curve.y))
        var nx = curve.x + directions[curve.d].first
        var ny = curve.y + directions[curve.d].second
        points.add(Pair(nx, ny))

        for (generation in 1..curve.g) {
            val size = points.size
            for (i in size - 2 downTo 0) {
                val (dx, dy) = points[i]
                val directionIndex = (directions.indexOf(Pair(dx - points.last().first, dy - points.last().second)) + 1) % 4
                val newX = points.last().first + directions[directionIndex].first
                val newY = points.last().second + directions[directionIndex].second
                points.add(Pair(newX, newY))
            }
        }

        println(points)

        points.forEach { (x, y) ->
            if (x in 0..100 && y in 0..100) {
                grid[x][y] = true
            }
        }
    }

    var count = 0
    for (i in 0..99) {
        for (j in 0..99) {
            if (grid[i][j] && grid[i + 1][j] && grid[i][j + 1] && grid[i + 1][j + 1]) {
                count++
            }
        }
    }

    println(count)
}

//[(3, 3), (4, 3), (4, 4)]
//[(4, 2), (4, 1), (5, 1), (5, 2), (5, 3), (4, 3), (5, 3), (6, 3), (7, 3)]
//[(4, 2), (3, 2), (3, 1)]