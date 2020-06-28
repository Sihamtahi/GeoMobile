package com.example.geomob.DB_files.Dao

import androidx.room.*
import com.example.geomob.DB_files.Entity.ImagePays
import com.example.geomob.DB_files.Entity.VideoPays

@Dao
interface VideoDao {

    @Query("SELECT * FROM  VideoPays ")

    fun getAll(): List<VideoPays>

    @Query("SELECT * FROM VideoPays where paysId  = :idPays ")
    fun getVidPays(idPays :Int): List< VideoPays>

    @Insert
    fun insert(task: VideoPays)

    @Delete
    fun delete(task: VideoPays)

    @Update
    fun update(task: VideoPays)

}