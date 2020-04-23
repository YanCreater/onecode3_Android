package com.swpu.ylq.broadcastbestpractice

//该函数有三个参数，最后一个参数是函数类型的
inline fun num1AndNum2(num1:Int,num2:Int,operation:(Int,Int)->Int):Int{
    val result=operation(num1,num2)
    return result
}

fun plus(num1: Int,num2: Int):Int{
    return num1+num2
}
fun minus(num1: Int,num2: Int)=num1-num2

//fun main() {
////    //在对高阶函数进行传参是使用符号“::”来引用函数
////    val result= num1AndNum2(5,8,::plus)
////    val result1= num1AndNum2(8,3,::minus)
////    println("${result}----${result1}")
//
////    val num1 = 100
////    val num2=80
////    val result= num1AndNum2(num1,num2){num1,num2 ->num1+num2}
////    val result1= num1AndNum2(num1,num2){num1,num2 ->num1-num2}
//    val list= listOf<String>("Apple","Banana","Orange","Pear","Grape")
//    val result = StringBuilder().build {
//    append("Start eating fruits.\n")
//    for(fruit in list){
//        append(fruit).append("\n")
//    }
//    append("Ate all fruits.")
//    }
//println(result.toString())
//}



