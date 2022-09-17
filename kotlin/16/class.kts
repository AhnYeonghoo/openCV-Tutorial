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
class User2(name: String, age: Int) {

}

// 클래스를 통해서 객체를 만드는 방법
// user는 User1 클래스의 instance이다.
// 객체 -> Object, Instance
val user = User1("Ahn", 23)
