//package www.sanju.customtabbar.Fragments
package com.example.geomob

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

//import com.example.geomob.R


/**
 * A simple [Fragment] subclass.
 */
@SuppressLint("ValidFragment")
class VideoFragment( idP:Int) : Fragment() {
    var paysNum = idP
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var lay = inflater.inflate(R.layout.fragment_video, container, false)
        var TextView = lay.findViewById<TextView>(R.id.textVideo)
        TextView.text = " je suis dans le fragment Video avec un id  " + paysNum
        return lay
    }


}
