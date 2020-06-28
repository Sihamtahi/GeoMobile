package com.example.geomob.DB_files.Dao

import androidx.room.*
import com.example.geomob.DB_files.Pays


@Dao
interface PaysDao {

    @Query("SELECT * FROM Pays")

    fun getAll(): List<Pays>

    @Insert
    fun insert(task: Pays)

    @Delete
    fun delete(task: Pays)

    @Update
    fun update(task: Pays)

}