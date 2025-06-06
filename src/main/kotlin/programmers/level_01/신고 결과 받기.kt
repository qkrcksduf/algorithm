package programmers.level_01

fun main() {
    solution(
        arrayOf("muzi", "frodo", "apeach", "neo"),
        arrayOf("muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"),
        2
    )
}

private fun solution(id_list: Array<String>, report: Array<String>, k: Int): IntArray {
    val idMap = id_list.associateWith { 0 }.toMutableMap()

    println(report.map { it.split(" ").let { (k, v) -> k to v } })
    val set = report.map { Pair(it.split(" ")[0], it.split(" ")[1]) }.toSet()
    set.map { idMap[it.second] = idMap[it.second]!!.plus(1) }
    val mailMap = id_list.associateWith { 0 }.toMutableMap()
    val keyList = idMap.filter { it.value >= k }.keys
    set.map {
        if (keyList.contains(it.second)) {
            mailMap[it.first] = mailMap[it.first]!! + 1
        }
    }

    return mailMap.values.toIntArray()
}