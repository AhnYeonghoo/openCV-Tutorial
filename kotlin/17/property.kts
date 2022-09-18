// getter/setter

class Book() {
    var title: String = "모름"
        get() {
            println("Gettet Call")
            return field
        }
        set(value: String) {
            println("Setter Call")
            field = value
        }
    var subtitle: String = "부제목"
        get() {
            return field
        }
        set(value: String) {
            field = value
        }
}

val book = Book()
println(book.title)
book.title = "제목 변경"
println(book.title)
println(book.subtitle)
book.subtitle = "부제목 변경"
println(book.subtitle)