package com.example.geomob

import android.annotation.SuppressLint
import android.content.Context
import android.media.MediaPlayer
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.bumptech.glide.Glide
import com.bumptech.glide.load.model.GlideUrl
import com.bumptech.glide.module.GlideModule
import com.denzcoskun.imageslider.ImageSlider
import com.denzcoskun.imageslider.models.SlideModel
import com.example.geomob.DB_files.DataBase.DatabaseClient
import com.example.geomob.DB_files.Entity.ImagePays
import com.example.geomob.DB_files.Pays
import kotlinx.android.synthetic.main.activity_audio.*
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
        /**Mettre à jour dans la base de données pour indiquer que ce pays a été visité**/
        pays.setIsExplored(true)
        DatabaseClient.getAppDatabase(DatabaseClient.getInstance(lay.context)).paysDao().update(pays)
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
        /*********hymne *****/
         var mediaPlayer: MediaPlayer = MediaPlayer()
        lateinit var runnable: Runnable
        var handler: Handler = Handler()
        var playBtn= lay.findViewById<Button>(R.id.playBtn)
        var pauseBtn= lay.findViewById<Button>(R.id.pauseBtn)
        var stopBtn= lay.findViewById<Button>(R.id.stopBtn)
        var seek_bar= lay.findViewById<SeekBar>(R.id.seek_bar)
        var tv_pass= lay.findViewById<TextView>(R.id.tv_pass)
        var tv_due= lay.findViewById<TextView>(R.id.tv_due)
        var pause: Boolean = false
        // Start the media player
        playBtn.setOnClickListener {
            if (pause) {
                mediaPlayer.seekTo(mediaPlayer.currentPosition)
                mediaPlayer.start()
                pause = false
                Toast.makeText(lay.context, "media playing", Toast.LENGTH_SHORT).show()
            } else {

                mediaPlayer = MediaPlayer.create(
                    lay.context,
                    Uri.parse(pays.getHymneUrl())
                )
                mediaPlayer.start()
                Toast.makeText(lay.context, "media playing", Toast.LENGTH_SHORT).show()

            }
            /**************************Initialiser seek bar ***************************************/
            seek_bar.max = mediaPlayer.seconds

            runnable =  Runnable {
                    seek_bar.progress = mediaPlayer.currentSeconds
                    tv_pass.text = "${mediaPlayer.currentSeconds} sec"
                    val diff = mediaPlayer.seconds - mediaPlayer.currentSeconds
                    tv_due.text = "$diff sec"
                    handler.postDelayed(runnable, 1000)
            }
            handler.postDelayed(runnable, 1000)
            /************************** Fin Initialiser seek bar  ***************************************/


            playBtn.isEnabled = false
            pauseBtn.isEnabled = true
            stopBtn.isEnabled = true

            mediaPlayer.setOnCompletionListener {
                playBtn.isEnabled = true
                pauseBtn.isEnabled = false
                stopBtn.isEnabled = false
                Toast.makeText(lay.context, "end", Toast.LENGTH_SHORT).show()
            }
        }

        // Pause the media player
        pauseBtn.setOnClickListener {
            if (mediaPlayer.isPlaying) {
                mediaPlayer.pause()
                pause = true
                playBtn.isEnabled = true
                pauseBtn.isEnabled = false
                stopBtn.isEnabled = true
                Toast.makeText(lay.context , "media pause", Toast.LENGTH_SHORT).show()
            }
        }
        // Stop the media player
        stopBtn.setOnClickListener {
            if (mediaPlayer.isPlaying || pause.equals(true)) {
                pause = false
                seek_bar.setProgress(0)
                mediaPlayer.stop()
                mediaPlayer.reset()
                mediaPlayer.release()
                handler.removeCallbacks(runnable)

                playBtn.isEnabled = true
                pauseBtn.isEnabled = false
                stopBtn.isEnabled = false
                tv_pass.text = ""
                tv_due.text = ""
                Toast.makeText(lay.context, "media stop", Toast.LENGTH_SHORT).show()
            }
        }


        // Seek bar change listener
        seek_bar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, i: Int, b: Boolean) {
                if (b) {
                    mediaPlayer.seekTo(i * 1000)
                }
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {
            }
        })

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
    // Creating an extension property to get the media player time duration in seconds
    val MediaPlayer.seconds:Int
        get() {
            return this.duration / 1000
        }
    // Creating an extension property to get media player current position in seconds
    val MediaPlayer.currentSeconds:Int
        get() {
            return this.currentPosition/1000
        }
}
