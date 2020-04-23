package com.swpu.ylq.broadcastbestpractice

import kotlin.text.StringBuilder

fun StringBuilder.build(block :StringBuilder.() ->Unit):StringBuilder{
    block()
    return this
}

fun main(){
    val list = listOf<String>("Apple","Banana","Pear","Orange","Grape")
    val result=StringBuilder().build{
        append("Start eating fruits.\n")
        for(fruit in list){
            append(fruit).append("\n")
        }
        append("Ate all fruits.")
        }
    println(result.toString())
}