package org.example.monde

import org.example.monstre.EspeceMonstre

//TODO -faire la methode genreMonstre(), -faire la methode rencontreMonstre()

class Zone(
    var id:Int, var nom:String, var expZone:Int,
    var especesMonstres: MutableList<EspeceMonstre> = mutableListOf(), var zoneSuivante:Zone? = null,
    var zonePrecedante:Zone? = null) {
}