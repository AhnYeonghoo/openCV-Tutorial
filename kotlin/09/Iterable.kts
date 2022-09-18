//// Range
//val range1 = 1..10
//val range2 = 1 until 10
//println(range1)
//println(range2)
//val range3 = 'A'..'Z'
//range3.forEach {
//    println(it)
//}
//val range4 = 'ㄱ'..'ㅎ'
//range4.forEach {
//    println(it)
//}

// Progression
val range5 = 1..10 step 2
range5.forEach {
    println(it)
}

val range6 = 10 downTo 1 step 2
range6.forEach {
    println(it)
}
println()

// STEP
// - 특징 : step에 값과 상관없이 첫번째는 무조건 index 0부터 시작한다.

// Collections

val collection1 = listOf<Int>(1, 2, 3, 4, 5)
println(collection1)
