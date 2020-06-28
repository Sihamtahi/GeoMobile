package com.example.geomob.DB_files.Dao

import androidx.room.*
import com.example.geomob.DB_files.PersoPays
import com.example.geomob.DB_files.RessourcePays

@Dao
interface RessourceDao {

    @Query("SELECT * FROM RessourcePays")

    fun getAll(): List<RessourcePays>

    @Query("SELECT * FROM RessourcePays where paysId  = :idPays ")
    fun getResPays(idPays :Int): List<RessourcePays>

    @Insert
    fun insert(task: RessourcePays)

    @Delete
    fun delete(task: RessourcePays)

    @Update
    fun update(task: RessourcePays)

}