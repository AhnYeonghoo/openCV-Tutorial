// lazy

class Book3() {
    val title: String by lazy {
        // 본문 -> 반드시 초기화시키는 작업이 필요하다.
        println("레이지한 타이틀")
        "책 제목"
    }
}

val book3 = Book3()
val book4 = Book3()
val book5 = Book3()
val book6 = Book3()
val book7 = Book3()
val book8 = Book3()
val book9 = Book3()
// 이렇게 많은 인스턴스를 생성할 때마다 복잡한 초기화 작업을 거쳐야 한다면
// by lazy 키워드를 사용해 반드시 사용할 때만 프로퍼티가 초기화
// 되도록 한다.
println(book3.title)

