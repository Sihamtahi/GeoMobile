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
class UiComponent
{

    @PrimaryKey(autoGenerate = true)
    private var id: Int = 0

    @ColumnInfo(name = "titreUi")
    private var titreUi: String? = null

    @ColumnInfo(name = "sousTitreUi")
    private var sousTitreUi: String? = null

    @ColumnInfo(name = "urlAnimImg")
    private var urlAnimImg: String? = null

    @ColumnInfo(name = "paysId")
    private var paysId: Int = 0


    /*
* Getters and Setters
* */


    fun getId(): Int? {
        return id
    }

    fun getTitreUi(): String? {
        return titreUi
    }
    fun getSousTitreUi(): String? {
        return sousTitreUi
    }
    fun getUrlAnimImg() :String?
    {
        return urlAnimImg

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

    fun setTitreUi(nom: String) {
        this.titreUi= nom
    }
    fun setSousTitreUi(soust: String) {
        this.sousTitreUi= soust
    }
    fun setUrlAnimImg(url: String) {
        this.urlAnimImg= url
    }

}