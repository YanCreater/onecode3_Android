package com.swpu.ylq.helloworld

data class Cellphone(val brand:String ,val price:Double)

fun main() {
    val cellphone1=Cellphone("Samsung",1299.9)
    val cellphone2=Cellphone("Samsung",1299.9)
    val brand="Samsung"
    val price=1299.9
    println("cellphone(brand=$brand,price=$price)")
    println("cellphone1 equals cellphone2 "+(cellphone1 ==cellphone2))
}