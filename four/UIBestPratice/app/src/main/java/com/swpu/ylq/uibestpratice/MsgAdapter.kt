package com.swpu.ylq.uibestpratice

import android.view.LayoutInflater

import android.view.ViewGroup

import androidx.recyclerview.widget.RecyclerView

class MsgAdapter(val msgList: List<Msg>):RecyclerView.Adapter<MsgViewHolder>() {
//    inner class LeftViewHolder(view: View):RecyclerView.ViewHolder(view){
//        val leftMsg:TextView=view.findViewById(R.id.leftMsg)
//    }
//    inner class RightViewHolder(view: View):RecyclerView.ViewHolder(view){
//        val rightMsg:TextView =view.findViewById(R.id.rightMsg)
//    }


    override fun getItemCount()=msgList.size
    override fun getItemViewType(position: Int): Int {
        val msg = msgList[position]
        return msg.type
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)=if(viewType==Msg.TYPE_RECEIVD) {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.msg_left_item,parent,false)
        MsgViewHolder.LeftViewHolder(view)
    }else{
        val view=LayoutInflater.from(parent.context).inflate(R.layout.msg_right_item,parent,false)
        MsgViewHolder.RightViewHolder(view)
    }

    override fun onBindViewHolder(holder: MsgViewHolder, position: Int) {
        val msg=msgList[position]
        when(holder){
            is MsgViewHolder.LeftViewHolder -> holder.leftMsg.text=msg.content
            is MsgViewHolder.RightViewHolder ->holder.rightMsg.text=msg.content
        }
    }
}