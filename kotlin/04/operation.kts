// 산술연산자
val number1: Int = 1 + 10
val number2: Int = 2 - 10
val number3: Int = 2 * 40
val number5: Int = 40 / 2
val number4: Int = 45 % 7
println(number1)
println(number2)
println(number3)
println(number4)
println(number5)

val number6 = 10 * 427 % 73 + 108 // 할당하려는 값의 타입을 알기 어려운 경우에는 코틀렌에게 맡겨도 된다.

// 대입연산자
var number7: Int = 22
number7 = 100

// 복합대입연산자
var number8: Int = 10
number8 += 8
number8 -= 10
number8 *= 2
number8 /= 5

// 증감연산자
var number9: Int = 1
number9++
++number9
--number9
number9--

// 비교연산자
val number10: Int = 1
val number11: Int = 2
val result: Boolean = number10 > number11
println(result)
val result2: Boolean = number10 === number11
println(result2)
val result3: Boolean = number10 !== number11
println(result3)
// ===, !== -> 잘 사용하지 않는다.

// 논리연산자
val boolean1: Boolean = true
val boolean2: Boolean = false
var result4: Boolean = boolean1 && boolean2
println(result4)
result4 = boolean1 || boolean2
println(result4)
result4 = !(boolean1 && boolean2)

println(result4)