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
class RessourcePays
{

    @PrimaryKey(autoGenerate = true)
    private var id: Int = 0

    @ColumnInfo(name = "nomRes")
    private var nomRes: String? = null

    @ColumnInfo(name = "typeRes")
    private var typeRes: String? = null

    @ColumnInfo(name = "paysId")
    private var paysId: Int = 0
    /*
* Getters and Setters
* */


    fun getId(): Int? {
        return id
    }

    fun getNomRes(): String? {
        return nomRes
    }
    fun getTypeRes(): String? {
        return typeRes
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

    fun setNomRes(nomR: String) {
        this.nomRes= nomR
    }
    fun setTypeRes(type: String) {
        this.typeRes= type
    }

}