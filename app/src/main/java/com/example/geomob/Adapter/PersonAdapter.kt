package com.example.geomob.Adapter

import android.content.Context
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.example.geomob.DB_files.PersoPays
import com.example.geomob.DB_files.RessourcePays
import com.example.geomob.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.personnage_item.view.*
import kotlinx.android.synthetic.main.ressource_item.view.*
import kotlinx.android.synthetic.main.rv_layout.view.*


class PersonAdapter (val context: Context?, private val components: List<PersoPays>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        var item  = components.get(position)
        holder.itemView.personNom.text= item.getNomPerso()
        holder.itemView.personPrenom.text = item.getPrenomPerso()
        holder.itemView.description.text = item.getDescription()

        holder.itemView.avatar.clipToOutline = true
        Picasso.get().load(item.getAvatar()).into(holder.itemView.avatar)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.personnage_item, parent, false)
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
        val  nom = itemView.personNom
        val prenom = itemView.personPrenom
        val descr = itemView.description

    }

}