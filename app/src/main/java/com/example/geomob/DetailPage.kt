package com.example.geomob
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageButton
import android.widget.Toast
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import androidx.viewpager.widget.ViewPager
import com.example.geomob.DB_files.DataBase.DatabaseClient
import com.example.geomob.DB_files.Entity.UiComponent
import com.example.geomob.DB_files.Pays
import com.example.geomob.DB_files.PersoPays


class DetailPage : AppCompatActivity() {
    private lateinit var homeBtn:ImageButton
    private lateinit var addBtn:ImageButton
    private lateinit var notiBtn:ImageButton
    private lateinit var searchBtn:ImageButton
    private lateinit var profileBtn: ImageButton
    private lateinit var tweetsBtn: ImageButton

    private lateinit var mViewPager: ViewPager
    private lateinit var mPagerViewAdapter: PagerViewAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_page)


        //get the idPays from the first page
        var idPays: Int = intent.getIntExtra("idPays",0)

        Log.d("Sonthing", "je suis dans le detail view et la valeur reécuprée est :"+idPays)

        // init views
        mViewPager = findViewById(R.id.mViewPager)
        homeBtn = findViewById(R.id.homeBtn)
        addBtn = findViewById(R.id.addBtn)
        profileBtn = findViewById(R.id.profileBtn)
        searchBtn = findViewById(R.id.searchBtn)
        notiBtn = findViewById(R.id.notiBtn)
        tweetsBtn = findViewById(R.id.tweetsBtn)


        //onclick listner

        homeBtn.setOnClickListener {
            mViewPager.currentItem = 0

        }

        searchBtn.setOnClickListener {

            mViewPager.currentItem = 1

        }

        addBtn.setOnClickListener {
            mViewPager.currentItem = 2

        }

        notiBtn.setOnClickListener {
            mViewPager.currentItem = 3

        }

        profileBtn.setOnClickListener {
            mViewPager.currentItem = 4

        }

        tweetsBtn.setOnClickListener {
            mViewPager.currentItem = 5

        }


        mPagerViewAdapter = PagerViewAdapter(supportFragmentManager,idPays)
        mViewPager.adapter = mPagerViewAdapter
        mViewPager.offscreenPageLimit = 6

        mViewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
            }

            override fun onPageSelected(position: Int) {
                changeTabs(position)
            }

            override fun onPageScrollStateChanged(state: Int) {}
        })

        mViewPager.currentItem = 0
        homeBtn.setImageResource(R.drawable.ic_home_pink)


    }



    private fun changeTabs(position: Int) {


        if (position == 0) {
            homeBtn.setImageResource(R.drawable.ic_home_pink)
            searchBtn.setImageResource(R.drawable.ic_history_black)
            addBtn.setImageResource(R.drawable.ic_video_black)
            notiBtn.setImageResource(R.drawable.ic_person_black)
            profileBtn.setImageResource(R.drawable.ic_ressource_black)
            tweetsBtn.setImageResource(R.drawable.tweets)


        }
        if (position == 1) {
            homeBtn.setImageResource(R.drawable.ic_home_black_)
            searchBtn.setImageResource(R.drawable.ic_history_pink)
            addBtn.setImageResource(R.drawable.ic_video_black)
            notiBtn.setImageResource(R.drawable.ic_person_black)
            profileBtn.setImageResource(R.drawable.ic_ressource_black)
            tweetsBtn.setImageResource(R.drawable.tweets)



        }
        if (position == 2) {
            homeBtn.setImageResource(R.drawable.ic_home_black_)
            searchBtn.setImageResource(R.drawable.ic_history_black)
            addBtn.setImageResource(R.drawable.ic_video_pink)
            notiBtn.setImageResource(R.drawable.ic_person_black)
            profileBtn.setImageResource(R.drawable.ic_ressource_black)
            tweetsBtn.setImageResource(R.drawable.tweets)
        }
        if (position == 3) {
            homeBtn.setImageResource(R.drawable.ic_home_black_)
            searchBtn.setImageResource(R.drawable.ic_history_black)
            addBtn.setImageResource(R.drawable.ic_video_black)
            notiBtn.setImageResource(R.drawable.ic_perosn_pink)
            profileBtn.setImageResource(R.drawable.ic_ressource_black)
            tweetsBtn.setImageResource(R.drawable.tweets)
        }
        if (position == 4) {
            homeBtn.setImageResource(R.drawable.ic_home_black_)
            searchBtn.setImageResource(R.drawable.ic_history_black)
            addBtn.setImageResource(R.drawable.ic_video_black)
            notiBtn.setImageResource(R.drawable.ic_person_black)
            profileBtn.setImageResource(R.drawable.ic_ressouce_pink)
            tweetsBtn.setImageResource(R.drawable.tweets)
        }
        if (position == 5) {
            homeBtn.setImageResource(R.drawable.ic_home_black_)
            searchBtn.setImageResource(R.drawable.ic_history_black)
            addBtn.setImageResource(R.drawable.ic_video_black)
            notiBtn.setImageResource(R.drawable.ic_person_black)
            profileBtn.setImageResource(R.drawable.ic_ressource_black)
            tweetsBtn.setImageResource(R.drawable.tweets_pink)
        }



    }


}
