package com.example.geomob.DB_files.DataBase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.geomob.DB_files.*
import com.example.geomob.DB_files.Dao.*
import com.example.geomob.DB_files.Entity.ImagePays
import com.example.geomob.DB_files.Entity.UiComponent
import com.example.geomob.DB_files.Entity.VideoPays


@Database(version = 4,entities = [
    Pays::class,
    HistoriquePays :: class,
    PersoPays :: class,
    VideoPays :: class ,
    ImagePays :: class,
    RessourcePays:: class,
    UiComponent:: class


])

abstract class AppDatabase : RoomDatabase() {
    abstract fun paysDao(): PaysDao
    abstract fun historiqueDao(): HistoriqueDao
    abstract fun ressourceDao(): RessourceDao
    abstract fun imgDao(): ImgDao
    abstract fun videoDao(): VideoDao
    abstract fun persoDao(): PersoDao
    abstract fun uiComponentDao():UiComponentDao

}

class DatabaseClient private constructor(private val mCtx: Context) {

    //our app database object
    val appDatabase: AppDatabase

    var  migrtion : Migration = object : Migration(3,4)
    {
        override fun migrate(database: SupportSQLiteDatabase)
        {
            //Create new table PersoPays_new
            database.execSQL("CREATE TABLE 'PersoPays_new' ('id' INTEGER DEFAULT 0 NOT NULL , 'nomPerso' TEXT  , 'prenomPerso' TEXT  ,  'avatar' TEXT , 'description' TEXT ,   'paysId' INTEGER DEFAULT 0 NOT NULL," + "PRIMARY KEY('id') ,FOREIGN KEY(paysId) REFERENCES Pays(id) ON DELETE CASCADE) " )

            // Remove the old table
            database.execSQL(" DROP TABLE" + "'PersoPays' ")

            // Change the table name to the correct one
            database.execSQL("ALTER TABLE PersoPays_new RENAME TO"+" PersoPays")

          //  database.execSQL("ALTER TABLE PersoPays "
            //        +"ADD COLUMN description TEXT DEFAULT NOT NULL")
            //database.execSQL("ALTER TABLE PersoPays "
              //      +"ADD COLUMN description TEXT DEFAULT NOT NULL")

// Copy the data
       //     database.execSQL(
         //       "INSERT INTO users_new (userid, username, last_update) SELECT userid, username, last_update FROM users")


        }
    }
    init {

        //creating the app database with Room database builder
        //MyToDos is the name of the database
        appDatabase = Room
            .databaseBuilder(mCtx, AppDatabase::class.java, "MyToDos")
            .addMigrations(migrtion)
            .allowMainThreadQueries()
            .build()
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


