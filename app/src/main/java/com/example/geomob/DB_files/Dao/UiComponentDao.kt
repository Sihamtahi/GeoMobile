package com.example.geomob.DB_files.Dao

import androidx.room.*
import com.example.geomob.DB_files.Entity.UiComponent
import com.example.geomob.DB_files.RessourcePays

@Dao
interface UiComponentDao {

    @Query("SELECT * FROM UiComponent")
    fun getAll(): List<UiComponent>

    @Insert
    fun insert(task: UiComponent)

    @Delete
    fun delete(task: UiComponent)

    @Update
    fun update(task: UiComponent)

}