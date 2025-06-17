package 코딩_테스트_합격자_되기.트리

class Solution14 {
    fun solution(enroll: Array<String>, referral: Array<String>, seller: Array<String>, amount: IntArray): IntArray {
        val result = IntArray(enroll.size)
        val nameToIndex = enroll.withIndex().associate { it.value to it.index }
        for (i in seller.indices) {
            val sell = seller[i]
            val sellIndex = enroll.indexOf(sell)
            val price = amount[i] * 100
            addResult(sellIndex, referral, result, price, nameToIndex)
        }
        return result
    }

    fun addResult(index: Int, referral: Array<String>, result: IntArray, price: Int, nameToIndex: Map<String, Int>) {
        val commission = price / 10
        val selfTake = price - commission
        result[index] += selfTake

        if(commission == 0) return
        val parentName = referral[index]
        if (parentName == "-") return
        val parentIndex = nameToIndex[parentName]!!
        addResult(parentIndex, referral, result, commission, nameToIndex)
    }
}

fun main() {
    val enroll = arrayOf("john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young")
    val referral = arrayOf("-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward")
    val seller = arrayOf("young", "john", "tod", "emily", "mary")
    val amount = intArrayOf(12, 4, 2, 5, 10)
    val result = Solution14().solution(enroll, referral, seller, amount)
    println(result.contentToString())
}


//package 코딩_테스트_합격자_되기.트리

//class Solution {
//    fun solution(
//        enroll: Array<String>,
//        referral: Array<String>,
//        seller: Array<String>,
//        amount: IntArray
//    ): IntArray {
//        val n = enroll.size
//        val result = IntArray(n)
//
//        // 1) 이름→인덱스, 부모 인덱스 테이블 미리 만들기
//        val nameToIndex = enroll.withIndex().associate { it.value to it.index }
//        val parent = IntArray(n) { i ->
//            if (referral[i] == "-") -1
//            else nameToIndex[referral[i]]!!
//        }
//
//        // 2) 판매별로 이익 분배
//        for (i in seller.indices) {
//            var cur = nameToIndex[seller[i]]!!
//            var money = amount[i] * 100
//
//            while (cur != -1 && money > 0) {
//                val commission = money / 10
//                result[cur] += money - commission
//                cur = parent[cur]
//                money = commission
//            }
//        }
//
//        return result
//    }
//}
//
//// 테스트용 main
//fun main() {
//    val enroll   = arrayOf("john","mary","edward","sam","emily","jaimie","tod","young")
//    val referral = arrayOf("-","-","mary","edward","mary","mary","jaimie","edward")
//    val seller   = arrayOf("young","john","tod","emily","mary")
//    val amount   = intArrayOf(12, 4, 2, 5, 10)
//
//    val profits = Solution().solution(enroll, referral, seller, amount)
//    println(profits.contentToString())  // [360, 958, 108, 0, 450, 18, 180, 108]
//}

