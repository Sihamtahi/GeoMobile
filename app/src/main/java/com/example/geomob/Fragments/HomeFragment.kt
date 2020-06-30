//package www.sanju.customtabbar.Fragments
package com.example.geomob

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.denzcoskun.imageslider.ImageSlider
import com.denzcoskun.imageslider.models.SlideModel
import com.example.geomob.DB_files.DataBase.DatabaseClient
import com.example.geomob.DB_files.Entity.ImagePays
import com.example.geomob.DB_files.Pays
import kotlinx.android.synthetic.main.fragment_home.*

/**
 * A simple [Fragment] subclass.
 */
@SuppressLint("ValidFragment")
class HomeFragment (idP:Int): Fragment() {
    var paysNum = idP
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
         var lay = inflater.inflate(R.layout.fragment_home, container, false)
         var pays = getPays(paysNum,lay.context)
        /**Slider**/
        var slider = lay.findViewById<ImageSlider >(R.id.slider)
        slider.setImageList(TransformImgPaysToSliderModel(paysNum,lay.context))
        /***Surafce ******/
        var surface = lay.findViewById<TextView>(R.id.textSurafce)
        surface.text = pays.getSurface()

        /***Population*****/
        var pop = lay.findViewById<TextView>(R.id.textPopulation)
        pop.text = pays.getPopulation()
        /***Description**/
        var desc = lay.findViewById<TextView>(R.id.textDescription)
        desc.text = pays.getDescription()
        /**Flag***/
        var flag = lay.findViewById<ImageView>(R.id.imgFlag)
        Glide.with(lay.context)
            .load(pays.getFlagUrl())
            .into(flag)

        return lay
    }

 fun TransformImgPaysToSliderModel(idPays:Int, cntx:Context) :ArrayList<SlideModel>
 {  var liste :ArrayList<SlideModel> = ArrayList()
     var listeImg = DatabaseClient.getAppDatabase(DatabaseClient.getInstance(cntx))
         .imgDao()
         .getImgPays(idPays)


     for (imgPays in listeImg)
     {
         Log.d("Sonthing "," "+imgPays.getUrlImg()!!)
         liste.add( SlideModel(imgPays.getUrlImg().toString()))
     }


     return liste
 }
    fun getPays(idP:Int, cntx:Context): Pays
    {
        var liste  = DatabaseClient.getAppDatabase(DatabaseClient.getInstance(cntx))
            .paysDao()
            .getAll()

        var p : Pays? = null
        for (instance in liste )
        {
            if ( instance.getId() == idP)
            {
               p = instance
            }
        }
        return p!!
    }
}
