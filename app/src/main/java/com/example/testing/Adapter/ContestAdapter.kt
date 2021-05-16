package com.example.testing.Adapter

import android.app.Application
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.Color.green
import android.graphics.drawable.Drawable
import android.net.Uri
import android.text.Layout
import android.text.style.BackgroundColorSpan
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat.getDrawable
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.testing.Model.contestItem
import com.example.testing.R
import kotlinx.android.synthetic.main.testing.view.*


class ContestAdapter(
    private val context: Context, private var contestList: ArrayList<contestItem>

) : RecyclerView.Adapter<ContestAdapter.PostViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        return PostViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.testing, parent, false)
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
        Log.d("TAG",contest.in_24_hours)

       holder.in24hrs.text=contest.in_24_hours

        holder.url.text = contest.url
        holder.status.text=contest.status

        holder.link.setOnClickListener {

            val url = holder.url.text.toString()
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            context.startActivity(intent)
        }
        when (holder.site.text) {
            "HackerEarth" -> {
                holder.logo.setImageDrawable(getDrawable(context,R.drawable.hearth))
                holder.linearlayout.setBackgroundResource(R.drawable.bg2)
            }
            "CodeForces"->{

                holder.logo.setImageDrawable(getDrawable(context,R.drawable.codeforces))

                holder.linearlayout.setBackgroundResource(R.drawable.bg1)
            }

            "CodeChef" -> {
                holder.logo.setImageDrawable(getDrawable(context,R.drawable.cclog))

                holder.linearlayout.setBackgroundResource(R.drawable.bg4)
            }
            "CS Academy"->{
                holder.logo.setImageDrawable(getDrawable(context,R.drawable.cs))

                holder.linearlayout.setBackgroundResource(R.drawable.bg1)
            }
            "HackerRank" -> {
                holder.logo.setImageDrawable(getDrawable(context,R.drawable.hrank))

                holder.linearlayout.setBackgroundResource(R.drawable.bg3)
            }

            "LeetCode"->{
                holder.logo.setImageDrawable(getDrawable(context,R.drawable.leetcode))
                holder.linearlayout.setBackgroundResource(R.drawable.bg4)
            }

            "Kick Start"->{
                holder.logo.setImageDrawable(getDrawable(context,R.drawable.google))
                holder.linearlayout.setBackgroundResource(R.drawable.bg1)
            }
            else ->
                holder.linearlayout.setBackgroundResource(R.drawable.bg3)
        }
    }

    class PostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        /*val cardView = itemView.findViewById<CardView>(R.id.cardView)

        val linearlayout = itemView.findViewById<LinearLayout>(R.id.linearlv)

        val name = itemView.findViewById<TextView>(R.id.name)
        val url = itemView.findViewById<TextView>(R.id.url)
        val stime = itemView.findViewById<TextView>(R.id.stime)
        val etime = itemView.findViewById<TextView>(R.id.eTime)

        val duration = itemView.findViewById<TextView>(R.id.duration)
        val site = itemView.findViewById<TextView>(R.id.site)
        val in24hrs = itemView.findViewById<TextView>(R.id.in_24_hrs)
*/
        val linearlayout=itemView.findViewById<ConstraintLayout>(R.id.linearlv)
        val cardView=itemView.findViewById<CardView>(R.id.cardView)
        val name = itemView.findViewById<TextView>(R.id.name)
        val url = itemView.findViewById<TextView>(R.id.url)
        val stime = itemView.findViewById<TextView>(R.id.stime)
        val etime = itemView.findViewById<TextView>(R.id.etime)

        val duration = itemView.findViewById<TextView>(R.id.duration)
        val site = itemView.findViewById<TextView>(R.id.site)
        val in24hrs = itemView.findViewById<TextView>(R.id.in24)
        val link=itemView.findViewById<ImageView>(R.id.urllink)
        val logo=itemView.findViewById<ImageView>(R.id.logo)
        val status=itemView.findViewById<TextView>(R.id.status)
    }

    fun setData(postList: ArrayList<contestItem>) {
        this.contestList = postList
        notifyDataSetChanged()
    }
}