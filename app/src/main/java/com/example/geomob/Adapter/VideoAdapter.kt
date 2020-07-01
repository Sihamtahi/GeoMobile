package com.example.geomob.Adapter

import android.content.Context
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.example.geomob.DB_files.Entity.VideoPays
import com.example.geomob.DB_files.RessourcePays
import com.example.geomob.R
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import kotlinx.android.synthetic.main.ressource_item.view.*
import kotlinx.android.synthetic.main.video_item.view.*

class VideoAdapter (val context: Context?, private val components: List<VideoPays>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        var item  = components.get(position)
        holder.itemView.pub_vid.addYouTubePlayerListener(object : AbstractYouTubePlayerListener() {
            override fun onReady(youTubePlayer: YouTubePlayer)
            {

                youTubePlayer.cueVideo(item.getIdVid()!!, 0f)

            }
        })

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.video_item, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return components.size
    }
    inner  class ViewHolder(v: View?) : RecyclerView.ViewHolder(v!!), View.OnClickListener {
        override fun onClick(v: View?)
        {
            //no click here
        }

        init {
            itemView.setOnClickListener(this)
        }
    }

}