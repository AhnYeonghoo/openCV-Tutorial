fun plusNumbers(firstNum: Int, secondNum: Int): Int {
    return firstNum + secondNum
}
plusNumbers(3, 5)

val result: Int = plusNumbers(5, 5)
result

fun plusNumbersWithDefault(firstNum: Int, secondNum: Int = 10): Int {
    return firstNum + secondNum
}
println(plusNumbersWithDefault(10))

fun plusNumberWithNoReturn(firstNum: Int, secondNum: Int): Unit {
    println(firstNum + secondNum)
}
fun plusNumberWithNoReturn2(firstNum: Int, secondNum: Int) {
    println(firstNum + secondNum)
    return
}
plusNumberWithNoReturn(20, 50)

// 함수 선언을 간단하게 람다식으로
fun shortPlusNumbers(firstNum: Int, secondNum: Int) = firstNum + secondNum
println(shortPlusNumbers(100, 20))

// 가변 인자를 갖는 함수
fun multiplePlusNumbers(vararg numbers: Int): Unit {
    for (number in numbers) {
        println(number)
    }
}

multiplePlusNumbers(1, 2, 3, 4, 5)