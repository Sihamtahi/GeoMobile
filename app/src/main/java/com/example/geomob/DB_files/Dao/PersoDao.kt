package com.example.geomob.DB_files.Dao

import androidx.room.*
import com.example.geomob.DB_files.PersoPays

@Dao
interface PersoDao {

    @Query("SELECT * FROM PersoPays")

    fun getAll(): List<PersoPays>

    @Query("SELECT * FROM PersoPays where paysId  = :idPays ")
    fun getPersoPays(idPays :Int): List<PersoPays>

    @Insert
    fun insert(task: PersoPays)

    @Delete
    fun delete(task: PersoPays)

    @Update
    fun update(task: PersoPays)

}