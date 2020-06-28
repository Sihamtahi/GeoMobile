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
class VideoPays
{

    @PrimaryKey(autoGenerate = true)
    private var id: Int = 0

    @ColumnInfo(name = "urlVid")
    private var urlVid: String? = null

    @ColumnInfo(name = "idVid")
    private var idVid: String? = null

    @ColumnInfo(name = "paysId")
    private var paysId: Int = 0


    /*
* Getters and Setters
* */


    fun getId(): Int? {
        return id
    }

    fun getUrlVid(): String? {
        return urlVid
    }

    fun getIdVid(): String? {
        return idVid
    }

    fun getPaysId(): Int? {
        return paysId
    }

    fun setId(i:Int)
    {
        this.id = i
    }

    fun setPaysId(d: Int) {
        this.paysId= d
    }


    fun setUrlVid(url: String) {
        this.urlVid= url
    }

    fun setIdVid(idVid: String) {
        this.idVid= idVid
    }


}