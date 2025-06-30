package 코딩_테스트_합격자_되기.집합

class `간단한 유니온-파인드 알고리즘 구현하기` {

    fun solution(nums: IntArray): Int {
        val hashSet = nums.toHashSet()

        val k = nums.size / 2
        val z = hashSet.size
        return if (k < z) k else z
    }
}

fun main() {
    val result = `간단한 유니온-파인드 알고리즘 구현하기`()
    val nums1 = intArrayOf(3,1,2,3)
    val nums2 = intArrayOf(3,3,3,2,2,4)
    val nums3 = intArrayOf(3,3,3,2,2,2)
    println(result.solution(nums1))
    println(result.solution(nums2))
    println(result.solution(nums3))
}