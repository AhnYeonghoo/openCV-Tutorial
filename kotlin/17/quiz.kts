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

fun trueOrFalse(numbers: List<Int>): Array<Boolean> {
    val result = arrayOf(false, false, false, false, false, false, false, false, false, false)
    var i: Int = 0
    for (number in numbers) {
        if (number >= 80) result.set(i, true)
        else result.set(i, false)
        i++
    }
    return result
}

val result2 = trueOrFalse(listOf<Int>(1, 2, 3, 4, 5, 90, 90, 90, 90, 90))
result2.forEach {
    println(it)
}

//fun eat(num1: Int, num2: Int): Unit {
//    var number1 = num1
//    var number2 = num2
//    if (number2 >= number1) {
//        println("배가 부르다")
//        return
//    }
//    do {
//        println("밥을 먹었다.")
//        number1++
//        if (number2 <= number1) {
//            println("배가 부르다.")
//            break
//        }
//    } while (number2 > number1)
//}

fun repeatText(repeatText: String, repeatNumber: Int): Unit {
    for (i in 1..repeatNumber) println(repeatText)
}
//repeatText("repeatText", 3)

fun sumUntil(givenNumber: Int): Int {
    var sum: Int = 0
    for (i in 1..givenNumber) sum += i
    return sum
}

//println(sumUntil(5))
fun sumSevenSum(): Int {
    var sum: Int = 0
    for (i in 1..100) {
        if (i % 7 == 0) sum += i
    }
    return sum
}
//println(sumSevenSum())

fun increaseOne(numberUnder: Int): Unit {
    var number = numberUnder
    while (number < 100) {
        number++
        println("Up")
    }
    return
}

//increaseOne(70)

fun checkPassOrNot(examScores: List<Int>): BooleanArray {
    val resultArray = BooleanArray(10, { false })
    examScores.forEachIndexed { index, score ->
        if (score >= 80) resultArray[index] = true
    }
    return resultArray
}

val result = checkPassOrNot(listOf<Int>(70, 71, 77, 77, 72, 89, 79, 99, 90, 99))
result.forEach {
    println(it)
}
println()
println()

fun findSumIsSixFromDice(): List<List<Int>> {
    val resultList = mutableListOf<List<Int>>()
    for (i in 1..6) {
        for (j in 1..6) {
            if (i + j == 6) resultList.add(listOf<Int>(i, j))
        }
    }
    return resultList
}
println(findSumIsSixFromDice())

fun eat2(eated: Int, eating: Int): Unit {
    var eated1: Int = eated
    var eating1: Int = eating
    if (eated == eating) {
        println("밥을 먹었다")
        println("배가 부르다")
        return
    }
    while (eated1 > eating1) {
        println("밥을 먹었다")
        eating1++
        if (eated1 <= eating1) println("배가 부르다")
    }
}
eat2(2, 2)

fun killNthArmy(
    firstArmy: List<String>,
    secondArmy: List<String>,
    killNth: Int
): List<List<String>>? {
    if (firstArmy.size < killNth || secondArmy.size < killNth) return null
    val firstArmyTemp = mutableListOf<String>()
    val secondArmyTemp = mutableListOf<String>()
    for ((index, value) in firstArmy.withIndex()) {
        if (index != killNth) firstArmyTemp.add(value)
    }
    for ((index, value) in secondArmy.withIndex()) {
        if (index != killNth) secondArmyTemp.add(value)
    }
    val result = listOf<List<String>>(firstArmyTemp, secondArmyTemp)
    return result
}

println(
    killNthArmy(
        firstArmy = listOf<String>("A", "B", "C", "D", "F"),
        secondArmy = listOf<String>("A", "B", "C"),
        killNth = 2
    )
)

fun dansu(number: Int): Unit {
    val numbers = mutableListOf<Int>()
    for (i in 1..9) {
        numbers.add(number * i)
    }
    println(numbers)
}
dansu(3)

fun splitNumbers(firstIntList: List<Int>, secondIntList: List<Int>): Map<String, List<Int>> {
    val result = mutableMapOf<String, List<Int>>()
    val totalIntList = mutableListOf<Int>()
    totalIntList.addAll(firstIntList)
    totalIntList.addAll(secondIntList)
    val evenNumber = mutableListOf<Int>()
    val oddNumber = mutableListOf<Int>()
    totalIntList.forEach { number ->
        if (number % 2 == 0) evenNumber.add(number)
        else oddNumber.add(number)
    }
    result.put("짝수", evenNumber)
    result.put("홀수", oddNumber)
    return result
}
println(
    splitNumbers(
        listOf<Int>(1, 2, 3, 4, 5),
        listOf<Int>(6, 7, 8, 9, 10)
    )
)