package com.swpu.ylq.helloworld

class Student (val sno:String ,val grade:Int,name :String ,age :Int): Person(name,age),Study{

    constructor(name :String ,age:Int):this("",0,name, age){
    }
    constructor():this("",0)

    override fun doHomeWork() {
        println(name +" is reading")
    }

    override fun readBooks() {
        println(name + " is doing homework")
    }



}

fun main() {
    val stu=Student()
    val stu1=Student("Yom",19)
    val stu2=Student("111111",99,"Tom",19)
    stu1.doHomeWork()
    stu2.readBooks()

    doStudy(stu1)
}

fun doStudy(study: Study?){
    study?.let {
        it.readBooks()
        it.doHomeWork()
    }
}