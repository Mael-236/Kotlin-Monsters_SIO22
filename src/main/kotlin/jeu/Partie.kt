package org.example.jeu

import org.example.dresseur.Entraineur
import org.example.especeAquamy
import org.example.especeFlamkip
import org.example.especeSpringleaf
import org.example.monde.Zone
import org.example.monstre.IndividuMonstre

class Partie(val id: Int, val joueur: Entraineur, var zone: Zone) {

    fun choixStarter() {
        val monstre1: IndividuMonstre = IndividuMonstre(1, "Springleaf", especeSpringleaf, null, 0.2)
        val monstre2: IndividuMonstre = IndividuMonstre(2, "Flamkip", especeFlamkip, null, 0.2)
        val monstre3: IndividuMonstre = IndividuMonstre(3, "Aquamy", especeAquamy, null, 0.2)
        do {
            monstre1.afficheDetail()
            monstre2.afficheDetail()
            monstre3.afficheDetail()
            println("\u001B[32Choix 1: $monstre1, Choix 2: $monstre2, Choix 3: $monstre3\u001B[0")
            val choixSelection = readln().toInt()
        }
        while (choixSelection !in 1..3)


    }
}