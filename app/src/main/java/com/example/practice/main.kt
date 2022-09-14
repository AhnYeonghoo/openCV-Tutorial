package com.example.practice

import java.lang.Integer.sum

// 주석입니다.
/* 주석이빈다. */

class Person(firstName: String, lastName: String) {
    init {
        println("${firstName} + ${lastName}")
    }
}
fun main() {
    println("hello World!!")
    println("Line2")
    println("Line3")
    println("Line4")

    val box1 = "Test Box1"
    val asdf = "Text Box2"
    println(box1)
    println(asdf)
    val number: Int? = null
    val sumNumberStr = number?.let {
       "${sum(10, it)}"
   }.orEmpty()
    println(sumNumberStr)

}
