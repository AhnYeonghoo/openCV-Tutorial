// 클래스를 선언하는 방법
class Person {}

// 생성자
// - 주 생성자
//      - constructor 키워드 사용
//      - 반드시 한 개만 존재할 수 있다.
//      - contructor 키워드는 생략이 가능하다.
// - 부 생성자

// 주 생성자 -> 풀버전
class User1 constructor(name: String, age: Int) {
    val userName: String // 클래스 속성 (property)은 init 블록에서 초기화
    val userAge: Int

    init {
        println(name)
        userName = name
        userAge = age
    }
}

//class User2(name: String, age: Int) {
//
//}

// 클래스를 통해서 객체를 만드는 방법
// user는 User1 클래스의 instance이다.
// 객체 -> Object, Instance
val user = User1("Ahn", 23)

// 주생성자 -> init을 생략하는 방법
class User3 constructor(name: String) {
    val userName: String = name
}

val user3 = User3("ghd")

// 주 생성자 -> constructor 생략하는 방법
class User4(name: String) {
    val userName: String = name
}

val user4 = User4("aa")

// 주 생성자 -> 기본값
class User5(name: String = "Ahn") {
    val userName: String = name
}


// 생성자에서 받는 속성이 복수개인 경우
class User6(age: Int, name: String) {
    val age: Int
    val name: String

    init {
        this.age = age
        this.name = name
    }
}


val user5 = User6(30, "홍길동")
println(user5.age)
println(user5.name)

// 주생성자 -> 생략할 수 있는 모든 것을 생략하는 방법
class User7(val name: String) {


}

val user7 = User7("name")
println(user7.name)

// 부 생성자 (Secondary Constructor)
// - constructor를 생략할 수 없다.
// 주 생성자는 필수조건, 부 생성자는 옵션
// 부생성자에는 주생성자에서 필요한 조건을 포함해야 한다.(주생성자의 파라미터)
// 부생성자는 주생성자에게 생성을 위임해야한다.
class User8 constructor(age: Int, name: String) {
    lateinit var color: String
    lateinit var nickName: String
    val age: Int
    val name: String

    init {
        println("Init")
        this.age = age
        this.name = name
    }

    // 부 생성자는 클래스명 우측에 올 수 없고 클래스의 본문에 존재
    // 부 생성자는 복수개 존재할 수 있다.
    constructor(age: Int, name: String, color: String): this(age, name) {
        println("Secondd")
        this.color = color
    }

    constructor(age: Int, name: String, nickName: String): this(age, name) {
        println("Three")
        this.nickName = nickName
    }

}
val user8 = User8(age=20, name="Name", color="black")
println(user8)

// 실행순서
// 부생성자 호출 -> 부생성자 안에 있는 주생성자 호출 -> init블록 호출 -> 부생성자 본문 호출
// 클래스 속성에서 초기화를 시켜주지 않아도 되는 이유
//  - 초기화블록에서 초기화를 보장해주기 때문
//  - 클래스가 생성될 때는 초기화 블록이 무조건 실행된다.
//  - 초기화 블록에 없는 속성은

class User9 {
    val age: Int
    val name: String

    constructor(age: Int, name: String) {
        this.age = age
        this.name = name
    }
}

val user9 = User9(30, "AHn")
println(user9.age)

// 주생성자가 없는 것 처럼 보이고 부생성자만 있을 때
// -> 부생성자가 맞다!
// -> 주생성자는 코틀린이 자동으로 만들어 준다.
// -> 하지만 이런식으로 만드는 경우는 거의 없음.
// -> 명시적으로 기재해주는 게 좋음.