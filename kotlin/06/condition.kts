// if
val number1: Int = 10

if (number1) {
    println("True")
}

if (number1 == 10) {
    println("10")
} else if (number1 == 20) {
    println("20")
} else {
    println("not 10 20")
}
if (number1 == 10) println("10")
else if (number1 == 20) println("20")
else if (number1 == 20) println("20")
else if (number1 == 20) println("20")
else if (number1 == 20) println("20")
else if (number1 == 20) println("20")
else println("not 10 20")

val number2: Int = 10 + 20
val number3: Int = if (number2 > 30) 40 else 50
println(number3)

// 표현과 식
// 표현 val, var, Int, Short
// 식은 값을 만들어내는 것.

val number4: Int = 5

when (number4) {
    1 -> println("1")
    2 -> println("2")
    3 -> println("3")
    4 -> println("4")
    else println("5")
}
when (number4) {
    in 1..10 -> println("1..10")
    in 20..30 -> println("20..30")
    in 40..60 -> println("40..60")
}