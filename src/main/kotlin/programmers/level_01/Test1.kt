//import kotlinx.datetime.DatePeriod
//import kotlinx.datetime.LocalDate
//import kotlinx.datetime.plus
//import java.time.LocalDate
//
//fun main() {
//    val result = solution(
//        "2022.05.19",
//        arrayOf("A 6", "B 12", "C 3"),
//        arrayOf("2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C")
//    )
//    result.forEach { println(it) }
//}
//
//private fun solution(today: String, terms: Array<String>, privacies: Array<String>): IntArray {
//    val localDate = LocalDate(
//        today.split(".")[0].toInt(), today.split(".")[1].toInt(),
//        today.split(".")[2].toInt()
//    )
//
//    val termsPair = terms.associate { Pair(it.split(" ")[0], it.split(" ")[1]) }
//    val privaciesPair = privacies.map {
//        Pair(
//            LocalDate(
//                it.split(" ")[0].split(".")[0].toInt(),
//                it.split(" ")[0].split(".")[1].toInt(),
//                it.split(" ")[0].split(".")[2].toInt()
//            ),
//            it.split(" ")[1]
//        )
//    }
//
//    val mutableList = mutableListOf<Int>()
//    for (i in privaciesPair.indices) {
//        if (privaciesPair[i].first.plus(DatePeriod(months = termsPair[privaciesPair[i].second]!!.toInt())) <= localDate) mutableList.add(i + 1)
//    }
//
//    return mutableList.toIntArray()
//}
