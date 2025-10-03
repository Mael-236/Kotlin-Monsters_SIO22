package org.example.monde

import org.example.monstre.EspeceMonstre
import org.example.monstre.IndividuMonstre
import org.example.jeu.CombatMonstre
import org.example.joueur
import kotlin.math.exp

//TODO -faire la methode rencontreMonstre()

class Zone(
    var id:Int, var nom:String, var expZone:Int,
    var especesMonstres: MutableList<EspeceMonstre> = mutableListOf(), var zoneSuivante:Zone? = null,
    var zonePrecedante:Zone? = null) {

    fun genereMonstre(): IndividuMonstre {

        val monstreSauvage = especesMonstres.random()
        val monstre= IndividuMonstre(1,monstreSauvage.nom,monstreSauvage,null, 0.0)
        monstre.exp += expZone * (20.0/100)
        return monstre
    }

    fun rencontreMonstre() {

        var monstreSauvage: IndividuMonstre = genereMonstre()
        var premierMonstre = joueur.equipeMonstre.find { it.pv > 0}!!
        CombatMonstre(monstreJoueur = premierMonstre, monstreSauvage = monstreSauvage)
        val combat = CombatMonstre(monstreJoueur = premierMonstre, monstreSauvage = monstreSauvage)
        combat.lanceCombat()
    }
}