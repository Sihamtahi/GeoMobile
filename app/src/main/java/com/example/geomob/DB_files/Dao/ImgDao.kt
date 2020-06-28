package com.example.geomob.DB_files.Dao

import androidx.room.*
import com.example.geomob.DB_files.Entity.ImagePays
import com.example.geomob.DB_files.RessourcePays

@Dao
interface ImgDao {

    @Query("SELECT * FROM  ImagePays")

    fun getAll(): List<ImagePays>

    @Query("SELECT * FROM ImagePays where paysId  = :idPays ")
    fun getImgPays(idPays :Int): List<ImagePays>

    @Insert
    fun insert(task: ImagePays)

    @Delete
    fun delete(task: ImagePays)

    @Update
    fun update(task: ImagePays)

}