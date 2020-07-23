package com.example.geomob.DB_files

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey


@Entity(foreignKeys = arrayOf(
    ForeignKey(entity = Pays::class,
        parentColumns = arrayOf("id"),
        childColumns = arrayOf("paysId"),
        onDelete = ForeignKey.CASCADE)))
class PersoPays
{

    @PrimaryKey(autoGenerate = true)
    private var id: Int = 0

    @ColumnInfo(name = "nomPerso")
    private var nomPerso: String? = null

    @ColumnInfo(name = "prenomPerso")
    private var prenomPerso: String? = null

    @ColumnInfo(name = "paysId")
    private var paysId: Int = 0

    @ColumnInfo(name = "avatar")
    private var avatar: String? = null

    @ColumnInfo(name = "description")
    private var description: String? = null


    /*
* Getters and Setters
* */


    fun getId(): Int? {
        return id
    }

    fun getNomPerso(): String? {
        return nomPerso
    }
    fun getPrenomPerso(): String? {
        return prenomPerso
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


    fun setNomPerso(nom: String) {
        this.nomPerso= nom
    }
    fun setPrenomPerso(prenom: String) {
        this.prenomPerso= prenom
    }

    fun getAvatar() : String? {
        return avatar
    }

    fun setAvatar(avatar:String){
        this.avatar = avatar
    }
    fun getDescription() : String? {
        return description
    }

    fun setDescription(description:String){
        this.description = description
    }


}