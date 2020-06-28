package com.example.geomob

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.geomob.DB_files.DataBase.DatabaseClient
import com.example.geomob.DB_files.Entity.ImagePays
import com.example.geomob.DB_files.Entity.VideoPays
import com.example.geomob.DB_files.HistoriquePays
import com.example.geomob.DB_files.Pays
import com.example.geomob.DB_files.PersoPays
import com.example.geomob.DB_files.RessourcePays

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       /** ajouterPays()**/
       getPays()
       /*** ajouterHsitorique()**/
        getHisto()
       /** ajouterPerson()**/
        getPerso()
      /**  ajouterRessource()**/
        getRessource()
        /**ajouterImage()**/
        getImages()
      /**  ajouterVideo()**/
        getVideos()
    }


    private fun ajouterPays() {
                class SaveTask : AsyncTask<Void?, Void?, Void?>() {

            override fun doInBackground(vararg voids: Void?): Void? {
                //creating a task
                var pays : Pays = Pays()
                pays.setNom("Tunisie")
                pays.setDescription(" un État d'Afrique du Nord bordé au nord et à l'est par la mer Méditerranée (1 566 kilomètres de côtes), à l'ouest par l'Algérie avec 965 kilomètres de frontière commune et au sud-sud-est par la Libye avec 459 kilomètres de frontière. Sa capitale Tunis est située dans le nord-est du pays, au fond du golfe du même nom. Plus de 30 % de la superficie du territoire est occupée par le désert du Sahara, le reste étant constitué de régions montagneuses et de plaines fertiles.")
                pays.setFlagUrl("https://fr.wikipedia.org/wiki/Drapeau_de_la_Tunisie#/media/Fichier:Flag_of_Tunisia.svg")
                pays.setSurface("163 610")
                pays.setPopulation("11,57")
                pays.setHymneUrl("https://fr.wikipedia.org/wiki/Fichier:Humat_al-Hima.ogg")


                var pays2 : Pays = Pays()
                pays2.setNom("Inde")
                pays2.setDescription("un pays d'Asie du Sud qui occupe la majeure partie du sous-continent indien. Sa capitale est New Delhi. L'Inde est le deuxième pays le plus peuplé et le septième pays le plus grand du monde. Le littoral indien s'étend sur plus de sept mille kilomètres. Le pays a des frontières communes avec le Pakistan au nord-ouest, la Chine au nord et à l'est-nord-est, le Népal au nord-est, le Bhoutan , le Bangladesh et la Birmanie à l'est-nord-est. Sur l'océan Indien, l'Inde est à proximité des Maldives au sud-sud-ouest, du Sri Lanka au sud et de l'Indonésie au sud-est. L'Inde revendique également une frontière avec l'Afghanistan au nord-ouest. L'Inde dispose de l'arme nucléaire depuis 1974 après avoir fait des essais officiels.")
                pays2.setFlagUrl("https://fr.wikipedia.org/wiki/Inde#/media/Fichier:Flag_of_India.svg")
                pays2.setSurface("3 287 263")
                pays2.setPopulation("1 353")
                pays2.setHymneUrl("https://upload.wikimedia.org/wikipedia/commons/9/94/Jana_Gana_Mana_instrumental.ogg")

                var pays3 : Pays = Pays()
                pays3.setNom("Angleterre")
                pays3.setDescription("une nation constitutive du Royaume-Uni1. Elle est bordée par l'Écosse au nord et le pays de Galles à l'ouest. Son littoral est entouré par la mer du Nord à l'est, la mer d'Irlande au nord-ouest, la mer Celtique au sud-ouest, et la Manche au sud qui la sépare de l'Europe continentale. Son territoire couvre la majorité du centre et du sud de l'île de Grande-Bretagne, et il inclut également une centaine de petites îles. Sa capitale est Londres qui est la première aire urbaine du Royaume-Uni et, selon les critères retenus, d'Europe de l'Ouest2. Le nom d'« Angleterre » est fréquemment mais faussement employé, par synecdoque, pour désigner le Royaume-Uni dans son ensemble.")
                pays3.setFlagUrl("https://fr.wikipedia.org/wiki/Angleterre#/media/Fichier:Flag_of_England.svg")
                pays3.setSurface("130 395")
                pays3.setPopulation("55,012")
                pays3.setHymneUrl("https://upload.wikimedia.org/wikipedia/commons/d/de/United_States_Navy_Band_-_God_Save_the_Queen.ogg")

                var pays4 : Pays = Pays()
                pays4.setNom("États-Unis")
                pays4.setDescription("un pays transcontinental dont l'essentiel du territoire se situe en Amérique du Nord. Les États-Unis ont la structure politique d'une république constitutionnelle fédérale à régime présidentiel composée de cinquante États, dont quarante-huit sont adjacents et forment le Mainland. Celui-ci est encadré par l'océan Atlantique à l'est, le golfe du Mexique au sud-est et l'océan Pacifique à l'ouest, et se trouve bordé au nord par le Canada et au sud-ouest par le Mexique. Les deux États non limitrophes sont l'Alaska, situé au nord-ouest du Canada, et Hawaï, un archipel situé au milieu de l'océan Pacifique-nord. De plus, le pays comprend quatorze territoires insulaires disséminés dans la mer des Caraïbes et le Pacifique")
                pays4.setFlagUrl("https://fr.wikipedia.org/wiki/Drapeau_des_États-Unis#/media/Fichier:Flag_of_the_United_States.svg")
                pays4.setSurface("9 833 517")
                pays4.setPopulation("328,2")
                pays4.setHymneUrl("https://commons.wikimedia.org/w/index.php?title=File%3AStar_Spangled_Banner_instrumental.ogg")


                var pays5 : Pays = Pays()
                pays5.setNom("Égypte")
                pays5.setDescription("un pays se trouvant en Afrique du Nord-Est et, pour la péninsule du Sinaï, en Asie de l'Ouest. Située sur la côte sud de la Méditerranée orientale, le bassin Levantin, l'actuelle Égypte occupe l'espace géographique qui fut autrefois celui de l'Égypte antique.")
                pays5.setFlagUrl("https://fr.wikipedia.org/wiki/Égypte#/media/Fichier:Flag_of_Egypt.svg")
                pays5.setSurface("1 001 450")
                pays5.setPopulation("98,42")
                pays5.setHymneUrl("https://commons.wikimedia.org/w/index.php?title=File%3ABilady%2C_Bilady%2C_Bilady.ogg")

                var pays6 : Pays = Pays()
                pays6.setNom("Brésil")
                pays6.setDescription("le plus grand État d’Amérique latine. Le Brésil est le cinquième plus grand pays de la planète, derrière la Russie, le Canada, les États-Unis et la Chine. Avec une superficie de 8 514 876 km2, le pays couvre près de la moitié du territoire de l'Amérique du Sud (47,3 %)4, partageant des frontières avec l'Uruguay et l'Argentine au sud, le Paraguay au sud-sud-ouest, la Bolivie à l'ouest-sud-ouest, le Pérou à l'ouest, la Colombie à l'ouest-nord-ouest, le Venezuela au nord-ouest, le Guyana au nord-nord-ouest, le Suriname et la France au nord (par la Guyane), soit la plupart des pays du continent sauf le Chili et l'Équateur. Le pays compte une population de 209 millions d'habitants. Ancienne colonie portugaise, le Brésil a pour langue officielle le portugais alors que la plupart des pays d'Amérique latine ont pour langue officielle l'espagnol.")
                pays6.setFlagUrl("https://fr.wikipedia.org/wiki/Drapeau_du_Brésil#/media/Fichier:Flag_of_Brazil.svg")
                pays6.setSurface("8 514 876")
                pays6.setPopulation("209,5")
                pays6.setHymneUrl("https://commons.wikimedia.org/w/index.php?title=File%3AHino-Nacional-Brasil-instrumental-mec.ogg")




                //adding to database
                DatabaseClient.getAppDatabase(DatabaseClient.getInstance(applicationContext))
                    .paysDao()
                    .insert(pays)

                DatabaseClient.getAppDatabase(DatabaseClient.getInstance(applicationContext))
                    .paysDao()
                    .insert(pays2)

                DatabaseClient.getAppDatabase(DatabaseClient.getInstance(applicationContext))
                    .paysDao()
                    .insert(pays3)

                DatabaseClient.getAppDatabase(DatabaseClient.getInstance(applicationContext))
                    .paysDao()
                    .insert(pays4)

                DatabaseClient.getAppDatabase(DatabaseClient.getInstance(applicationContext))
                    .paysDao()
                    .insert(pays5)

                DatabaseClient.getAppDatabase(DatabaseClient.getInstance(applicationContext))
                    .paysDao()
                    .insert(pays6)
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
    private fun getPays() {
        class GetTasks : AsyncTask<Void, Void?, List<Pays>>() {

            override fun doInBackground(vararg voids: Void): List<Pays> {
                val liste:List<Pays> = DatabaseClient.getAppDatabase(DatabaseClient.getInstance(applicationContext))
                    .paysDao()
                    .getAll()
                return liste
            }

            override fun onPostExecute(pays: List<Pays>) {
                super.onPostExecute(pays)
                Log.d("Sonthing","*********************************************Les pays**********************************************************")
                var p :Pays
                for (p in pays )
                {
                    Log.d("Sonthing","\n\n\n\n\n id = "+  p.getId() +" "+p.getNom()+ " "+ p.getDescription() +  " "+ p.getIsExplored() + " "+ p.getPopulation() + " "+ p.getSurface() + " "+ p.getFlagUrl() + " "+ p.getHymneUrl())
                }

            }
        }
        val gt = GetTasks()
        gt.execute()

    }

    private fun ajouterHsitorique() {
        class SaveTask : AsyncTask<Void?, Void?, Void?>() {

            override fun doInBackground(vararg voids: Void?): Void? {
                //creating a task

                /********************************************Algérie***************************************************/
                var histo1:HistoriquePays= HistoriquePays()
                histo1.setDate("264 av. J.-C.")
                histo1.setDescription("Les États indépendants de la Numidie commencent avec l’émergence des deux confédérations massyles et massæsyles70. La première est à l’origine de la Numidie Orientale, la seconde de l’Occidentale. Ces deux tribus s'affrontèrent durant la deuxième guerre punique, où Massinissa, chef des Massyles, contribua de façon décisive à la victoire de l'Empire romain sur Carthage. Durant le règne de Massinissa, il parvint à unifier la Numidie, qui s'étendit alors du fleuve Moulouya à l'Ouest jusqu'à la Cyrénaïque à l'Est71.")
                histo1.setPaysId(1)


                var histo2:HistoriquePays= HistoriquePays()
                histo2.setDate("665-708")
                histo2.setDescription("De 644 à 656, la première tribu berbère algérienne à se convertir à l'islam fut les Maghraoua. Leur chef, Ouezmar Ibn Saclab, fut sollicité par le calife Othmân ibn Affân à embrasser la religion musulmane, selon l'historien du Moyen Âge, Ibn Khaldoun.De 688 à 708, Dihya procéda ainsi à la réunification de nombreuses tribus de l'Afrique du Nord orientale et du Sud. Dihya défait par deux fois la grande armée des Omeyyades grâce à l'apport des cavaliers Banou Ifren et des autres confédérations. Elle règnera sur tout l'Ifriqiya pendant cinq années. Dihia sera vaincue dans la dernière bataille contre les Omeyyades")
                histo2.setPaysId(1)

                var histo3:HistoriquePays= HistoriquePays()
                histo3.setDate("1830-1964")
                histo3.setDescription("Au début de la conquête en 1830, l'Algérie connut un afflux important de colons européens (essentiellement français et espagnols) que l'on appellera bientôt pieds-noirs. En 1834, l'Algérie est annexée à la France. l'Algérie devient aisni une  colonie française depuis, La guerre commence le 1er novembre 1954, après la réunion à Alger des six chefs du Front de libération nationale (Algérie) et anciens membres de l'Organisation spéciale, bras armé du Mouvement pour le triomphe des libertés démocratiques et aussi responsables du Comité révolutionnaire d'unité et d'action, et après la déclaration du 1er novembre 1954.Le 19 mars 1962, après la signature du cessez-le-feu, le conflit prend officiellement fin. Un double référendum est organisé le 8 janvier 1961 et le 8 avril 1962 :  ")
                histo3.setPaysId(1)

                /********************************************Tunisie***************************************************/


                var histo4:HistoriquePays= HistoriquePays()
                histo4.setDate("1881-1958")
                histo4.setDescription("Le protectorat français de Tunisie (الحماية الفرنسية في تونس soit Al-Ḥimāyah Al-Fransīyyah fī Tūnis) est institué par le traité du Bardo du 12 mai 1881 au terme d’une rapide conquête militaire. La souveraineté tunisienne est réduite à néant dès 1883, le bey se contentant de signer les décrets et lois préparés par le résident général de France en Tunisie.L’occupation du pays en 1942 par l’armée allemande et la déposition forcée de Moncef Bey en 1943 par les autorités françaises renforcent l’exaspération de la population. Aux termes de trois ans de guérilla, l’autonomie interne est accordée en 1955. Le protectorat est finalement aboli le 20 mars 1956.")
                histo4.setPaysId(2)


                /********************************************Inde***************************************************/
                var histo5:HistoriquePays= HistoriquePays()
                histo5.setDate("1757-1947")
                histo5.setDescription("L'expression « Inde britannique » (« British India ») désigne communément la partie du sous-continent indien placée sous la domination britannique de 1757 à 1947.Si la domination britannique s'étend de 1757 à 1947, date de l'indépendance de l'Inde, les Britanniques étaient présents dans certaines parties de l'Inde dès 1600, avec la création de la Compagnie britannique des Indes")
                histo5.setPaysId(3)

                var histo6:HistoriquePays= HistoriquePays()
                histo6.setDate("1526-1857")
                histo6.setDescription("L'Empire moghol  est fondé en Inde par Babur, le descendant de Tamerlan, en 1526, lorsqu'il défait Ibrahim Lodi, le dernier sultan de Delhi à la bataille de Pânipat")
                histo6.setPaysId(3)
                /********************************************Angletterre***************************************************/
                var histo10:HistoriquePays= HistoriquePays()
                histo10.setDate("43-410")
                histo10.setDescription("L'Empire romain conquiert l’Angleterre en 43 apr. J.-C., pendant le règne de l’empereur Claude, et la région est annexée à l’Empire romain, sous le nom de Bretagne28. Les plus connus des peuples qui ont tenté de résister à l’invasion sont les Catuvellauni, menés par Caratacus. Le christianisme est pour la première fois introduit au début du iiie siècle, bien que cette origine soit contestée : on parle d’une introduction par l’intermédiaire soit de Joseph d'Arimathie, soit de saint Lucius36. Vers 410, les Romains se retirent de l’île à mesure de leur perte de puissance, pour défendre leurs frontières en Europe continentale")
                histo10.setPaysId(4)
                /********************************************Etat unis***************************************************/
                var histo7:HistoriquePays= HistoriquePays()
                histo7.setDate("1492-1775")
                histo7.setDescription("Christophe Colomb découvre le continent américain en 1492 puis explore l'actuelle Porto Rico l'année suivante. Au xvie siècle, les puissances européennes à la recherche du passage du Nord-Ouest et de richesses, naviguent puis s'installent le long du littoral atlantique. Ici se succèdent des colonies espagnoles, anglaises, françaises, néerlandaises et scandinaves plus ou moins permanentes.")
                histo7.setPaysId(5)
                /********************************************Egypte***************************************************/
                var histo8:HistoriquePays= HistoriquePays()
                histo8.setDate("1882-1952")
                histo8.setDescription("Après la défaite d’Arabi Pacha, l’Égypte, qui dépend toujours théoriquement de l’Empire ottoman, se retrouve de fait sous la tutelle britannique. Des troupes anglaises sont stationnées en permanence dans le pays et des contrôleurs britanniques, placés sous l’autorité d’un représentant de Londres")
                histo8.setPaysId(6)
                /********************************************Brésil***************************************************/
                var histo9:HistoriquePays= HistoriquePays()
                histo9.setDate("1500-1815")
                histo9.setDescription("En 1815, est institué le Royaume uni de Portugal, du Brésil et des Algarves qui succède à la Vice-royauté du Brésil ((pt) Vice-reino do Brasil), qui prend fin entre 1822, année de l'indépendance, et 1825, année de la reconnaissance par Lisbonne du Brésil impérial.Contrairement aux anciennes colonies espagnoles voisines qui se sont fragmentées, l'ancienne colonie portugaise a gardé son intégrité territoriale et son unité linguistique après son indépendance, donnant lieu à la création du plus grand pays de la région, le Brésil.")
                histo9.setPaysId(7)




                //adding to database
                DatabaseClient.getAppDatabase(DatabaseClient.getInstance(applicationContext))
                    .historiqueDao()
                    .insert(histo1)

                DatabaseClient.getAppDatabase(DatabaseClient.getInstance(applicationContext))
                    .historiqueDao()
                    .insert(histo2)

                DatabaseClient.getAppDatabase(DatabaseClient.getInstance(applicationContext))
                    .historiqueDao()
                    .insert(histo3)

                DatabaseClient.getAppDatabase(DatabaseClient.getInstance(applicationContext))
                    .historiqueDao()
                    .insert(histo4)

                DatabaseClient.getAppDatabase(DatabaseClient.getInstance(applicationContext))
                    .historiqueDao()
                    .insert(histo5)

                DatabaseClient.getAppDatabase(DatabaseClient.getInstance(applicationContext))
                    .historiqueDao()
                    .insert(histo6)

                DatabaseClient.getAppDatabase(DatabaseClient.getInstance(applicationContext))
                    .historiqueDao()
                    .insert(histo7)

                DatabaseClient.getAppDatabase(DatabaseClient.getInstance(applicationContext))
                    .historiqueDao()
                    .insert(histo8)

                DatabaseClient.getAppDatabase(DatabaseClient.getInstance(applicationContext))
                    .historiqueDao()
                    .insert(histo9)

                DatabaseClient.getAppDatabase(DatabaseClient.getInstance(applicationContext))
                    .historiqueDao()
                    .insert(histo10)
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

    private fun getHisto() {
        class GetTasks : AsyncTask<Void, Void?, List<HistoriquePays>>() {

            override fun doInBackground(vararg voids: Void): List<HistoriquePays> {
                Log.d("Sonthing","je suis dans l'historique n les pays agui ")
                val liste:List<HistoriquePays> = DatabaseClient.getAppDatabase(DatabaseClient.getInstance(applicationContext))
                    .historiqueDao()
                    .getAll()

                return liste
            }

            override fun onPostExecute(histo: List<HistoriquePays>) {
                super.onPostExecute(histo)
                var p :Pays
                Log.d("Sonthing","***************************************Historique********************************************************************************************")
                for (p in histo )
                {
                    Log.d("Sonthing","\n\n\n\n\n id = "+  p.getId() +" "+p.getDate()+ " "+ p.getDescription() )
                }

            }
        }

        val gt = GetTasks()
        gt.execute()

    }
    private fun ajouterPerson() {
        class SaveTask : AsyncTask<Void?, Void?, Void?>() {

            override fun doInBackground(vararg voids: Void?): Void? {
                //creating a task

                /********************************************Algérie***************************************************/
                 var perso1 :PersoPays = PersoPays()
                 perso1.setNomPerso("AIT AHMED")
                 perso1.setPrenomPerso("Hocine")
                 perso1.setPaysId(1)


                var perso2 :PersoPays = PersoPays()
                perso2.setNomPerso("CHERIET ")
                perso2.setPrenomPerso("Hamid - Idir")
                perso2.setPaysId(1)
                /********************************************Tunisie***************************************************/
                var perso3 :PersoPays = PersoPays()
                perso3.setNomPerso("BARCA")
                perso3.setPrenomPerso("Hannibal")
                perso3.setPaysId(2)

                var perso4 :PersoPays = PersoPays()
                perso4.setNomPerso("GHribi")
                perso4.setPrenomPerso("Habiba")
                perso4.setPaysId(2)
                /********************************************Inde***************************************************/
                var perso5 :PersoPays = PersoPays()
                perso5.setNomPerso("GHANDI")
                perso5.setPrenomPerso("Mahatma")
                perso5.setPaysId(3)

                var perso6 :PersoPays = PersoPays()
                perso6.setNomPerso("AKBAR")
                perso6.setPrenomPerso("Jalaluddin Muhammad")
                perso6.setPaysId(3)

                /********************************************Angletterre***************************************************/
                var perso7 :PersoPays = PersoPays()
                perso7.setNomPerso("SPENCER")
                perso7.setPrenomPerso("Diana")
                perso7.setPaysId(4)

                var perso8 :PersoPays = PersoPays()
                perso8.setNomPerso("TURING")
                perso8.setPrenomPerso("Alan")
                perso8.setPaysId(4)
                /********************************************Etat unis***************************************************/
                var perso9 :PersoPays = PersoPays()
                perso9.setNomPerso("PARKS")
                perso9.setPrenomPerso("Rosa")
                perso9.setPaysId(5)

                var perso10:PersoPays = PersoPays()
                perso10.setNomPerso("ALI")
                perso10.setPrenomPerso("Muhammad")
                perso10.setPaysId(5)
                /********************************************Egypte***************************************************/

                var perso11 :PersoPays = PersoPays()
                perso11.setNomPerso("CHAWQI")
                perso11.setPrenomPerso("Ahmed")
                perso11.setPaysId(6)

                var perso12:PersoPays = PersoPays()
                perso12.setNomPerso("PHILOPATOR")
                perso12.setPrenomPerso("Cléopatre")
                perso12.setPaysId(6)
                /********************************************Brésil***************************************************/
                var perso13 :PersoPays = PersoPays()
                perso13.setNomPerso("PÉLÉ")
                perso13.setPrenomPerso("Ederson")
                perso13.setPaysId(7)

                var perso14:PersoPays = PersoPays()
                perso14.setNomPerso("RONALDO")
                perso14.setPrenomPerso("Luis")
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
                var p :Pays
                Log.d("Sonthing","***************************************Personnes********************************************************************************************")
                for (p in perso)
                {
                    Log.d("Sonthing","\n\n\n\n\n id = "+  p.getId() +" "+p.getNomPerso()+ " "+ p.getPrenomPerso() )
                }

            }
        }

        val gt = GetTasks()
        gt.execute()

    }

    private fun ajouterRessource() {
        class SaveTask : AsyncTask<Void?, Void?, Void?>() {

            override fun doInBackground(vararg voids: Void?): Void? {
                //creating a task

                /********************************************Algérie***************************************************/
                 var res1:RessourcePays = RessourcePays()
                res1.setNomRes("Petrole")
                res1.setTypeRes("Energétique")
                res1.setPaysId(1)

                var res2:RessourcePays = RessourcePays()
                res2.setNomRes("Gaz")
                res2.setTypeRes("Energétique")
                res2.setPaysId(1)
                /********************************************Tunisie***************************************************/
                var res3:RessourcePays = RessourcePays()
                res3.setNomRes("Phosphate")
                res3.setTypeRes("Minérale")
                res3.setPaysId(2)

                var res4:RessourcePays = RessourcePays()
                res4.setNomRes("Fer")
                res4.setTypeRes("Minérale")
                res4.setPaysId(2)
                /********************************************Inde***************************************************/
                var res5:RessourcePays = RessourcePays()
                res5.setNomRes("Terre Arable")
                res5.setTypeRes("Ecosystémique")
                res5.setPaysId(3)

                var res6:RessourcePays = RessourcePays()
                res6.setNomRes("Charbon")
                res6.setTypeRes("Energétique")
                res6.setPaysId(3)

                /********************************************Angletterre***************************************************/
                var res7:RessourcePays = RessourcePays()
                res7.setNomRes("Miel")
                res7.setTypeRes("Biologique")
                res7.setPaysId(4)

                var res8:RessourcePays = RessourcePays()
                res8.setNomRes("Lac")
                res8.setTypeRes("Ecosystémique")
                res8.setPaysId(4)

                /********************************************Etat unis***************************************************/
                var res9:RessourcePays = RessourcePays()
                res9.setNomRes("Charbon")
                res9.setTypeRes("Energétique")
                res9.setPaysId(5)

                var res10:RessourcePays = RessourcePays()
                res10.setNomRes("Bois")
                res10.setTypeRes("Ecosystémique")
                res10.setPaysId(5)
                /********************************************Egypte***************************************************/
                var res11:RessourcePays = RessourcePays()
                res11.setNomRes("Poisson")
                res11.setTypeRes("Halieutique")
                res11.setPaysId(6)

                var res12:RessourcePays = RessourcePays()
                res12.setNomRes("Soleil")
                res12.setTypeRes("Ecosystémique")
                res12.setPaysId(6)

                /********************************************Brésil***************************************************/
                var res13:RessourcePays = RessourcePays()
                res13.setNomRes("Bois")
                res13.setTypeRes("Ecosystémique")
                res13.setPaysId(7)

                var res14:RessourcePays = RessourcePays()
                res14.setNomRes("Or")
                res14.setTypeRes("Minérale")
                res14.setPaysId(7)




                //adding to database
                DatabaseClient.getAppDatabase(DatabaseClient.getInstance(applicationContext))
                    .ressourceDao()
                    .insert(res1)

                DatabaseClient.getAppDatabase(DatabaseClient.getInstance(applicationContext))
                    .ressourceDao()
                    .insert(res2)

                DatabaseClient.getAppDatabase(DatabaseClient.getInstance(applicationContext))
                    .ressourceDao()
                    .insert(res3)
                DatabaseClient.getAppDatabase(DatabaseClient.getInstance(applicationContext))
                    .ressourceDao()
                    .insert(res4)
                DatabaseClient.getAppDatabase(DatabaseClient.getInstance(applicationContext))
                    .ressourceDao()
                    .insert(res5)

                DatabaseClient.getAppDatabase(DatabaseClient.getInstance(applicationContext))
                    .ressourceDao()
                    .insert(res6)
                DatabaseClient.getAppDatabase(DatabaseClient.getInstance(applicationContext))
                    .ressourceDao()
                    .insert(res7)
                DatabaseClient.getAppDatabase(DatabaseClient.getInstance(applicationContext))
                    .ressourceDao()
                    .insert(res8)

                DatabaseClient.getAppDatabase(DatabaseClient.getInstance(applicationContext))
                    .ressourceDao()
                    .insert(res9)

                DatabaseClient.getAppDatabase(DatabaseClient.getInstance(applicationContext))
                    .ressourceDao()
                    .insert(res10)
                DatabaseClient.getAppDatabase(DatabaseClient.getInstance(applicationContext))
                    .ressourceDao()
                    .insert(res11)
                DatabaseClient.getAppDatabase(DatabaseClient.getInstance(applicationContext))
                    .ressourceDao()
                    .insert(res12)
                DatabaseClient.getAppDatabase(DatabaseClient.getInstance(applicationContext))
                    .ressourceDao()
                    .insert(res13)
                DatabaseClient.getAppDatabase(DatabaseClient.getInstance(applicationContext))
                    .ressourceDao()
                    .insert(res14)


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
    private fun getRessource() {
        class GetTasks : AsyncTask<Void, Void?, List<RessourcePays>>() {

            override fun doInBackground(vararg voids: Void): List<RessourcePays> {
                Log.d("Sonthing","je suis dans l'historique n les pays agui ")
                val liste:List<RessourcePays> = DatabaseClient.getAppDatabase(DatabaseClient.getInstance(applicationContext))
                    .ressourceDao()
                    .getAll()

                return liste
            }

            override fun onPostExecute(res: List<RessourcePays>) {
                super.onPostExecute(res)
                var p :Pays
                Log.d("Sonthing","***************************************Ressources********************************************************************************************")
                for (p in res)
                {
                    Log.d("Sonthing","\n\n\n\n\n id = "+  p.getId() +" "+p.getNomRes()+ " "+ p.getTypeRes() )
                }

            }
        }

        val gt = GetTasks()
        gt.execute()

    }




    private fun ajouterImage() {
        class SaveTask : AsyncTask<Void?, Void?, Void?>() {

            override fun doInBackground(vararg voids: Void?): Void? {
                //creating a task

                /********************************************Algérie***************************************************/
                var img1 :ImagePays= ImagePays()
                img1.setUrlImg("https://fr.wikipedia.org/wiki/Algérie#/media/Fichier:Botanical_Garden_Hamma.jpg")
                img1.setPaysId(1)

                var img2 :ImagePays= ImagePays()
                img2.setUrlImg("https://fr.wikipedia.org/wiki/Algérie#/media/Fichier:VueOran.JPG")
                img2.setPaysId(1)

                var img15 :ImagePays= ImagePays()
                img15.setUrlImg("https://fr.wikipedia.org/wiki/Algérie#/media/Fichier:Palais_des_Rais_(Es'hine)_-_Alger.JPG")
                img15.setPaysId(1)

                /********************************************Tunisie***************************************************/
                var img3 :ImagePays= ImagePays()
                img3.setUrlImg("https://fr.wikipedia.org/wiki/Tunisie#/media/Fichier:Dougga_Capitol.jpg")
                img3.setPaysId(2)

                var img4:ImagePays= ImagePays()
                img4.setUrlImg("https://fr.wikipedia.org/wiki/Tunisie#/media/Fichier:TUNISIE_MONASTIR_RIBAT_04.jpg")
                img4.setPaysId(2)

                var img16 :ImagePays= ImagePays()
                img16.setUrlImg("https://fr.wikipedia.org/wiki/Tunisie#/media/Fichier:Pont_Cinquième_de_Béja_-_Mai_2014_(3).JPG")
                img16.setPaysId(2)

                /********************************************Inde***************************************************/
                var img5 :ImagePays= ImagePays()
                img5.setUrlImg("https://fr.wikipedia.org/wiki/Inde#/media/Fichier:Andaman.jpg")
                img5.setPaysId(3)

                var img6 :ImagePays= ImagePays()
                img6.setUrlImg("https://fr.wikipedia.org/wiki/Inde#/media/Fichier:BangaloreInfosys.jpg")
                img6.setPaysId(3)

                var img17 :ImagePays= ImagePays()
                img17.setUrlImg("https://fr.wikipedia.org/wiki/Inde#/media/Fichier:TajMahalbyAmalMongia.jpg")
                img17.setPaysId(3)
                /********************************************Angletterre***************************************************/
                var img7 :ImagePays= ImagePays()
                img7.setUrlImg("https://fr.wikipedia.org/wiki/Angleterre#/media/Fichier:Stonehenge_(sun).jpg")
                img7.setPaysId(4)

                var img8 :ImagePays= ImagePays()
                img8.setUrlImg("https://fr.wikipedia.org/wiki/Angleterre#/media/Fichier:Canterbury_Cathedral_-_Portal_Nave_Cross-spire.jpeg")
                img8.setPaysId(4)

                var img18 :ImagePays= ImagePays()
                img18.setUrlImg("https://fr.wikipedia.org/wiki/Angleterre#/media/Fichier:Radcliffe_Camera,_Oxford_-_Oct_2006.jpg")
                img18.setPaysId(4)
                /********************************************Etat unis***************************************************/
                var img9 :ImagePays= ImagePays()
                img9.setUrlImg("https://fr.wikipedia.org/wiki/États-Unis#/media/Fichier:US_Capitol_Building_at_night_Jan_2006.jpg")
                img9.setPaysId(5)

                var img10 :ImagePays= ImagePays()
                img10.setUrlImg("https://fr.wikipedia.org/wiki/États-Unis#/media/Fichier:Dallas_Downtown.jpg")
                img10.setPaysId(5)

                var img19 :ImagePays= ImagePays()
                img19.setUrlImg("https://fr.wikipedia.org/wiki/États-Unis#/media/Fichier:The_Pentagon_January_2008.jpg")
                img19.setPaysId(5)
                /********************************************Egypte***************************************************/
                var img11 :ImagePays= ImagePays()
                img11.setUrlImg("https://fr.wikipedia.org/wiki/Égypte#/media/Fichier:Flickr_-_archer10_(Dennis)_-_Egypt-13A-098.jpg")
                img11.setPaysId(6)

                var img12 :ImagePays= ImagePays()
                img12.setUrlImg("https://fr.wikipedia.org/wiki/Égypte#/media/Fichier:Egypt.Giza.Sphinx.02.jpg")
                img12.setPaysId(6)

                var img20 :ImagePays= ImagePays()
                img20.setUrlImg("https://fr.wikipedia.org/wiki/Égypte#/media/Fichier:Madrasa_and_Khanqah_of_Sultan_Barquq.jpg")
                img20.setPaysId(6)
                /********************************************Brésil***************************************************/
                var img13 :ImagePays= ImagePays()
                img13.setUrlImg("https://fr.wikipedia.org/wiki/Brésil#/media/Fichier:Cidade_Maravilhosa.jpg")
                img13.setPaysId(7)

                var img14 :ImagePays= ImagePays()
                img14.setUrlImg("https://fr.wikipedia.org/wiki/Brésil#/media/Fichier:São_Paulo_city_(Bela_Vista).jpg")
                img14.setPaysId(7)

                var img21 :ImagePays= ImagePays()
                img21.setUrlImg("https://fr.wikipedia.org/wiki/Brésil#/media/Fichier:Cataratas.jpg")
                img21.setPaysId(7)





                //adding to database
                DatabaseClient.getAppDatabase(DatabaseClient.getInstance(applicationContext))
                    .imgDao()
                    .insert(img1)

                DatabaseClient.getAppDatabase(DatabaseClient.getInstance(applicationContext))
                    .imgDao()
                    .insert(img2)
                DatabaseClient.getAppDatabase(DatabaseClient.getInstance(applicationContext))
                    .imgDao()
                    .insert(img3)
                DatabaseClient.getAppDatabase(DatabaseClient.getInstance(applicationContext))
                    .imgDao()
                    .insert(img4)
                DatabaseClient.getAppDatabase(DatabaseClient.getInstance(applicationContext))
                    .imgDao()
                    .insert(img5)
                DatabaseClient.getAppDatabase(DatabaseClient.getInstance(applicationContext))
                    .imgDao()
                    .insert(img6)
                DatabaseClient.getAppDatabase(DatabaseClient.getInstance(applicationContext))
                    .imgDao()
                    .insert(img7)
                DatabaseClient.getAppDatabase(DatabaseClient.getInstance(applicationContext))
                    .imgDao()
                    .insert(img8)
                DatabaseClient.getAppDatabase(DatabaseClient.getInstance(applicationContext))
                    .imgDao()
                    .insert(img9)
                DatabaseClient.getAppDatabase(DatabaseClient.getInstance(applicationContext))
                    .imgDao()
                    .insert(img10)
                DatabaseClient.getAppDatabase(DatabaseClient.getInstance(applicationContext))
                    .imgDao()
                    .insert(img11)
                DatabaseClient.getAppDatabase(DatabaseClient.getInstance(applicationContext))
                    .imgDao()
                    .insert(img12)
                DatabaseClient.getAppDatabase(DatabaseClient.getInstance(applicationContext))
                    .imgDao()
                    .insert(img13)
                DatabaseClient.getAppDatabase(DatabaseClient.getInstance(applicationContext))
                    .imgDao()
                    .insert(img14)
                DatabaseClient.getAppDatabase(DatabaseClient.getInstance(applicationContext))
                    .imgDao()
                    .insert(img15)
                DatabaseClient.getAppDatabase(DatabaseClient.getInstance(applicationContext))
                    .imgDao()
                    .insert(img16)
                DatabaseClient.getAppDatabase(DatabaseClient.getInstance(applicationContext))
                    .imgDao()
                    .insert(img17)
                DatabaseClient.getAppDatabase(DatabaseClient.getInstance(applicationContext))
                    .imgDao()
                    .insert(img18)
                DatabaseClient.getAppDatabase(DatabaseClient.getInstance(applicationContext))
                    .imgDao()
                    .insert(img19)
                DatabaseClient.getAppDatabase(DatabaseClient.getInstance(applicationContext))
                    .imgDao()
                    .insert(img20)
                DatabaseClient.getAppDatabase(DatabaseClient.getInstance(applicationContext))
                    .imgDao()
                    .insert(img21)


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
    private fun getImages() {
        class GetTasks : AsyncTask<Void, Void?, List<ImagePays>>() {

            override fun doInBackground(vararg voids: Void): List<ImagePays> {
                Log.d("Sonthing","je suis dans l'historique n les pays agui ")
                val liste:List<ImagePays> = DatabaseClient.getAppDatabase(DatabaseClient.getInstance(applicationContext))
                    .imgDao()
                    .getAll()

                return liste
            }

            override fun onPostExecute(img: List<ImagePays>) {
                super.onPostExecute(img)
                var p :Pays
                Log.d("Sonthing","***************************************Images********************************************************************************************")
                for (p in img)
                {
                    Log.d("Sonthing","\n\n\n\n\n id = "+  p.getId() +" "+p.getUrlImg()+ " "+ p.getPaysId() )
                }

            }
        }

        val gt = GetTasks()
        gt.execute()

    }




    private fun ajouterVideo() {
        class SaveTask : AsyncTask<Void?, Void?, Void?>() {

            override fun doInBackground(vararg voids: Void?): Void? {
                //creating a task

                /********************************************Algérie***************************************************/
               var vid1:VideoPays= VideoPays()
                vid1.setIdVid("mYwNrsijp6g")
                vid1.setUrlVid("https://www.youtube.com/watch?v=mYwNrsijp6g")
                vid1.setPaysId(1)

                var vid2:VideoPays= VideoPays()
                vid2.setIdVid("XpVaA5MO9A8")
                vid2.setUrlVid("https://www.youtube.com/watch?v=XpVaA5MO9A8")
                vid2.setPaysId(1)
                /********************************************Tunisie***************************************************/
                var vid3:VideoPays= VideoPays()
                vid3.setIdVid("3nEJAXoB4Mo")
                vid3.setUrlVid("https://www.youtube.com/watch?v=3nEJAXoB4Mo")
                vid3.setPaysId(2)

                var vid4:VideoPays= VideoPays()
                vid4.setIdVid("RUC_hwINFMk")
                vid4.setUrlVid("https://www.youtube.com/watch?v=RUC_hwINFMk")
                vid4.setPaysId(2)
                /********************************************Inde***************************************************/
                var vid5:VideoPays= VideoPays()
                vid5.setIdVid("6EDjEIYtf-w")
                vid5.setUrlVid("https://www.youtube.com/watch?v=6EDjEIYtf-w")
                vid5.setPaysId(3)

                var vid6:VideoPays= VideoPays()
                vid6.setIdVid("IgAnj6r1O48")
                vid6.setUrlVid("https://www.youtube.com/watch?v=IgAnj6r1O48")
                vid6.setPaysId(3)
                /********************************************Angletterre***************************************************/
                var vid7:VideoPays= VideoPays()
                vid7.setIdVid("fUo5bqnJvbg")
                vid7.setUrlVid("https://www.youtube.com/watch?v=fUo5bqnJvbg")
                vid7.setPaysId(4)

                var vid8:VideoPays= VideoPays()
                vid8.setIdVid("oAJhBbdGskw")
                vid8.setUrlVid("https://www.youtube.com/watch?v=oAJhBbdGskw")
                vid8.setPaysId(4)
                /********************************************Etat unis***************************************************/
                var vid9:VideoPays= VideoPays()
                vid9.setIdVid("imWP-enTgAs")
                vid9.setUrlVid("https://www.youtube.com/watch?v=imWP-enTgAs")
                vid9.setPaysId(5)

                var vid10:VideoPays= VideoPays()
                vid10.setIdVid("_Bkhj8T1wns")
                vid10.setUrlVid("https://www.youtube.com/watch?v=_Bkhj8T1wns")
                vid10.setPaysId(5)
                /********************************************Egypte***************************************************/
                var vid11:VideoPays= VideoPays()
                vid11.setIdVid("fZS1NhykwG0")
                vid11.setUrlVid("https://www.youtube.com/watch?v=fZS1NhykwG0")
                vid11.setPaysId(6)

                var vid12:VideoPays= VideoPays()
                vid12.setIdVid("UzsPLn1ebb4")
                vid12.setUrlVid("https://www.youtube.com/watch?v=UzsPLn1ebb4")
                vid12.setPaysId(6)
                /********************************************Brésil***************************************************/
                var vid13:VideoPays= VideoPays()
                vid13.setIdVid("Vp12DfLs4z4")
                vid13.setUrlVid("https://www.youtube.com/watch?v=Vp12DfLs4z4")
                vid13.setPaysId(7)

                var vid14:VideoPays= VideoPays()
                vid14.setIdVid("O_W8ZbZC9Es")
                vid14.setUrlVid("https://www.youtube.com/watch?v=O_W8ZbZC9Es")
                vid14.setPaysId(7)





                //adding to database
                DatabaseClient.getAppDatabase(DatabaseClient.getInstance(applicationContext))
                    .videoDao()
                    .insert(vid1)
                DatabaseClient.getAppDatabase(DatabaseClient.getInstance(applicationContext))
                    .videoDao()
                    .insert(vid2)
                DatabaseClient.getAppDatabase(DatabaseClient.getInstance(applicationContext))
                    .videoDao()
                    .insert(vid3)
                DatabaseClient.getAppDatabase(DatabaseClient.getInstance(applicationContext))
                    .videoDao()
                    .insert(vid4)
                DatabaseClient.getAppDatabase(DatabaseClient.getInstance(applicationContext))
                    .videoDao()
                    .insert(vid5)
                DatabaseClient.getAppDatabase(DatabaseClient.getInstance(applicationContext))
                    .videoDao()
                    .insert(vid6)
                DatabaseClient.getAppDatabase(DatabaseClient.getInstance(applicationContext))
                    .videoDao()
                    .insert(vid7)
                DatabaseClient.getAppDatabase(DatabaseClient.getInstance(applicationContext))
                    .videoDao()
                    .insert(vid8)
                DatabaseClient.getAppDatabase(DatabaseClient.getInstance(applicationContext))
                    .videoDao()
                    .insert(vid9)
                DatabaseClient.getAppDatabase(DatabaseClient.getInstance(applicationContext))
                    .videoDao()
                    .insert(vid10)
                DatabaseClient.getAppDatabase(DatabaseClient.getInstance(applicationContext))
                    .videoDao()
                    .insert(vid11)
                DatabaseClient.getAppDatabase(DatabaseClient.getInstance(applicationContext))
                    .videoDao()
                    .insert(vid12)
                DatabaseClient.getAppDatabase(DatabaseClient.getInstance(applicationContext))
                    .videoDao()
                    .insert(vid13)
                DatabaseClient.getAppDatabase(DatabaseClient.getInstance(applicationContext))
                    .videoDao()
                    .insert(vid14)



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
    private fun getVideos() {
        class GetTasks : AsyncTask<Void, Void?, List<VideoPays>>() {

            override fun doInBackground(vararg voids: Void): List<VideoPays> {
                Log.d("Sonthing","je suis dans l'historique n les pays agui ")
                val liste:List<VideoPays> = DatabaseClient.getAppDatabase(DatabaseClient.getInstance(applicationContext))
                    .videoDao()
                    .getAll()

                return liste
            }

            override fun onPostExecute(vid: List<VideoPays>) {
                super.onPostExecute(vid)
                var p :Pays
                Log.d("Sonthing","***************************************Videos********************************************************************************************")
                for (p in vid)
                {
                    Log.d("Sonthing","\n\n\n\n\n id = "+  p.getId() +" "+p.getUrlVid()+ " "+ p.getPaysId() )
                }

            }
        }

        val gt = GetTasks()
        gt.execute()

    }



}
