package com.swpu.ylq.helloworld

open class Person(var name:String,var age:Int) {
    fun eat(){
        println(this.name+ " is eating. He is "+this.age + " years old.")
    }
}
fun main(){
    val p =Person("Tom",  18)
    p.eat()
}
