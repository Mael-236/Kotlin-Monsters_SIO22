package org.example.dresseur

import org.example.item.Item
import org.example.monstre.IndividuMonstre

class Entraineur(var id: Int, var nom: String, var argents:Int,

    var equipeMonstre: MutableList<IndividuMonstre> = mutableListOf(),
    var boiteMonstre: MutableList<IndividuMonstre> = mutableListOf(),
    var sacAItems: MutableList<Item> = mutableListOf()
    //TODO sacAKube
    ) {

    fun afficheDetail(){
        println("Dresseur : ${this.nom}")
        println("Argents: ${this.argents} ")
    }
}