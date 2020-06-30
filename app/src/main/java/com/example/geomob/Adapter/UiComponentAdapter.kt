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
import com.example.geomob.DetailPage
import com.example.geomob.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.rv_layout.view.*
import www.sanju.tourism.Model.Places

class UiComponentAdapter (val context: Context?, private val components: List<UiComponent>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {


        holder.itemView.tour_image.clipToOutline = true
        Picasso.get().load(components[position].getUrlAnimImg()).into(holder.itemView.tour_image)

        //kensburn animation here
        holder.itemView.tour_image.resume()
        holder.itemView.tour_title.text = components[position].getTitreUi()
        holder.itemView.tour_description.text = components[position].getSousTitreUi()
       // holder.itemView.ratingBar.rating = 3f
        //Image Animation
        //  holder.newsImageUrl.animation = AnimationUtils.loadAnimation(context,R.anim.fade_image)
        //Card Animation
        // holder.card.animation = AnimationUtils.loadAnimation(context,R.anim.card_fade)    }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.rv_layout, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return components.size
    }



  inner  class ViewHolder(v: View?) : RecyclerView.ViewHolder(v!!), View.OnClickListener {
        override fun onClick(v: View?)
        {

            Log.d("Sonthing","Tu as tapé le rceycler view  niiii")

            val uiCompo = components.get(adapterPosition)
            Log.d("Sonthing","---------------------------->"+uiCompo.getPaysId())
            val intent = Intent(v!!.context,  DetailPage::class.java)
            intent.putExtra("idPays",uiCompo.getPaysId())
            v.context.startActivity(intent)

        }

        init {
            itemView.setOnClickListener(this)
        }

        val image = itemView.tour_image!!
        val title = itemView.tour_image!!
        // val desc = itemView.tour_image!!
    }

}
/****
class ViewHolder(v: View?) : RecyclerView.ViewHolder(v!!), View.OnClickListener {
    override fun onClick(v: View?) {

        Log.d("Sonthing","Tu as tapé le rceycler view  niiii")

        val intent = Intent(v!!.context,  DetailPage::class.java)
       // intent.putExtra("id",intervention.getId())
        v.context.startActivity(intent)

    }

    init {
        itemView.setOnClickListener(this)
    }

    val image = itemView.tour_image!!
    val title = itemView.tour_image!!
   // val desc = itemView.tour_image!!
}***/