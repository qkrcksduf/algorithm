fun main(args: Array<String>) {
    solution(54321)
    println()
    solution(10011)
    println()
    solution(1)
    println()
    solution(10000)
}
//10
fun solution(N_arg: Int) {
    var N: Int = N_arg
    var enable_print: Int

    // ex 54321 일때 12345 출력
    // ex 10011 일때 11001 출력
    // 현재 enable_print == 1 일때 역순으로 찍는 코드를 하고 있음으로 1이되도록 해주어야함.
    // 다만 10으로 나누어 떨어지는 수는 찍지 않음
    enable_print = if (N % 10 == 0) 0 else 1
    while (N > 0) {
        if (enable_print == 0 && N % 10 != 0) {
        }
        if (enable_print == 1) {
            print(N % 10)
        }
        N = N / 10
    }
}


//fun solution(N_arg: Int) {
//    var N: Int = N_arg
//    var enable_print: Int
//
//    enable_print = N % 10
//    while (N > 0) {
//        if (enable_print == 0 && N % 10 != 0) {
//            enable_print = 1
//        }
//        else if (enable_print == 1) {
//            print(N % 10)
//        }
//        N = N / 10
//    }
//}


// 맨 처음
//fun solution(N_arg: Int) {
//    var N: Int = N_arg
//    var enable_print: Int
//
//    enable_print = if (N % 10 == 0) 0 else 1
//
//    while (N > 0) {
//
//        if (enable_print == 0 && N % 10 != 0) {
//            enable_print = 1
//        }
//        else if (enable_print == 1) {
//            print(N % 10)
//        }
//        N /= 10
//    }
//}
