package com.swpu.ylq.activitytest

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.first_layout.*

class FirstActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.first_layout)
        button1.setOnClickListener {
            Toast.makeText(this,"You Clicked Button 1",Toast.LENGTH_SHORT).show()
                //隐式Intent启动activity
//            val intent = Intent("com.swpu.ylq.activitytest.ACTION_START")
//            intent.addCategory("com.swpu.ylq.activitytest.MY_CATEGORY")
//            val intent = Intent(Intent.ACTION_VIEW)//
//            intent.data= Uri.parse("https://www.baidu.com")
//            //Uri.parse 将网址字符串解析成一个Uri对象 调用setData()将这个对象传递进去，kotlin的语法糖
//            startActivity(intent)
            //调用系统拨号界面
//            val intent=Intent(Intent.ACTION_DIAL)
//            intent.data=Uri.parse("tel:10086")
////            startActivity(intent)
//            //向其他界面传递信息
//            val data ="Hello SecondActivity"
//            val intent=Intent(this,SecondActivity::class.java)
//            intent.putExtra("extra_data",data)
//            startActivity(intent)
            //返回数据给上一个Activity
            val intent=Intent(this,SecondActivity::class.java)
            startActivityForResult(intent,1)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.add_item ->Toast.makeText(this,"You Clicked Add",Toast.LENGTH_SHORT).show()
            R.id.remove_item ->Toast.makeText(this,"You Clicked Remove",Toast.LENGTH_SHORT).show()
        }
        return true
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when(requestCode){
            1 ->if(resultCode== Activity.RESULT_OK){
                val returnData=data?.getStringExtra("data_return")
                Toast.makeText(this,returnData,Toast.LENGTH_SHORT)
            }
        }
    }
}
