package com.example.geomob

import android.annotation.SuppressLint
import android.content.Intent
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.geomob.Adapter.UiComponentAdapter
import com.example.geomob.DB_files.DataBase.DatabaseClient
import com.example.geomob.DB_files.Entity.ImagePays
import com.example.geomob.DB_files.Entity.UiComponent
import com.example.geomob.DB_files.Entity.VideoPays
import com.example.geomob.DB_files.HistoriquePays
import com.example.geomob.DB_files.Pays
import com.example.geomob.DB_files.PersoPays
import com.example.geomob.DB_files.RessourcePays
import kotlinx.android.synthetic.main.layout_dialog_info.*
import www.sanju.tourism.Adapter.CenterZoomLayoutManager
import www.sanju.tourism.Adapter.TourAdapter
import www.sanju.tourism.Model.Places

class MainActivity : AppCompatActivity() {
    @SuppressLint("WrongConstant")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Toast.makeText(this, "Main activity is launched ", Toast.LENGTH_LONG)

        var toursRV = findViewById<RecyclerView>(R.id.tours_RV)
        var linearLayoutManager = CenterZoomLayoutManager(this)
        linearLayoutManager.orientation = LinearLayoutManager.HORIZONTAL
        linearLayoutManager.reverseLayout = true
        linearLayoutManager.stackFromEnd = true
        toursRV.layoutManager = linearLayoutManager
        val snapHelper = LinearSnapHelper()
        snapHelper.attachToRecyclerView(toursRV)
        toursRV.isNestedScrollingEnabled = false


        var listeCompo = DatabaseClient.getAppDatabase(DatabaseClient.getInstance(applicationContext)).uiComponentDao().getAll()
        toursRV.adapter = UiComponentAdapter(this, listeCompo)


