// 클래스의 메서드
//

class FootballPlayer constructor(uniform: String, ball: String) {

    val uniform: String
    val ball: String

    init {
        this.uniform = uniform
        this.ball = ball
    }

    fun kick() {
        println("공을 찼습니다!")
    }

    fun pass() {
        println("pass!")
    }
}

val footballPlayer = FootballPlayer("빨강", "축구공")
println(footballPlayer.uniform)
println(footballPlayer.pass())