package com.example.geomob.DB_files.Entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.example.geomob.DB_files.Pays


@Entity(foreignKeys = arrayOf(
    ForeignKey(entity = Pays::class,
        parentColumns = arrayOf("id"),
        childColumns = arrayOf("paysId"),
        onDelete = ForeignKey.CASCADE)
))
class ImagePays
{

    @PrimaryKey(autoGenerate = true)
    private var id: Int = 0

    @ColumnInfo(name = "urlImg")
    private var urlImg: String? = null

    @ColumnInfo(name = "paysId")
    private var paysId: Int = 0


    /*
* Getters and Setters
* */


    fun getId(): Int? {
        return id
    }

    fun getUrlImg(): String? {
        return urlImg
    }

    fun getPaysId(): Int? {
        return paysId
    }

    fun setId(d: Int) {
        this.id= d
    }

    fun setPaysId(d: Int) {
        this.paysId= d
    }


    fun setUrlImg(url: String) {
        this.urlImg= url
    }


}