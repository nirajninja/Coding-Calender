package com.example.testing.Adapter

import android.app.Application
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.Color.green
import android.net.Uri
import android.text.Layout
import android.text.style.BackgroundColorSpan
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.testing.Model.contestItem
import com.example.testing.R


class ContestAdapter(
    private val context: Context, private var contestList: ArrayList<contestItem>
   // private val listener: OnItemClickListener

) : RecyclerView.Adapter<ContestAdapter.PostViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        return PostViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.each_row, parent, false)
        )

    }

    override fun getItemCount(): Int = contestList.size

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {

        val contest = contestList[position]
        holder.name.text = contest.name
        holder.duration.text = contest.duration.toString()
        holder.stime.text = contest.start_time
        holder.etime.text = contest.end_time
        holder.site.text = contest.site
        holder.in24hrs.text = contest.in_24_hours
        holder.url.text = contest.url

        holder.url.setOnClickListener {

         /*   val url=holder.url.text
            Log.d("TAG","$url")
         */
            val url = holder.url.text.toString()
            val intent=Intent(Intent.ACTION_VIEW, Uri.parse(url))
            context.startActivity(intent)


        }
        if(holder.site.text=="HackerEarth")
        {
            holder.linearlayout.setBackgroundResource(R.drawable.hacerearth)
            Log.d("TAG","codechef h ye toh")

        }
        else{
            holder.linearlayout.setBackgroundResource(R.drawable.bg3)
        }



        /*Log.d("TAG",holder.name.text.toString())
        if(holder.site.text=="CodeChef")
        {
            holder.cardView.setCardBackgroundColor(Color.BLUE)
            //  holder.cardView.setBackgroundColor(Color.GREEN)
            Log.d("TAG","codechef h ye toh")



        }
        else if(holder.site.text=="HackerEarth")
        {
            holder.cardView.setCardBackgroundColor(Color.GREEN)
            //  holder.cardView.setBackgroundColor(Color.GREEN)
            Log.d("TAG","codechef h ye toh")

        }
        if(holder.site.text=="TopCoder")
        {
            holder.cardView.setBackgroundResource(R.drawable.bg2)

            //  holder.cardView.setBackgroundColor(Color.GREEN)
            Log.d("TAG","codechef h ye toh")

        }*/




    }
//inner
     class PostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
         {
       // View.OnClickListener
         val cardView=itemView.findViewById<CardView>(R.id.cardView)

             val linearlayout=itemView.findViewById<LinearLayout>(R.id.linearlv)

        val name = itemView.findViewById<TextView>(R.id.name)
        val url = itemView.findViewById<TextView>(R.id.url)
        val stime = itemView.findViewById<TextView>(R.id.stime)
        val etime = itemView.findViewById<TextView>(R.id.eTime)

        val duration = itemView.findViewById<TextView>(R.id.duration)
        val site = itemView.findViewById<TextView>(R.id.site)
        val in24hrs = itemView.findViewById<TextView>(R.id.in_24_hrs)





        /*init {
            itemView.setOnClickListener(this)
        }
*/
       /* override fun onClick(v: View?) {
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                listener.onItemClick(position)
            }
        }*/


    }
/*
    interface OnItemClickListener {
        fun onItemClick(position: Int)

    }*/

    fun setData(postList: ArrayList<contestItem>) {
        this.contestList = postList
        notifyDataSetChanged()
    }
}