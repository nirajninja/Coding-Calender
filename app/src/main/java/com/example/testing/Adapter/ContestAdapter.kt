package com.example.testing.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.testing.Model.contestItem
import com.example.testing.R

/*



*/



class ContestAdapter (private val context: Context, private  var contestList: ArrayList<contestItem>):RecyclerView.Adapter<ContestAdapter.PostViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        return PostViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.each_row,parent,false))

    }

    override fun getItemCount(): Int =contestList.size

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {

        val contest=contestList[position]
        holder.name.text=contest.name
        holder.duration.text=contest.duration.toString()
        holder.stime.text=contest.start_time
        holder.etime.text=contest.end_time
        holder.site.text=contest.site
        holder.in24hrs.text=contest.in_24_hours
        holder.url.text=contest.url

    }
    class PostViewHolder(itemView: View):RecyclerView.ViewHolder(itemView)
    {/*
        val id=itemView.findViewById<TextView>(R.id.id)//----->1
        val title:TextView=itemView.findViewById(R.id.title)*/

        val name=itemView.findViewById<TextView>(R.id.name)
        val url=itemView.findViewById<TextView>(R.id.url)
        val stime=itemView.findViewById<TextView>(R.id.stime)
        val etime=itemView.findViewById<TextView>(R.id.eTime)

        val duration=itemView.findViewById<TextView>(R.id.duration)
        val site=itemView.findViewById<TextView>(R.id.site)
        val in24hrs=itemView.findViewById<TextView>(R.id.in_24_hrs)







    }

    fun setData( postList: ArrayList<contestItem>)
    {
        this.contestList = postList
        notifyDataSetChanged()
    }
}