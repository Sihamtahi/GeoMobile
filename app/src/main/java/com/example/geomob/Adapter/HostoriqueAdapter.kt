package com.example.geomob.Adapter

import android.content.Context
import android.content.Intent
import android.os.Build
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.example.geomob.DB_files.Entity.UiComponent
import com.example.geomob.DB_files.HistoriquePays
import com.example.geomob.DetailPage
import com.example.geomob.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.historique_item.view.*
import kotlinx.android.synthetic.main.rv_layout.view.*

class HistoriqueAdapter (val context: Context?, private val components: List<HistoriquePays>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        var item  = components.get(position)
        holder.itemView.dateHiistorique.text = item.getDate()
        holder.itemView.DescriptionHistorique.text = item.getDescription()

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.historique_item, parent, false)
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
        val date  = itemView.dateHiistorique
        val description = itemView.DescriptionHistorique

    }

}