val numbers = listOf<Int>(1, 2, 3)

try {
    numbers.get(5)
} catch (exception: java.lang.Exception) {
    println(exception)
}

try {
    numbers.get(5)
} catch (e : java.lang.ArrayIndexOutOfBoundsException) {
    println(e)
} catch (e: java.lang.IllegalArgumentException) {
    println(e)
} finally {
    println("finally")
}