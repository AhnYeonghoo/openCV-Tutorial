fun addTwoNumbers(number1: Int, number2: Int): Int {
    return number1 + number2
}

// 고차함수
fun addTenNine(function: (Int, Int) -> Int) {
    val result : Int = function(10, 9)
    println("결과는 $result 입니다.")
}
addTenNine(::addTwoNumbers)