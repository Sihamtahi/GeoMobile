package com.example.geomob.DB_files

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Pays
{

    @PrimaryKey(autoGenerate = true)
    private var id: Int = 0

    @ColumnInfo(name = "nom")
    private var nom: String? = null

    @ColumnInfo(name = "description")
    private var description: String? = null

    @ColumnInfo(name = "population")
    private var population: String? = null

    @ColumnInfo(name = "surface")
    private var surface: String? = null

    @ColumnInfo(name = "flagUrl")
    private var flagUrl: String? = null

    @ColumnInfo(name = "hymneUrl")
    private var hymneUrl: String? = null

    @ColumnInfo(name = "isExplored")
    private var isExplored: Boolean? = false


    /*
    * Getters and Setters
    * */


    fun getId(): Int? {
        return id
    }

    fun getNom(): String? {
        return nom
    }
    fun getDescription(): String? {
        return description
    }

    fun getPopulation(): String? {
        return population
    }

    fun getSurface(): String? {
        return surface
    }

    fun getFlagUrl(): String? {
        return flagUrl
    }

    fun getHymneUrl(): String? {
        return hymneUrl
    }

    fun getIsExplored(): Boolean? {
        return isExplored
    }


  fun setId(i:Int)
  {
      this.id = i
  }
    fun setNom(nom: String) {
        this.nom= nom
    }
    fun setDescription(d: String) {
        this.description= d
    }
    fun setSurface(surface: String) {
        this.surface= surface
    }
    fun setPopulation(pop: String) {
        this.population= pop
    }
    fun setFlagUrl(url: String) {
        this.flagUrl= url
    }
    fun setHymneUrl(url: String) {
        this.hymneUrl= url
    }

    fun setIsExplored(isE: Boolean) {
        this.isExplored= isE
    }

}