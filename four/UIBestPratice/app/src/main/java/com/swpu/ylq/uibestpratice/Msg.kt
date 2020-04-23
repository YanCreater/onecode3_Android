package com.swpu.ylq.uibestpratice

class Msg(val content:String,val type:Int) {
    companion object{
        const val  TYPE_RECEIVD=0
        const val TYPE_SENT=1
    }
}