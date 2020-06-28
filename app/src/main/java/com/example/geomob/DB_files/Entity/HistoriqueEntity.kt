package com.example.geomob.DB_files

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey


@Entity (foreignKeys = arrayOf(
    ForeignKey(entity = Pays::class,
        parentColumns = arrayOf("id"),
        childColumns = arrayOf("paysId"),
        onDelete = ForeignKey.CASCADE)
))
class HistoriquePays
{

    @PrimaryKey(autoGenerate = true)
    private var id: Int = 0

    @ColumnInfo(name = "date")
    private var date: String? = null

    @ColumnInfo(name = "description")
    private var description: String? = null

    @ColumnInfo(name = "paysId")
    private var paysId: Int = 0

        /*
    * Getters and Setters
    * */


    fun getId(): Int? {
        return id
    }

    fun getDate(): String? {
        return date
    }
    fun getDescription(): String? {
        return description
    }

    fun getPaysId(): Int? {
        return paysId
    }

    fun setId (i:Int)
    {
        this.id = i
    }

    fun setDate(date: String) {
        this.date= date
    }
    fun setDescription(d: String) {
        this.description= d
    }


    fun setPaysId(d: Int) {
        this.paysId= d
    }


}

