var array1 = arrayOf(true, "Hi", 10, 2.2, null)
var array2 = arrayOf<Int>(1, 2, 3, 4, 5)
var array3 = arrayOf<Double>(1.0, 2.0, 3.0, 4.0, 5.0)
var array4 = intArrayOf(1, 2, 3, 4, 5)

var array5 = Array(10, { 0 })
println(array5.get(0))
println(array5.get(1))
println(array5.get(2))
println(array5.get(3))
println(array5.get(4))

var array6 = IntArray(10, { 0 })
var array7 = DoubleArray(10, { 0.0 })

var array8 = Array<Int>(10, { 0 })
var array9 = Array<String>(10, { "" })

var array10 = arrayOf<Int>(10, 20, 30, 40)
println(array10[2])
println(array10.get(2))
array8.set(0, 100)
println(array8.get(0))

val examScore1: Int = 100
val examScore2: Int = 90
val examScore3: Int = 80
var examScores = arrayOf<Int>(examScore1, examScore2, examScore3)

val examScore4 = examScores.get(0)
println(examScore4)

/**
 * [if the] index
 * create by AhnYeonghoo
 */
