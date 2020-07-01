package com.example.geomob.Adapter

import android.content.Context
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.example.geomob.DB_files.HistoriquePays
import com.example.geomob.DB_files.RessourcePays
import com.example.geomob.R
import kotlinx.android.synthetic.main.historique_item.view.*
import kotlinx.android.synthetic.main.ressource_item.view.*

class RessourceAdapter (val context: Context?, private val components: List<RessourcePays>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        var item  = components.get(position)
        holder.itemView.ressourceNom.text = item.getNomRes()
        holder.itemView.TypeRessource.text = item.getTypeRes()

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.ressource_item, parent, false)
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
        val res  = itemView.ressourceNom
        val type = itemView.TypeRessource

    }

}