// 1. 주어진 문자를 N번 반복해서 출력하는 함수를 만들기
/**
 *  2. 1부터 주어진 숫자끼리의 합을 구한느 함수를 만들기
 *  3. 1부터 100까지의 수중에서 7의 배수의 합을 구하는 함수를 만들기
 */

fun cycleNPrint(n: Int, str: String): Unit {
    for (i in 1..n) {
        println(str)
    }
}

//cycleNPrint(5, "5번")
fun numNSum(num: Int): Int {
    var result: Int = 0
    for (i in 1..num) {
        result += i
    }
    return result
}

//println(numNSum(10))
fun oneToHun(): Int {
    var result: Int = 0
    for (i in 1..100) {
        if (i % 7 == 0) result += i
    }
    return result
}

//println(oneToHun())
fun returnHun(num: Int): Unit {
    if (num >= 100) return
    var result: Int = num
    while (result != 100) {
        result++
    }
}
returnHun(50)

//fun trueOrFalse(numbers: Array<Int>): String {
//    val result = arrayOf(false, false, false, false, false, false, false, false, false, false)
//    var i: Int = 0
//    for (number in numbers) {
//        if (number >= 80) result.set(i, true)
//        else result.set(i, false)
//        i++
//    }
//    return result.toString()
//}
//println(trueOrFalse(arrayOf(70, 80, 90, 70, 80, 90, 60, 70, 80, 90)))
fun eat(num1: Int, num2: Int): Unit {
    var number1 = num1
    var number2 = num2
    if (number2 >= number1) {
        println("배가 부르다")
        return
    }
    do {
        println("밥을 먹었다.")
        number1++
        if (number2 <= number1)  {
            println("배가 부르다.")
            break
        }
    } while (number2 > number1)
}

fun repeatText(repeatText: String, repeatNumber: Int): Unit {
    for (i in 1..repeatNumber) println(repeatText)
}
repeatText("repeatText", 3)