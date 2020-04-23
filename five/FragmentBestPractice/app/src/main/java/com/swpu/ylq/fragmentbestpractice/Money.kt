package com.swpu.ylq.fragmentbestpractice

class Money(val value:Int) {
    operator fun plus(money: Money):Money{
        val sum=value+money.value
        return Money(sum)
    }

    operator fun plus(newValue :Int):Money{
        val sum=value+newValue
        return Money(sum)
    }
}

fun main() {
    val money1=Money(100)
    val money2=Money(400)
    val money3 =money1+money2
    val money4=money3+500
    println("${money1.value} + ${money2.value} =${money3.value}-----${money4.value}")
}