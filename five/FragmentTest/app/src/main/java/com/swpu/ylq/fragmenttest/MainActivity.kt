package com.swpu.ylq.fragmenttest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.left_fragment.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button.setOnClickListener{
            replaceFragment(AnotherRightFragment())
        }
        replaceFragment(RightFragment())
    }

    private fun replaceFragment(fragment: Fragment){
        //1.获取FragmentManager
        val fragmentManager = supportFragmentManager
        //2.开启事务，beginTransaction()
        val transaction = fragmentManager.beginTransaction()
        //3.添加或者替换Fragment，replace（）
       // transaction.replace(R.id.rightLayout,fragment)
        //实现返回栈
        transaction.addToBackStack(null)

        //4.提交事务，commit（）
        transaction.commit()

    }
}
