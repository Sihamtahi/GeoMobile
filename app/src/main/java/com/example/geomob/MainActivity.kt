package com.example.geomob

import android.annotation.SuppressLint
import android.content.Intent
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
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
import kotlinx.android.synthetic.main.layout_dialog_info.*
import www.sanju.tourism.Adapter.CenterZoomLayoutManager
import www.sanju.tourism.Adapter.TourAdapter
import www.sanju.tourism.Model.Places

class MainActivity : AppCompatActivity() {
    @SuppressLint("WrongConstant")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Toast.makeText(this, "Main activity is launched ", Toast.LENGTH_LONG)
        var toursRV = findViewById<RecyclerView>(R.id.tours_RV)
        var linearLayoutManager = CenterZoomLayoutManager(this)
        linearLayoutManager.orientation = LinearLayoutManager.HORIZONTAL
        linearLayoutManager.reverseLayout = true
        linearLayoutManager.stackFromEnd = true
        toursRV.layoutManager = linearLayoutManager
        val snapHelper = LinearSnapHelper()
        snapHelper.attachToRecyclerView(toursRV)
        toursRV.isNestedScrollingEnabled = false

        var listeCompo =
            DatabaseClient.getAppDatabase(DatabaseClient.getInstance(applicationContext)).uiComponentDao().getAll()
        toursRV.adapter = UiComponentAdapter(this, listeCompo)


        chercerNvPays()


    }
   private fun chercerNvPays()
   {
       var listeImg = DatabaseClient.getAppDatabase(DatabaseClient.getInstance(this))
           .paysDao()
           .getAll()

       var pays :Pays  = Pays()
       var stop = false
        var index  = 0

       while (!stop && index < listeImg.size )
       {
           pays  = listeImg.get(index)
               if (pays.getIsExplored() == false)
           {
              stop = true
           }
           else{
                   index  = index + 1
               }
       }
       if ( stop == true) {
           showAlertDialog(pays)
       }
   }
    private fun showAlertDialog(p :Pays) {
        val placeForInformation = LayoutInflater.from(this).inflate(R.layout.layout_dialog_info, null)
        val dial = AlertDialog.Builder(this)
        val cancel_btn: Button = placeForInformation.findViewById(R.id.cancel_dialog)
        val oui_btn: Button = placeForInformation.findViewById(R.id.oui_dialog)
        dial.setView(placeForInformation)
        var d = dial.show()

        d.window.setBackgroundDrawableResource(R.drawable.dialog_backgroun_region_info)
        placeForInformation.findViewById<TextView>(R.id.nomPays).text= p.getNom()

        cancel_btn.setOnClickListener {
            d.dismiss()
        }

        oui_btn.setOnClickListener {
            val intent = Intent(this,  DetailPage::class.java)
            intent.putExtra("idPays",p.getId())
            d.dismiss()
           this.startActivity(intent)
        }

    }
}