package org.example.monstre

import org.example.dresseur.Entraineur
import kotlin.math.max
import kotlin.math.pow
import kotlin.random.Random


class IndividuMonstre(
    var id: Int, var nom: String,
    var espece: EspeceMonstre, var entraineur: Entraineur? = null,
    expInit: Double
) {
    var niveau: Int = 1
    var attaque: Int = espece.baseAttaque + Random.nextInt(-2, 2)
    var defense: Int = espece.baseDefense + Random.nextInt(-2, 2)
    var vitesse: Int = espece.baseVitesse + Random.nextInt(-2, 2)
    var attaqueSpe: Int = espece.baseAttaqueSpe + Random.nextInt(-2, 2)
    var defenseSpe: Int = espece.baseDefenseSpe + Random.nextInt(-2, 2)
    var pvMax: Int = espece.basePv + Random.nextInt(-5, 5)
    var potentiel: Double = Random.nextDouble(0.5, 2.0)
    var estNiveau1: Boolean = true
    var exp: Double = 0.0
        get() = field
        set(nouveauExp) {
            field = nouveauExp
                if (niveau == 1) {
                    estNiveau1 = true
                }
                else {
                    estNiveau1 = false
                }
                while (field >= palierExp(niveau)) {
                    levelUp()
                    if (estNiveau1 == true) {
                        println("Le monstre $nom est maintenant niveau $niveau")
                    }
                    if (niveau == 100) {
                        break
                    }
                }
            }
    var pv: Int = pvMax
        get() = field
        set(nouveauPv) {
            field = when {
                nouveauPv < 0 -> 0
                nouveauPv > pvMax -> pvMax
                else -> nouveauPv
            }
        }

    fun levelUp(){
        niveau ++

        attaque += (espece.modAttaque * potentiel).toInt() + Random.nextInt(-2, 2)
        defense += (espece.modDefense * potentiel).toInt() + Random.nextInt(-2, 2)
        vitesse += (espece.modVitesse * potentiel).toInt() + Random.nextInt(-2, 2)
        attaqueSpe += (espece.modAttaqueSpe * potentiel).toInt() + Random.nextInt(-2, 2)
        defenseSpe += (espece.modDefenseSpe * potentiel).toInt() + Random.nextInt(-2, 2)
        pvMax += (espece.modPv * potentiel).toInt() + Random.nextInt(-5, 5)
    }

    /**
    * @param niveau Niveau cible
    * @return Experience cumulee necessaire pour atteindre ce niveau
    */
    fun palierExp(niveau: Int): Double {
        return 100 * (niveau - 1).toDouble().pow(2.0)
    }

    init {
        this.exp = expInit // applique le setter et déclenche un éventuel level-up
    }

    fun attaquer(cible: IndividuMonstre) {
        /**
         * Attaque un autre [IndividuMonstre] et inflige des dégâts.
         *
         * Les dégâts sont calculés de manière très simple pour le moment :
         * `dégâts = attaque - (défense / 2)` (minimum 1 dégât).
         *
         * @param cible Monstre cible de l'attaque.
         */
        var degatBrut = this.attaque
        var degatTotal = degatBrut - (this.defense/2)
        if (degatTotal < 1) {
            degatTotal = 1
        }
        var pvAvant = cible.pv
        cible.pv -= degatTotal
        var pvApres = cible.pv
        println("$nom inflige ($pvAvant -> $pvApres) degats a ${cible.nom}")
    }

    fun renommer() {
        print("Renommer ${this.nom} ? ")
        var nouveauNom = readln().toString()
        if (nouveauNom != "") {
            this.nom = nouveauNom
            println("Le monstre est renommé ${this.nom}")
        }
        else {
            println("Le monstre se nomme toujours ${this.nom}")
        }
    }

    fun afficheDetail() {
        var art = espece.afficheArt()
        println(art)
        val artLines = art.lines()

        val details = listOf(
            "nom = $nom",
            "niveau = $niveau",
            "PV = $pv",
            "stats = ${listOf("atq : ${espece.baseAttaque}, Def : ${espece.baseDefense}, Vit : ${espece.baseVitesse}, AtqSpe : ${espece.baseAttaqueSpe}, DefSpe : ${espece.baseDefenseSpe}")}"
            )
//        val maxArtWidth = details.maxByOrNull { it.length }
//        val maxLines = max(artLines.size,details.size)
//        var chaine = ""
//        for (i in 0 until maxLines) {
//            var ligne= ""
//            if (i < artLines.size) {
//                ligne = artLines[i]
//            }
//            if(i < details.size){
//                ligne +="     "+details[i]
//            }
//            chaine+=ligne
//        }
//        println(chaine)
        println(details)
    }
}