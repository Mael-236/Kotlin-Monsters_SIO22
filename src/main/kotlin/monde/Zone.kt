package org.example.monde

import org.example.monstre.EspeceMonstre

class Zone(
    id:Int, nom:String, expZone:Int,
    especeMonstre: MutableList, zoneSuivante?:Zone,
    zonePrecedante?:Zone) {
}