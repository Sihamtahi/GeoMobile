package com.example.geomob

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.geomob.Adapter.HistoriqueAdapter
import com.example.geomob.Adapter.RessourceAdapter
import com.example.geomob.DB_files.DataBase.DatabaseClient


/**
 * A simple [Fragment] subclass.
 */
@SuppressLint("ValidFragment")
class RessourceFragment(idP:Int) : Fragment() {
    var paysNum = idP
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var lay = inflater.inflate(R.layout.fragment_ressource, container, false)

        var recyclerHistorique = lay.findViewById<RecyclerView>(R.id.RecylerRessource)
        var mLayoutManager : RecyclerView.LayoutManager

        mLayoutManager = LinearLayoutManager(lay.context)
        recyclerHistorique.layoutManager = mLayoutManager
        var listeCompo = DatabaseClient.getAppDatabase(DatabaseClient.getInstance(lay.context))
            .ressourceDao()
            .getResPays(paysNum)

        recyclerHistorique.adapter = RessourceAdapter(lay.context,listeCompo)
        return lay
    }
}
