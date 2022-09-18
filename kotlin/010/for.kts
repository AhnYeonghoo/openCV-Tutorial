for (value in 0..10) {
    println(value)
}

for (value in 0..5 step 2) {
    println(value)
}

for (value in 10 downTo 0 step 2) {
    print(value)
}

val number = listOf<Int>(5, 6, 7 ,8)
for (value in number) {
    println("value: $value")
}

for (i in 0..number.size) {
    println(i)
}

for (i in 0 until number.size) {
    println(i)
}
println()
println()
for ((index, value) in number.withIndex()) {
    println("index: ${index}, value: ${value}")
}
println()
println()

number.forEach {
    println(it)
}
println()
println()

number.forEach { number ->
    println(number)
}

