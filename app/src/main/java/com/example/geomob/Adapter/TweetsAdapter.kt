package com.example.geomob.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.geomob.DB_files.Entity.Tweet
import com.example.geomob.MainActivity
import com.example.geomob.R
import com.squareup.picasso.Picasso
import de.hdodenhof.circleimageview.CircleImageView
import www.sanju.tourism.Adapter.ViewHolder

class TweetAdapter(val list : ArrayList<Tweet>) : RecyclerView.Adapter<TweetAdapter.TweetViewHolder>(){
    class TweetViewHolder(v : View) : RecyclerView.ViewHolder(v){
        val userImage = v.findViewById<CircleImageView>(R.id.userImageView)
        val userName = v.findViewById<TextView>(R.id.userNameView)
        val screenName = v.findViewById<TextView>(R.id.screenNameView)
        val tweetCnt = v.findViewById<TextView>(R.id.tweetContentView)
        val tweetImg = v.findViewById<ImageView>(R.id.tweetImageView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TweetViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.activity_tweets, parent, false)
        return TweetViewHolder(v)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: TweetViewHolder, position: Int) {
        if (position < list.size){
            val tweet = list[position]

            holder.userName.text = tweet.userName
            holder.screenName.text = tweet.screenName
            holder.tweetCnt.text = tweet.contenu

            Picasso.get().load(tweet.userImg).into(holder.userImage)
            if (tweet.img == ""){
                holder.tweetImg.visibility = View.GONE
            }else{
                holder.tweetImg.visibility = View.VISIBLE
                Picasso.get().load(tweet.img).into(holder.tweetImg)
            }
        }
    }
}