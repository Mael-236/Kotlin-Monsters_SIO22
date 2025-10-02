package org.example.monde

import org.example.monstre.EspeceMonstre
import org.example.monstre.IndividuMonstre
import kotlin.math.exp

//TODO -faire la methode rencontreMonstre()

class Zone(
    var id:Int, var nom:String, var expZone:Int,
    var especesMonstres: MutableList<EspeceMonstre> = mutableListOf(), var zoneSuivante:Zone? = null,
    var zonePrecedante:Zone? = null) {

    fun genereMonstre() {

        val monstreCache = especesMonstres.random()
        val monstre= IndividuMonstre(1,monstreCache.nom,monstreCache,null, 0.0)
        monstre.exp += expZone * (20.0/100)
    }

    fun rencontreMonstre() {

        genereMonstre()
    }
}