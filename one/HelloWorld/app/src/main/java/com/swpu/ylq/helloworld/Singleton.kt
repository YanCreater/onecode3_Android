package com.swpu.ylq.helloworld

object Singleton {
    fun singletonTest(){
        println("singletonTest is called")
    }
}

fun main() {
    val list = mutableListOf<String>("Apple","Banana","Orange","Pear","Grape")
    list.add("Watermelon")
    Thread(object :Runnable{
        override fun run() {
            println("Thread is running")
        }
    }).start()
    Thread(Runnable {
        println("Thread1 is running")
    }).start()

    Thread{
        println("Thread2 is running")
    }.start()
//    //测试函数any和all
//    val anyResult=list.any{it.length<=5}
//    val allResult=list.all { it.length<=5 }
//    println("anyResult is "+anyResult+",allResult is "+allResult)
//
//    list.removeAt(1)
//    val maxLengthFruit =list.maxBy{it.length}
//    println(maxLengthFruit)
    //测试map函数
//    val newList = list.map { it.toUpperCase() }
//    for(fruit in newList){
//        println(fruit)
//    }
    //  测试filter函数
//    val newList1=list.filter { it.length<=5 }
//        .map { it.toUpperCase() }
//    for (fruit in newList1){
//        println(fruit)
//    }
//
//    val set= mutableSetOf<String>("Apple","Banana","Orange","Pear","Grape")
//    set.add("Watermelon")
//    for(fruit in set){
//        println(fruit)
//    }

//    val map= mapOf<String,Int>("Apple" to 1,"Banana" to 2,"Orange" to 3,"Pear" to 4,"Grape" to 5)
//    for((fruit,number)in map){
//        println(fruit+" --"+number)
//    }
}