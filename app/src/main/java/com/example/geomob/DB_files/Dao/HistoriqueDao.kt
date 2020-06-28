package com.example.geomob.DB_files.Dao

import androidx.room.*
import com.example.geomob.DB_files.HistoriquePays
import com.example.geomob.DB_files.Pays


@Dao
interface HistoriqueDao {

    @Query("SELECT * FROM HistoriquePays")
    fun getAll(): List<HistoriquePays>

    @Query("SELECT * FROM HistoriquePays where paysId  = :idPays ")
    fun getHistoPays(idPays :Int): List<HistoriquePays>


    @Insert
    fun insert(task: HistoriquePays)

    @Delete
    fun delete(task: HistoriquePays)

    @Update
    fun update(task:HistoriquePays)

}