package com.example.geomob

import android.annotation.SuppressLint
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.geomob.Adapter.UiComponentAdapter
import com.example.geomob.DB_files.DataBase.DatabaseClient
import com.example.geomob.DB_files.Entity.ImagePays
import com.example.geomob.DB_files.Entity.VideoPays
import com.example.geomob.DB_files.HistoriquePays
import com.example.geomob.DB_files.Pays
import com.example.geomob.DB_files.PersoPays
import com.example.geomob.DB_files.RessourcePays
import www.sanju.tourism.Adapter.CenterZoomLayoutManager
import www.sanju.tourism.Adapter.TourAdapter
import www.sanju.tourism.Model.Places

class MainActivity : AppCompatActivity() {
    @SuppressLint("WrongConstant")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Toast.makeText(this,"Main activity is launched ",Toast.LENGTH_LONG)
        var  toursRV = findViewById<RecyclerView>(R.id.tours_RV)
        var linearLayoutManager = CenterZoomLayoutManager(this)
        linearLayoutManager.orientation = LinearLayoutManager.HORIZONTAL
        linearLayoutManager.reverseLayout = true
        linearLayoutManager.stackFromEnd = true
        toursRV.layoutManager = linearLayoutManager
        val snapHelper = LinearSnapHelper()
        snapHelper.attachToRecyclerView(toursRV)
        toursRV.isNestedScrollingEnabled = false

       var listeCompo = DatabaseClient.getAppDatabase(DatabaseClient.getInstance(applicationContext)).uiComponentDao().getAll()
        toursRV.adapter = UiComponentAdapter(this,listeCompo)
      //  updatePaysFlags()
        // getPays()
    }

    private fun getPays() {
        class GetTasks : AsyncTask<Void, Void?, List<Pays>>() {

            override fun doInBackground(vararg voids: Void): List<Pays> {
                val liste:List<Pays> = DatabaseClient.getAppDatabase(DatabaseClient.getInstance(applicationContext))
                    .paysDao()
                    .getAll()
                return liste
            }

            override fun onPostExecute(pays: List<Pays>) {
                super.onPostExecute(pays)
                Log.d("Sonthing","*********************************************Les pays**********************************************************")
                var p : Pays
                for (p in pays )
                {
                    Log.d("Sonthing","\n\n\n\n\n id = "+  p.getId() +" "+p.getNom()+ " "+ p.getDescription() +  " "+ p.getIsExplored() + " "+ p.getPopulation() + " "+ p.getSurface() + " "+ p.getFlagUrl() + " "+ p.getHymneUrl())
                }

            }
        }
        val gt = GetTasks()
        gt.execute()

    }

    fun updatePaysFlags()
    {
        var liste = DatabaseClient.getAppDatabase(DatabaseClient.getInstance(this))
            .paysDao()
            .getAll()

        var modified = liste.get(0)
        modified.setFlagUrl("https://www.countries-ofthe-world.com/flags-normal/flag-of-Algeria.png")
        modified.setPopulation("42,972")
        modified.setHymneUrl("https://upload.wikimedia.org/wikipedia/commons/7/79/National_anthem_of_Algeria%2C_by_the_U.S._Navy_Band.oga")
        DatabaseClient.getAppDatabase(DatabaseClient.getInstance(this)).paysDao().update(modified)


         modified = liste.get(1)
        modified.setFlagUrl("https://www.countries-ofthe-world.com/flags-normal/flag-of-Tunisia.png")
        modified.setHymneUrl("https://upload.wikimedia.org/wikipedia/commons/2/23/Humat_al-Hima.ogg")
        DatabaseClient.getAppDatabase(DatabaseClient.getInstance(this)).paysDao().update(modified)

         modified = liste.get(2)
        modified.setFlagUrl("https://www.countries-ofthe-world.com/flags-normal/flag-of-India.png")
        DatabaseClient.getAppDatabase(DatabaseClient.getInstance(this)).paysDao().update(modified)

         modified = liste.get(3)
        modified.setFlagUrl("https://www.countries-ofthe-world.com/flags-normal/flag-of-United-Kingdom.png")
        DatabaseClient.getAppDatabase(DatabaseClient.getInstance(this)).paysDao().update(modified)

         modified = liste.get(4)
        modified.setFlagUrl("https://www.countries-ofthe-world.com/flags-normal/flag-of-United-States-of-America.png")
        modified.setHymneUrl("https://upload.wikimedia.org/wikipedia/commons/2/25/\"The_Star-Spangled_Banner\"_performed_by_the_United_States_Navy_Band.mp3")
        DatabaseClient.getAppDatabase(DatabaseClient.getInstance(this)).paysDao().update(modified)

         modified = liste.get(5)
        modified.setFlagUrl("https://www.countries-ofthe-world.com/flags-normal/flag-of-Egypt.png")
        modified.setHymneUrl("https://upload.wikimedia.org/wikipedia/commons/f/f2/Bilady%2C_Bilady%2C_Bilady.ogg")
        DatabaseClient.getAppDatabase(DatabaseClient.getInstance(this)).paysDao().update(modified)

         modified = liste.get(6)
        modified.setFlagUrl("https://www.countries-ofthe-world.com/flags-normal/flag-of-Brazil.png")
        modified.setHymneUrl("https://upload.wikimedia.org/wikipedia/commons/0/0d/Hino-Nacional-Brasil-instrumental-mec.ogg")
        DatabaseClient.getAppDatabase(DatabaseClient.getInstance(this)).paysDao().update(modified)

    }
}
