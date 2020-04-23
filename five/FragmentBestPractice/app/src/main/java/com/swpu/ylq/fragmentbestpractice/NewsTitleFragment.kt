package com.swpu.ylq.fragmentbestpractice

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.news_title_frag.*
import java.lang.StringBuilder

class NewsTitleFragment :Fragment() {

    private var isTwoPane = false  //用于判断是否是双页模式，默认选择不是

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.news_title_frag,container,false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        isTwoPane=activity?.findViewById<View>(R.id.newsContentLayout)!=null
        //id为newsContentLayout的View只能在双页模式中才能出现

        //向RecyclerView中填充数据
        val layoutManager = LinearLayoutManager(activity)
        newsTitleRecyclerView.layoutManager=layoutManager
        val adapter = NewsAdapter(getNews())
        newsTitleRecyclerView.adapter=adapter
    }

    private fun getNews():List<News>{
        val newsList= ArrayList<News>()
        for (i in 1..50){
            val news = News("this is news title $i",getRandomLengthString("This is news content $i ."))
            newsList.add(news)
        }
        return newsList
    }

    operator fun String.times(n:Int)=repeat(n)

    private fun getRandomLengthString(str :String)=str*(1..20).random()

    inner class NewsAdapter(val newsList:List<News>):RecyclerView.Adapter<NewsAdapter.ViewHolder>() {
        inner class ViewHolder(view: View):RecyclerView.ViewHolder(view){
            val newsTitle:TextView = view.findViewById(R.id.newsTitle)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.news_item,parent,false)
            val holder = ViewHolder(view)
            holder.itemView.setOnClickListener{
                val news = newsList[holder.adapterPosition]
                if(isTwoPane){
                    val fragment=newsContentFrag as NewsContentFragment
                    fragment.refresh(news.title,news.content)
                }else{
                    NewsContentActivity.actionStart(parent.context,news.title,news.content)
                }
            }
            return holder
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val news = newsList[position]
            holder.newsTitle.text = news.title
        }

        override fun getItemCount()=newsList.size
    }
}