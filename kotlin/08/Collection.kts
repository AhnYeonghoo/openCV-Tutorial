var numbers = listOf<Int>(1, 2, 3)
println(numbers)
numbers.forEach {
    println(it)
}
println(numbers.get(0))
println(numbers[0])
println(numbers.indexOf(1))
println(numbers.size)
println(numbers.last())
println(numbers.firstOrNull())
println()
println()

val numbers2 = mutableListOf<Int>(1, 2, 3)
println(numbers2)
numbers2[0] = 3
println(numbers2)
println(numbers2.set(0, 1))
numbers2.add(50)
numbers2.removeAt(0)
numbers2.remove(2)
numbers2.addAll(2, listOf<Int>(100, 100))
numbers2.addAll(0, numbers)

println(numbers2)
println()
println()


val numbers3 = setOf<Int>(1, 2, 2, 1, 3, 5, 5) // -> 중복 허용 X
println("-----------numbers3 -----------")
println(numbers3)
println(numbers3.contains(1))
println(numbers3.contains(10))
println(numbers3.containsAll(setOf<Int>(1, 3)))

println("---------numbers3 And------------")
println()
println()
val numbers4 = mutableSetOf<Int>(1, 2, 3, 3, 2, 1)

println(numbers4)

println()
println()

val numbers5 = mapOf<Int, String>(1 to "One", 2 to "Two")
println(numbers5)
val numbers6 = mapOf<Int, String>(Pair(1, "One"), Pair(2, "Two"))
println(numbers6)

