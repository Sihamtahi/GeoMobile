package com.example.geomob

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.view.MotionEvent
import android.view.View
import android.view.View.OnTouchListener



class article : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_article)
       val listItems = arrayOfNulls<String>(8)
        listItems[0] = "لم يكن هناك أي علم بوجود هذا الفيروس"
        listItems[1] = "يتعافى معظم الناس (نحو 80%)"
        listItems[2] = "تواصل منظمة الصحة العالمية رصد هذه الفاشية "
        listItems[3] = "قد تحوّل كوفيد-19 الآن إلى جائحة تؤثر على العديد من بلدان العال."
        listItems[4] = "الحمى والإرهاق والسعال الجاف."
        listItems[5] = "نتشر عدوى كوفيد-19 أساساً عن طريق القطيرات التنفسية التي يفرزها شخص يسعل"
        listItems[6] = "حافظ على مسافة متر واحد على الأقل "
        listItems[7] = "العزل الذاتي إجراء مهم يطبقه"

        var listView  = findViewById<ListView >(R.id.listCom)
        listView.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1,listItems)
        listView.setOnTouchListener(object : OnTouchListener {
            // Setting on Touch Listener for handling the touch inside ScrollView
            override fun onTouch(v: View, event: MotionEvent): Boolean {
                // Disallow the touch request for parent scroll on touch of child view
                v.getParent().requestDisallowInterceptTouchEvent(true)
                return false
            }
        })



    }
}
