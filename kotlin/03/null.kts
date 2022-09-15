val number: Int? = null
println(number)

val number2: Int? = 2 + 5
val number3: Int? = 10

//val number4: Int? = number2 + number3 // 사용 시점에서는 null이 아니란 보장이 없음.
// number2와 number3 모두 nullable type

val number4: Int? = number2!! + number3!! // -> !!하면 프로그램에게 null이 아니다라고 보장해주는 것.
// 만약 null이어도 error를 발생시켜줌. nullSafety!!

println(number4)
// val number2 : Int = null -> error!
// println(number2)


/**
 * !!로 null이 아님을 개발자가 보장할 수 있다.
 * - 하지만 실제로 null인 경우에는 NPE (Null Point Exception)이 발생할 수 있다.
 * - 결론 : 정말 100% 확신이 있는 경우가 아니면 사용하지 말자!
 */

println(null + 3)

if (null == 5) {
    println("same")
} else {
    println("not same")
}
if (null == null) {
    println("same")
} else {
    println("Not same")
}
