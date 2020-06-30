//package www.sanju.customtabbar.Fragments
package com.example.geomob

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView


/**
 * A simple [Fragment] subclass.
 */
@SuppressLint("ValidFragment")
class HistoriqueFragment (idP:Int): Fragment() {
    var paysNum = idP
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var lay =inflater.inflate(R.layout.fragment_historique, container, false)
        var TextView = lay.findViewById<TextView>(R.id.textHistorique)
        TextView.text = " je suis dans le fragment historique avec un id  " + paysNum
        return lay
    }


}
