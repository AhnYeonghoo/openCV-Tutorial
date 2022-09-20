fun addTwoNumbers(number1: Int, number2: Int): Int {
    return number1 + number2
}

// 고차함수
fun addTenNine(function: (Int, Int) -> Int) {
    val result : Int = function(10, 9)
    println("결과는 $result 입니다.")
}
addTenNine(::addTwoNumbers)

// 람다
// 풀버전
val addTenNine2: (Int, Int) -> Int = { number1: Int, number2: Int ->
     number1 + number2
}
addTenNine2(1, 2)

addTenNine(addTenNine2) // 람다함수를 인자를 사용하는 경우에는 ::를 사용할 필요가 없다.

// 생략 버전 1
val addTenNine3: (Int, Int) -> Int = { number1, number2 ->
    number1 + number2
}
addTenNine3(10, 10)

//생략 버전 2
val addTenNine4 = { number1: Int, number2: Int -> number1 + number2 }
addTenNine4(20, 20)

//너무 간단한 경우
addTenNine { number1, number2 -> number1 + number2 } // 고차함수한테 그냥 함수 내용 자체를 전달

// 파라미터가 없는 람다 함수
val addTenNine5: () -> Int = {
    10 + 9
}
addTenNine5()

// 파라미터가 하나인 람다 함수(it)
val addTenNine6: (Int) -> Int = {
    it + 9
}
addTenNine6(10)