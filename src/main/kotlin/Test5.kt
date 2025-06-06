fun main() {
    var start = System.currentTimeMillis()
    var s: String = ""
    for (i in 1..100000) {
        s += i
    }
    var end = System.currentTimeMillis()

    println("${(end - start) / 1000.0} 초")

    start = System.currentTimeMillis()
    val n: StringBuffer = StringBuffer()

    for (i in 1..100000) {
        n.append(i)
    }

    end = System.currentTimeMillis()
    println("${(end - start) / 1000.0} 초")
}
