package com.swpu.ylq.broadcastbestpractice

inline fun printString(str:String ,block :(String) ->Unit){
    println("printString begin")
    block(str)
    println("printString end")
}
fun main() {
    println("main start")
    val str = ""
    println("printString begin")
    println("Lambda start")
    if(str.isEmpty()) return
    println(str)
    println("Lambda end")
    println("printString end")
    println("main end")
}
//fun main() {
//    println("main start")
//    val str = ""
//    printString(str){s->
//        println("Lambda start")
//        if(s.isEmpty()) return
//        println(s)
//        println("Lambda end")
//    }
//    println("main end")
//}
//

inline fun runRunnable(crossinline block: () -> Unit){
    val runnable = Runnable{
        block()
    }
    runnable.run()
}

