package com.example.geomob.DB_files.DataBase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.geomob.DB_files.*
import com.example.geomob.DB_files.Dao.*
import com.example.geomob.DB_files.Entity.ImagePays
import com.example.geomob.DB_files.Entity.VideoPays


@Database(version = 1,entities = [
    Pays::class,
    HistoriquePays :: class,
    PersoPays :: class,
    VideoPays :: class ,
    ImagePays :: class,
    RessourcePays:: class
])
abstract class AppDatabase : RoomDatabase() {
    abstract fun paysDao(): PaysDao
    abstract fun historiqueDao(): HistoriqueDao
    abstract fun ressourceDao(): RessourceDao
    abstract fun imgDao(): ImgDao
    abstract fun videoDao(): VideoDao
    abstract fun persoDao(): PersoDao

}

class DatabaseClient private constructor(private val mCtx: Context) {

    //our app database object
    val appDatabase: AppDatabase

    init {

        //creating the app database with Room database builder
        //MyToDos is the name of the database
        appDatabase = Room.databaseBuilder(mCtx, AppDatabase::class.java, "MyToDos").build()
    }

    companion object {
        private var mInstance: DatabaseClient? = null
        @Synchronized
        fun getInstance(mCtx: Context): DatabaseClient {
            if (mInstance == null) {
                mInstance = DatabaseClient(mCtx)
            }
            return mInstance as DatabaseClient
        }

        fun getAppDatabase(databaseClient: DatabaseClient): AppDatabase {
            return databaseClient.appDatabase
        }

    }


}


