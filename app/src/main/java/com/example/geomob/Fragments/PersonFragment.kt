//package www.sanju.customtabbar.Fragments
package com.example.geomob

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.geomob.DB_files.Entity.ImagePays


/**
 * A simple [Fragment] subclass.
 */
@SuppressLint("ValidFragment")
class PersonFragment (idP:Int) : Fragment() {
    var paysNum = idP
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View?
    {
        // Inflate the layout for this fragment
        var lay = inflater.inflate(R.layout.fragment_person, container, false)
        var TextView = lay.findViewById<TextView>(R.id.textPerson)
        TextView.text = " je suis dans le fragment ressource avec un id  " + paysNum
        return lay
    }

}
