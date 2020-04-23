package com.swpu.ylq.fragmentbestpractice

/**
 * 将letterCount（）方法定义成String类的拓展函数
 * 函数会自动拥有String 实例的上下文
 */
fun String.letterCount():Int{
    var count = 0
    for(char in this){
        if(char.isLetter()){
            count++
        }
    }
    return count
}
fun main() {
    val count="Adsasvcw25156a1d3w".letterCount()
    println(count)
}