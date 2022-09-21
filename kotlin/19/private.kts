// Scope

var number: Int = 1 // ->  Scope는 파일 전체
fun changeNumber() {
    var internalNumber: Int = 2
    number = 10 // 하위 스코프에서 상위 스코프로 접근 가능
    var number: String = " 재정의 number"
    println(number)
}
// internalNumber = 30 -> 상위 스코프에서 하위 스코프 접근 불가능
changeNumber()
println(number)
println(number)


// 접근제한자
class Numbers(private var number: Int = 10) {
    fun changeNumber(){
        this.number = 100 // private은 클래스 내에서만 조정 가능
    }
    fun whatIsNumber(): Int {
        return this.number // getter로 private 변수를 안전하게 가져옴
    }
}

val numbers = Numbers()

numbers.changeNumber()
println(numbers.whatIsNumber())
// println(numbers.number)  -> private 변수이기 때문에 직접 건들지 못함.


// public -> 내가 포함되어 있는 범위 밖에서도 접근/변경 가능
// private -> 내가 포함되어 있는 범위 밖에서는 접근/변경 불가능
//          -> 내가 포함되어 있는 범위 안에서는 접근/변경 가능(클래스 내, 함수 내)