        chercerNvPays()


    }
   private fun chercerNvPays()
   {
       var listeImg = DatabaseClient.getAppDatabase(DatabaseClient.getInstance(this))
           .paysDao()
           .getAll()

       var pays :Pays  = Pays()
       var stop = false
        var index  = 0

       while (!stop && index < listeImg.size )
       {
           pays  = listeImg.get(index)
               if (pays.getIsExplored() == false)
           {
              stop = true
           }
           else{
                   index  = index + 1
               }
       }
       if ( stop == true) {
           showAlertDialog(pays)
       }
   }
    private fun showAlertDialog(p :Pays) {
        val placeForInformation = LayoutInflater.from(this).inflate(R.layout.layout_dialog_info, null)
        val dial = AlertDialog.Builder(this)
        val cancel_btn: Button = placeForInformation.findViewById(R.id.cancel_dialog)
        val oui_btn: Button = placeForInformation.findViewById(R.id.oui_dialog)
        dial.setView(placeForInformation)
        var d = dial.show()

        d.window!!.setBackgroundDrawableResource(R.drawable.dialog_backgroun_region_info)
        placeForInformation.findViewById<TextView>(R.id.nomPays).text= p.getNom()

        cancel_btn.setOnClickListener {
            d.dismiss()
        }

        oui_btn.setOnClickListener {
            val intent = Intent(this,  DetailPage::class.java)
            intent.putExtra("idPays",p.getId())
            d.dismiss()
           this.startActivity(intent)
        }

        getPerso()

    }

    fun updatePersonnes()
    {
        var liste = DatabaseClient.getAppDatabase(DatabaseClient.getInstance(this))
            .persoDao()
            .getAll()

        /********************************************Algérie***************************************************/
        var modified = liste.get(0)
        modified.setAvatar("https://fr.wikipedia.org/wiki/Hocine_Aït_Ahmed#/media/Fichier:Ait_ahmed_1958.jpg")
        modified.setDescription("Hocine Aït Ahmed, né le 20 août 1926 à Aït Yahia, dans l'actuelle wilaya de Tizi Ouzou, en Algérie, et mort le 23 décembre 2015 à Lausanne, en Suisse, est un homme politique algérien. Dès l'âge de 15 ans, il rejoint le Parti du peuple algérien, dont il devint rapidement un des dirigeants les plus en vue.")
        DatabaseClient.getAppDatabase(DatabaseClient.getInstance(this)).persoDao().update(modified)

        modified = liste.get(1)
        modified.setAvatar("https://upload.wikimedia.org/wikipedia/commons/c/ca/Idir_Hamid_Cheriet.JPG")
        modified.setDescription( "Idir, nom de scène d'Hamid Cheriet, né le 25 octobre 1945 à Ait Yenni en Algérie et mort le 2 mai 2020 à Paris, est un chanteur, auteur-compositeur-interprète et musicien algérien d'expression kabyle. Idir ne se destinait pas à la chanson.")
        DatabaseClient.getAppDatabase(DatabaseClient.getInstance(this)).persoDao().update(modified)
        /********************************************Tunisie***************************************************/
        modified = liste.get(2)
        modified.setAvatar("https://upload.wikimedia.org/wikipedia/commons/e/ef/Mommsen_p265.jpg")
        modified.setDescription("Hannibal Barca, généralement appelé Annibal ou Hannibal, né en 247 av. J.-C. à Carthage et mort entre 183 av. J.-C. et 181 av. J.-C. en Bithynie, est un général et homme politique carthaginois, généralement considéré comme l'un des plus grands tacticiens militaires de l'histoire.")
        DatabaseClient.getAppDatabase(DatabaseClient.getInstance(this)).persoDao().update(modified)

        modified = liste.get(3)
        modified.setAvatar("https://upload.wikimedia.org/wikipedia/commons/c/c4/PortraitHabibaGhribiLondres2012.jpg")
        modified.setDescription("Habiba Ghribi, née le 9 avril 1984 à Kairouan, est une athlète tunisienne, spécialiste des courses de fond et de demi-fond. À la suite de la disqualification de la Russe Yuliya Zaripova pour dopage en mars 2016, elle est championne du monde 2011 et championne olympique 2012 sur le 3 000 m steeple.")
        DatabaseClient.getAppDatabase(DatabaseClient.getInstance(this)).persoDao().update(modified)
        /********************************************Inde***************************************************/
        modified = liste.get(4)
        modified.setAvatar("https://upload.wikimedia.org/wikipedia/commons/7/7a/Mahatma-Gandhi%2C_studio%2C_1931.jpg")
        modified.setDescription("Mohandas Karamchand Gandhi, né à Porbandar le 2 octobre 1869 et mort assassiné à Delhi le 30 janvier 1948, est un dirigeant politique, important guide spirituel de l'Inde et du mouvement pour l'indépendance de ce pays.")
        DatabaseClient.getAppDatabase(DatabaseClient.getInstance(this)).persoDao().update(modified)

        modified = liste.get(5)
        modified.setAvatar("https://upload.wikimedia.org/wikipedia/commons/6/69/Akbar.jpg")
        modified.setDescription("Jalâluddin Muhammad Akbar dirige l'Empire moghol de 1556 jusqu'en 1605. Il est généralement considéré comme le plus grand — akbar en arabe — Moghol.")
        DatabaseClient.getAppDatabase(DatabaseClient.getInstance(this)).persoDao().update(modified)

        /********************************************Angletterre***************************************************/
        modified = liste.get(6)
        modified.setAvatar("https://upload.wikimedia.org/wikipedia/commons/5/5e/Diana%2C_Princess_of_Wales_1997_%282%29.jpg")
        modified.setDescription("Diana Spencer, dite Lady Di, née le 1ᵉʳ juillet 1961 à Sandringham et morte le 31 août 1997 à Paris, est une aristocrate anglaise, membre de la famille royale britannique. Elle épouse en 1981 Charles, prince de Galles, avec qui elle a deux enfants : William, en 1982, et Henry, en 1984.")
        DatabaseClient.getAppDatabase(DatabaseClient.getInstance(this)).persoDao().update(modified)

        modified = liste.get(7)
        modified.setAvatar("https://upload.wikimedia.org/wikipedia/commons/a/a1/Alan_Turing_Aged_16.jpg")
        modified.setDescription("Alan Mathison Turing, né le 23 juin 1912 à Londres et mort le 7 juin 1954 à Wilmslow, est un mathématicien et cryptologue britannique, auteur de travaux qui fondent scientifiquement l'informatique.")
        DatabaseClient.getAppDatabase(DatabaseClient.getInstance(this)).persoDao().update(modified)
        /********************************************Etat unis***************************************************/
        modified = liste.get(8)
        modified.setAvatar("https://upload.wikimedia.org/wikipedia/commons/c/c4/Rosaparks.jpg")
        modified.setDescription("Rosa Louise McCauley Parks, dite Rosa Parks [ɹoʊzə pɑɹks]1, née le 4 février 1913 à Tuskegee en Alabama et morte le 24 octobre 2005 à Détroit dans le Michigan, est une femme afro-américaine, figure emblématique de la lutte contre la ségrégation raciale aux États-Unis, surnommée « mère du mouvement des droits civiques » par le Congrès américain.")
        DatabaseClient.getAppDatabase(DatabaseClient.getInstance(this)).persoDao().update(modified)

        modified = liste.get(9)
        modified.setAvatar("https://upload.wikimedia.org/wikipedia/commons/6/6e/Bobby_Dixon_Fenerbahçe_Basketball_Media_Day_20180925_%283%29_%28cropped%29.jpg")
        modified.setDescription("Bobby Dixon, né le 10 avril 1983 à Chicago est un joueur américano-turc de basket-ball. Il joue sous le nom d'Ali Muhammed en Turquie en 2015 pour disputer l'Euro 2015. Mesurant 1,78 mètre, il évolue au poste de meneur de jeu.")
        DatabaseClient.getAppDatabase(DatabaseClient.getInstance(this)).persoDao().update(modified)

        /********************************************Egypte***************************************************/
        modified = liste.get(10)
        modified.setAvatar("https://upload.wikimedia.org/wikipedia/commons/1/1c/Ahmad_shawqy.jpg")
        modified.setDescription("Ahmed Chawqi (1868 - 14 octobre 1932) (arabe : أحمد شوقي) est un poète et dramaturge égyptien. Considéré comme l'un des pionniers de la littérature arabe moderne, il a notamment introduit les épopées en littérature arabe. Il a aussi composé une poésie unique, largement considérée comme la plus importante du mouvement littéraire arabe du xxe siècle. Il est surnommé \"le prince des poètes\".")
        DatabaseClient.getAppDatabase(DatabaseClient.getInstance(this)).persoDao().update(modified)

        modified = liste.get(11)
        modified.setAvatar("https://upload.wikimedia.org/wikipedia/commons/9/90/Retrato_femenino_%2826771127162%29.jpg")
        modified.setDescription("Cléopâtre VII Philopator, « Qui aime son père », puis Théa Néôtera Philopatris, « Déesse nouvelle qui aime sa patrie », est une reine d'Égypte antique de la dynastie lagide née vers -69 et morte le 12 août 30 av. J.-C")
        DatabaseClient.getAppDatabase(DatabaseClient.getInstance(this)).persoDao().update(modified)

        /********************************************Brésil***************************************************/
        modified = liste.get(12)
        modified.setAvatar("https://upload.wikimedia.org/wikipedia/commons/5/54/Pele_by_John_Mathew_Smith.jpg")
        modified.setDescription("Edson Arantes do Nascimento2,3, dit Pelé, ONM • ORB • KBE, né le 23 octobre 1940 à Três Corações (Brésil, État du Minas Gerais), est un footballeur brésilien évoluant au poste d'attaquant et de meneur de jeu du milieu des années 1950 au milieu des années 1970. Il est également acteur, scénariste et producteur.")
        DatabaseClient.getAppDatabase(DatabaseClient.getInstance(this)).persoDao().update(modified)

        modified = liste.get(13)
        modified.setAvatar("https://upload.wikimedia.org/wikipedia/commons/b/b0/Ronaldo_Nazário.jpg")
        modified.setDescription("Ronaldo Luís Nazário de Lima, dit Ronaldo, né le 22 septembre 1976 à Bento Ribeiro, un quartier de Rio de Janeiro, est un footballeur international brésilien, qui évoluait au poste d'avant-centre.")
        DatabaseClient.getAppDatabase(DatabaseClient.getInstance(this)).persoDao().update(modified)


    }

    private fun ajouterPerson() {
        class SaveTask : AsyncTask<Void?, Void?, Void?>() {

            override fun doInBackground(vararg voids: Void?): Void? {
                //creating a task

                /********************************************Algérie***************************************************/
                var perso1 : PersoPays = PersoPays()
                perso1.setNomPerso("AIT AHMED")
                perso1.setPrenomPerso("Hocine")
                perso1.setAvatar("https://fr.wikipedia.org/wiki/Hocine_Aït_Ahmed#/media/Fichier:Ait_ahmed_1958.jpg")
                perso1.setDescription("Hocine Aït Ahmed, né le 20 août 1926 à Aït Yahia, dans l'actuelle wilaya de Tizi Ouzou, en Algérie, et mort le 23 décembre 2015 à Lausanne, en Suisse, est un homme politique algérien. Dès l'âge de 15 ans, il rejoint le Parti du peuple algérien, dont il devint rapidement un des dirigeants les plus en vue.")
                perso1.setPaysId(1)


                var perso2 : PersoPays = PersoPays()
                perso2.setNomPerso("CHERIET ")
                perso2.setPrenomPerso("Hamid - Idir")
                perso2.setAvatar("https://upload.wikimedia.org/wikipedia/commons/c/ca/Idir_Hamid_Cheriet.JPG")
                perso2.setDescription( "Idir, nom de scène d'Hamid Cheriet, né le 25 octobre 1945 à Ait Yenni en Algérie et mort le 2 mai 2020 à Paris, est un chanteur, auteur-compositeur-interprète et musicien algérien d'expression kabyle. Idir ne se destinait pas à la chanson.")
                perso2.setPaysId(1)
                /********************************************Tunisie***************************************************/
                var perso3 : PersoPays = PersoPays()
                perso3.setNomPerso("BARCA")
                perso3.setPrenomPerso("Hannibal")
                perso3.setAvatar("https://upload.wikimedia.org/wikipedia/commons/e/ef/Mommsen_p265.jpg")
                perso3.setDescription("Hannibal Barca, généralement appelé Annibal ou Hannibal, né en 247 av. J.-C. à Carthage et mort entre 183 av. J.-C. et 181 av. J.-C. en Bithynie, est un général et homme politique carthaginois, généralement considéré comme l'un des plus grands tacticiens militaires de l'histoire.")
                perso3.setPaysId(2)

                var perso4 : PersoPays = PersoPays()
                perso4.setNomPerso("GHribi")
                perso4.setPrenomPerso("Habiba")
                perso4.setAvatar("https://upload.wikimedia.org/wikipedia/commons/c/c4/PortraitHabibaGhribiLondres2012.jpg")
                perso4.setDescription("Habiba Ghribi, née le 9 avril 1984 à Kairouan, est une athlète tunisienne, spécialiste des courses de fond et de demi-fond. À la suite de la disqualification de la Russe Yuliya Zaripova pour dopage en mars 2016, elle est championne du monde 2011 et championne olympique 2012 sur le 3 000 m steeple.")
                perso4.setPaysId(2)
                /********************************************Inde***************************************************/
                var perso5 : PersoPays = PersoPays()
                perso5.setNomPerso("GHANDI")
                perso5.setPrenomPerso("Mahatma")
                perso5.setAvatar("https://upload.wikimedia.org/wikipedia/commons/7/7a/Mahatma-Gandhi%2C_studio%2C_1931.jpg")
                perso5.setDescription("Mohandas Karamchand Gandhi, né à Porbandar le 2 octobre 1869 et mort assassiné à Delhi le 30 janvier 1948, est un dirigeant politique, important guide spirituel de l'Inde et du mouvement pour l'indépendance de ce pays.")
                perso5.setPaysId(3)

                var perso6 : PersoPays = PersoPays()
                perso6.setNomPerso("AKBAR")
                perso6.setPrenomPerso("Jalaluddin Muhammad")
                perso6.setAvatar("https://upload.wikimedia.org/wikipedia/commons/6/69/Akbar.jpg")
                perso6.setDescription("Jalâluddin Muhammad Akbar dirige l'Empire moghol de 1556 jusqu'en 1605. Il est généralement considéré comme le plus grand — akbar en arabe — Moghol.")
                perso6.setPaysId(3)

                /********************************************Angletterre***************************************************/
                var perso7 : PersoPays = PersoPays()
                perso7.setNomPerso("SPENCER")
                perso7.setPrenomPerso("Diana")
                perso7.setAvatar("https://upload.wikimedia.org/wikipedia/commons/5/5e/Diana%2C_Princess_of_Wales_1997_%282%29.jpg")
                perso7.setDescription("Diana Spencer, dite Lady Di, née le 1ᵉʳ juillet 1961 à Sandringham et morte le 31 août 1997 à Paris, est une aristocrate anglaise, membre de la famille royale britannique. Elle épouse en 1981 Charles, prince de Galles, avec qui elle a deux enfants : William, en 1982, et Henry, en 1984.")
                perso7.setPaysId(4)

                var perso8 : PersoPays = PersoPays()
                perso8.setNomPerso("TURING")
                perso8.setPrenomPerso("Alan")
                perso8.setAvatar("https://upload.wikimedia.org/wikipedia/commons/a/a1/Alan_Turing_Aged_16.jpg")
                perso8.setDescription("Alan Mathison Turing, né le 23 juin 1912 à Londres et mort le 7 juin 1954 à Wilmslow, est un mathématicien et cryptologue britannique, auteur de travaux qui fondent scientifiquement l'informatique.")
                perso8.setPaysId(4)
                /********************************************Etat unis***************************************************/
                var perso9 : PersoPays = PersoPays()
                perso9.setNomPerso("PARKS")
                perso9.setPrenomPerso("Rosa")
                perso9.setAvatar("https://upload.wikimedia.org/wikipedia/commons/c/c4/Rosaparks.jpg")
                perso9.setDescription("Rosa Louise McCauley Parks, dite Rosa Parks [ɹoʊzə pɑɹks]1, née le 4 février 1913 à Tuskegee en Alabama et morte le 24 octobre 2005 à Détroit dans le Michigan, est une femme afro-américaine, figure emblématique de la lutte contre la ségrégation raciale aux États-Unis, surnommée « mère du mouvement des droits civiques » par le Congrès américain.")
                perso9.setPaysId(5)

                var perso10: PersoPays = PersoPays()
                perso10.setNomPerso("ALI")
                perso10.setPrenomPerso("Muhammad")
                perso10.setAvatar("https://upload.wikimedia.org/wikipedia/commons/6/6e/Bobby_Dixon_Fenerbahçe_Basketball_Media_Day_20180925_%283%29_%28cropped%29.jpg")
                perso10.setDescription("Bobby Dixon, né le 10 avril 1983 à Chicago est un joueur américano-turc de basket-ball. Il joue sous le nom d'Ali Muhammed en Turquie en 2015 pour disputer l'Euro 2015. Mesurant 1,78 mètre, il évolue au poste de meneur de jeu.")
                perso10.setPaysId(5)
                /********************************************Egypte***************************************************/

                var perso11 : PersoPays = PersoPays()
                perso11.setNomPerso("CHAWQI")
                perso11.setPrenomPerso("Ahmed")
                perso11.setAvatar("https://upload.wikimedia.org/wikipedia/commons/1/1c/Ahmad_shawqy.jpg")
                perso11.setDescription("Ahmed Chawqi (1868 - 14 octobre 1932) (arabe : أحمد شوقي) est un poète et dramaturge égyptien. Considéré comme l'un des pionniers de la littérature arabe moderne, il a notamment introduit les épopées en littérature arabe. Il a aussi composé une poésie unique, largement considérée comme la plus importante du mouvement littéraire arabe du xxe siècle. Il est surnommé \"le prince des poètes\".")
                perso11.setPaysId(6)

                var perso12: PersoPays = PersoPays()
                perso12.setNomPerso("PHILOPATOR")
                perso12.setPrenomPerso("Cléopatre")
                perso12.setAvatar("https://upload.wikimedia.org/wikipedia/commons/9/90/Retrato_femenino_%2826771127162%29.jpg")
                perso12.setDescription("Cléopâtre VII Philopator, « Qui aime son père », puis Théa Néôtera Philopatris, « Déesse nouvelle qui aime sa patrie », est une reine d'Égypte antique de la dynastie lagide née vers -69 et morte le 12 août 30 av. J.-C")
                perso12.setPaysId(6)
                /********************************************Brésil***************************************************/
                var perso13 : PersoPays = PersoPays()
                perso13.setNomPerso("PÉLÉ")
                perso13.setPrenomPerso("Ederson")
                perso13.setAvatar("https://upload.wikimedia.org/wikipedia/commons/5/54/Pele_by_John_Mathew_Smith.jpg")
                perso13.setDescription("Edson Arantes do Nascimento2,3, dit Pelé, ONM • ORB • KBE, né le 23 octobre 1940 à Três Corações (Brésil, État du Minas Gerais), est un footballeur brésilien évoluant au poste d'attaquant et de meneur de jeu du milieu des années 1950 au milieu des années 1970. Il est également acteur, scénariste et producteur.")
                perso13.setPaysId(7)

                var perso14: PersoPays = PersoPays()
                perso14.setNomPerso("RONALDO")
                perso14.setPrenomPerso("Luis")
                perso14.setAvatar("https://upload.wikimedia.org/wikipedia/commons/b/b0/Ronaldo_Nazário.jpg")
                perso14.setDescription("Ronaldo Luís Nazário de Lima, dit Ronaldo, né le 22 septembre 1976 à Bento Ribeiro, un quartier de Rio de Janeiro, est un footballeur international brésilien, qui évoluait au poste d'avant-centre.")
                perso14.setPaysId(7)




                //adding to database
                DatabaseClient.getAppDatabase(DatabaseClient.getInstance(applicationContext))
                    .persoDao()
                    .insert(perso1)

                DatabaseClient.getAppDatabase(DatabaseClient.getInstance(applicationContext))
                    .persoDao()
                    .insert(perso2)
                DatabaseClient.getAppDatabase(DatabaseClient.getInstance(applicationContext))
                    .persoDao()
                    .insert(perso3)
                DatabaseClient.getAppDatabase(DatabaseClient.getInstance(applicationContext))
                    .persoDao()
                    .insert(perso4)
                DatabaseClient.getAppDatabase(DatabaseClient.getInstance(applicationContext))
                    .persoDao()
                    .insert(perso5)
                DatabaseClient.getAppDatabase(DatabaseClient.getInstance(applicationContext))
                    .persoDao()
                    .insert(perso6)
                DatabaseClient.getAppDatabase(DatabaseClient.getInstance(applicationContext))
                    .persoDao()
                    .insert(perso7)
                DatabaseClient.getAppDatabase(DatabaseClient.getInstance(applicationContext))
                    .persoDao()
                    .insert(perso8)
                DatabaseClient.getAppDatabase(DatabaseClient.getInstance(applicationContext))
                    .persoDao()
                    .insert(perso9)
                DatabaseClient.getAppDatabase(DatabaseClient.getInstance(applicationContext))
                    .persoDao()
                    .insert(perso10)
                DatabaseClient.getAppDatabase(DatabaseClient.getInstance(applicationContext))
                    .persoDao()
                    .insert(perso11)
                DatabaseClient.getAppDatabase(DatabaseClient.getInstance(applicationContext))
                    .persoDao()
                    .insert(perso12)
                DatabaseClient.getAppDatabase(DatabaseClient.getInstance(applicationContext))
                    .persoDao()
                    .insert(perso13)
                DatabaseClient.getAppDatabase(DatabaseClient.getInstance(applicationContext))
                    .persoDao()
                    .insert(perso14)
                return null
            }

            override fun onPostExecute(aVoid: Void?) {
                super.onPostExecute(aVoid)
                // finish()
                Toast.makeText(applicationContext, "Saved", Toast.LENGTH_LONG).show()
            }
        }
        val st = SaveTask()
        st.execute()
    }

    private fun getPerso() {
        class GetTasks : AsyncTask<Void, Void?, List<PersoPays>>() {

            override fun doInBackground(vararg voids: Void): List<PersoPays> {
                Log.d("Sonthing","je suis dans l'historique n les pays agui ")
                val liste:List<PersoPays> = DatabaseClient.getAppDatabase(DatabaseClient.getInstance(applicationContext))
                    .persoDao()
                    .getAll()

                return liste
            }

            override fun onPostExecute(perso: List<PersoPays>) {
                super.onPostExecute(perso)
                var p : Pays
                Log.d("Sonthing","***************************************Personnes********************************************************************************************")
                for (p in perso)
                {
                    Log.d("Sonthing","\n\n\n\n\n id = "+  p.getId() +" "+p.getNomPerso()+ " "+ p.getPrenomPerso() + " " + p.getAvatar()+ " "+p.getDescription())
                }

            }
        }

        val gt = GetTasks()
        gt.execute()

    }

}