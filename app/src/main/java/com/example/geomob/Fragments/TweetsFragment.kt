package com.example.geomob.Fragments

import com.example.geomob.R
import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.geomob.Adapter.TweetAdapter
import com.example.geomob.DB_files.DataBase.DatabaseClient
import com.example.geomob.DB_files.Entity.Tweet
import com.example.geomob.DB_files.Pays
import kotlinx.android.synthetic.main.fragment_tweets.*
import com.example.geomob.Model.AppExecutors
import kotlinx.android.synthetic.*
import twitter4j.*
import twitter4j.conf.ConfigurationBuilder


/**
 * A simple [Fragment] subclass.
 */
@SuppressLint("ValidFragment")
class TweetsFragment(idP: Int) : Fragment() {


    private var countryName = ""
    var paysNum = idP

    var tweetList = arrayListOf<Tweet>()

    lateinit var tweetAdapter: TweetAdapter
    lateinit var layoutManager : LinearLayoutManager

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //recyclerView.setHasFixedSize(true)

        /*layoutManager = LinearLayoutManager(activity)
        recyclerView.layoutManager = layoutManager

        tweetAdapter = TweetAdapter(tweetList)
        recyclerView.adapter = tweetAdapter*/
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       // return inflater.inflate(R.layout.fragment_tweets, container, false)
        var lay = inflater.inflate(R.layout.fragment_tweets, container, false)
        var pays = getPays(paysNum,lay.context)
        var recyclerView = lay.findViewById<RecyclerView>(R.id.recyclerView)
        layoutManager = LinearLayoutManager(lay.context)
        recyclerView.layoutManager = layoutManager

        tweetAdapter = TweetAdapter(tweetList)
        recyclerView.adapter = tweetAdapter

        println("init twitter")
        initTwitter()
        countryName = pays.getNom().toString()
        return lay
    }

    fun initTwitter(){
        AppExecutors.instance!!.diskIO().execute {
            val consumerKey = "COsOtBhZTEio0Y914UgtrHAth"
            val consumerKeySecret = "3gik38I9zybCZ6vGVF8UtzOwfZVe6sxhXIY2lfheQourp7UJL2"
            val accessToken = "1223554396883124224-rLKldQDAEhKI3mMTTMP9c4Y70Iid4W"
            val accessTokenSecret = "w352GRg5r3mmkVVeECBIPRPisBZq7rsceUgJayhULGj3l"

// Auth à l'API de twitter
            val cb = ConfigurationBuilder()
            cb.setDebugEnabled(true)
                .setOAuthConsumerKey(consumerKey)
                .setOAuthConsumerSecret(consumerKeySecret)
                .setOAuthAccessToken(accessToken)
                .setOAuthAccessTokenSecret(accessTokenSecret)

            val tf = TwitterFactory(cb.build())
            val twitter = tf.instance

            searchQuery(twitter,countryName)
        }

    }

    fun searchQuery(twitter : Twitter, query : String){
        try {
            val query = Query(query)
            val result: QueryResult
            tweetList.clear()
            query.count = 30
            query.lang = "en"
            result = twitter.search(query)

            for (status in result.tweets) {
                var mediaUrl = ""
                if (status.mediaEntities.isNotEmpty()){
                    mediaUrl = status.mediaEntities[0].mediaURLHttps
                }
                val tweet = Tweet(status.id, status.user.originalProfileImageURLHttps, status.user.name, "@"+status.user.screenName,
                    mediaUrl, status.text, countryName)
                println("tweet est "+tweet.contenu)
                tweetList.add(tweet)
            }

            AppExecutors.instance!!.mainThread().execute {
                tweetAdapter.notifyDataSetChanged()
            }

        } catch (e: TwitterException) {
            println("dans catch erreur "+e.errorMessage)
            e.printStackTrace()
        }
    }
    fun getPays(idP:Int, cntx: Context): Pays
    {
        var liste  = DatabaseClient.getAppDatabase(DatabaseClient.getInstance(cntx))
            .paysDao()
            .getAll()

        var p : Pays? = null
        for (instance in liste )
        {
            if ( instance.getId() == idP)
            {
                p = instance
            }
        }
        return p!!
    }
}
