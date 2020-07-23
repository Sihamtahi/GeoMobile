package com.example.geomob

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.geomob.*
import com.example.geomob.Fragments.TweetsFragment


internal class PagerViewAdapter(fm: FragmentManager?,idPays:Int) : FragmentPagerAdapter(fm!!) {
    var id = idPays
    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> {
                HomeFragment(id)
            }
            1 -> {
                HistoriqueFragment(id)
            }
            2 -> {
                VideoFragment(id)
            }
            3 -> {
                PersonFragment(id)
            }
            4 -> {
                RessourceFragment(id)
            }
            5 -> {
                TweetsFragment(id)
            }
            else -> HomeFragment(id)
        }
    }

    override fun getCount(): Int {

        return 6
    }

}

