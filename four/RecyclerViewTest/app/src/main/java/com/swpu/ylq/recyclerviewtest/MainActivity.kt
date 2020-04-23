package com.swpu.ylq.recyclerviewtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.StringBuilder

class MainActivity : AppCompatActivity() {

    private val fruitList=ArrayList<Fruit>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initFruits()
        //实现网格布局
//        val gridLayoutManager=GridLayoutManager(this,3)
//        recyclerView.layoutManager =gridLayoutManager
        //实现横向滚动
//        val layoutManager = LinearLayoutManager(this)
//        layoutManager.orientation=LinearLayoutManager.HORIZONTAL
//        recyclerView.layoutManager=layoutManager
        val layoutManage=StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)
        recyclerView.layoutManager=layoutManage
        val adapter=FruitAdapter(fruitList)
        recyclerView.adapter=adapter

    }
    private fun getRandomLength(str:String):String{
        val n=(1..20).random()
        val builder=StringBuilder()
        repeat(n){
            builder.append(str)
        }
        return builder.toString()
    }


    private fun initFruits(){
        repeat(2){
            fruitList.add(Fruit(getRandomLength("Apple"), R.drawable.apple_pic))
            fruitList.add(Fruit(getRandomLength("Banana"), R.drawable.banana_pic))
            fruitList.add(Fruit(getRandomLength("Orange"), R.drawable.orange_pic))
            fruitList.add(Fruit(getRandomLength("Watermelon"), R.drawable.watermelon_pic))
            fruitList.add(Fruit(getRandomLength("Pear"), R.drawable.pear_pic))
            fruitList.add(Fruit(getRandomLength("Grape"), R.drawable.grape_pic))
            fruitList.add(Fruit(getRandomLength("Pineapple"), R.drawable.pineapple_pic))
            fruitList.add(Fruit(getRandomLength("Strawberry"), R.drawable.strawberry_pic))
            fruitList.add(Fruit(getRandomLength("Cherry"), R.drawable.cherry_pic))
            fruitList.add(Fruit(getRandomLength("Mango"), R.drawable.mango_pic))
        }
    }
}
