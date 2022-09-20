

class Book2() {
    lateinit var title: String

    fun nextPage() {
        if (::title.isInitialized == true) {
            println("초기화 논 필요")
        } else {
            println("초기화  필요.")
        }
        println("dd")
    }
}
val book = Book2()
book.title = "책이름"
book.nextPage()

