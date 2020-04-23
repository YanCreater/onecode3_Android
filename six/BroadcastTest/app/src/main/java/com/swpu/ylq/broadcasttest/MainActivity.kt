package com.swpu.ylq.broadcasttest

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var timeChangeReceiver: TimeChangeReceiver
    //延迟初始化

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            //首先构造了一个Intent对象，将要发生的广播的值传入
            val intent = Intent("com.swpu.ylq.broadcasttest.MY_BROADCAST")
            intent.setPackage(packageName)//setPackage（）—传入当前应用程序的包名
            //sendBroadcast(intent)//发送广播，
            sendOrderedBroadcast(intent,null)
            // 监听com.example.broadcasttest.MY_BROADCAST这条广播的BroadcastReceiver就会收到消息
        }

        val intentFilter=IntentFilter()
        intentFilter.addAction("android.intent.action.TIME_TICK")
        timeChangeReceiver = TimeChangeReceiver()
        registerReceiver(timeChangeReceiver,intentFilter)//进行注册，传入接收器的实例，和IntentFilter的实例
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(timeChangeReceiver)
        //动态注册的BroadcastReceiver 必须取消注册
    }
    inner class TimeChangeReceiver :BroadcastReceiver(){
        override fun onReceive(context: Context?, intent: Intent?) {
            Toast.makeText(context,"Time is changed",Toast.LENGTH_LONG)
                    .show()
        }
    }
}
