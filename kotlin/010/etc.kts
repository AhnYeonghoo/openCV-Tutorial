val numbers = intArrayOf(5, 10, 15)

for (number in numbers) {
    println(number)
}

for ((index, value) in numbers.withIndex()) {
    println("index: $index, value $value")
}

for (index in numbers.indices) {
    println(index)
}

numbers.forEachIndexed { index, i ->
    println("index: $index, value: $i")

}

numbers.forEachIndexed { index, value ->
    println("index: $index, value: $value")
}