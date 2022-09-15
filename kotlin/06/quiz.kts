// 1. 변수 A, B 선언하고, 두 변수 값이 같으면 true, 아니면 false가 되는 c 선언
val A: Int = 10
val B: Int = 20
val C: Boolean = if (A == B) true else false

// 2. 정수형 변수 A를 선언하고 변수 B를 선언하는데 B는 A의 두배
val A2: Int = 10
val B2: Int = A * 2

// 3. 학생의 시험 점수를 넣어주면 학점을 변환하는 함수를 만드시오
// (90 이상 a, 80~89 b, 70~79 c, 아님 f)
fun getGrade(num: Int): Char {
    if (num >= 90) return 'A'
    else if (num in 80..89) return 'B'
    else if (num in 70..79) return 'C'
    else return 'F'
}

println(getGrade(90))

// 4. 학생이 시험에서 맞은 문제의 갯수를 넣어주면 시험 정수를 반환하는 함수
// (시험 문제는 총 20, 만점 100)
fun getNumber(num: Int): Int {
    val result: Int = num * 5
    return result
}

println(getNumber(15))

// 5. nullable 정수형 두개를 받는 함수를 만든다. 이 함수는 받은 인수의 합을 반환
// 이때 인수중에 null이 있으면 0으로 취급하여 합을 구한다.

fun getInteger(num1: Int?, num2: Int?): Int {
//    if (num1 == null) {
//        num1 = 0
//    }
    var first: Int = if (num1 == null) 0 else num1
    var second: Int = if (num2 == null) 0 else num2
    return first + second

}
println(getInteger(null, 20))