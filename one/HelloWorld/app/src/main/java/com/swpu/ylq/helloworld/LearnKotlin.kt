package com.swpu.ylq.helloworld

import kotlin.math.max

fun main(){
    for( i in 10 downTo 1 step 2){
        println(i)
    }
}

fun largeNumber(num1:Int ,num2:Int )=if(num1>num2)num1 else num2

fun getScore(name:String)= when(name){
    "Tom" -> 86
    "Jim"  -> 77
    "Jack" -> 95
    "Lily" -> 100
    else -> 0
}

fun checkNumber(num:Number)=
    when(num){
        is Int -> println("number is Int")
        is Double -> println("number is Double")
        else -> println("number not support")
    }