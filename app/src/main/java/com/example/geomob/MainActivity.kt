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
import com.example.geomob.DB_files.Entity.UiComponent
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

        //updateImages()
    }
}
