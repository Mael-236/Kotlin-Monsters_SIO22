package org.example.dresseur

import org.example.monstre.IndividuMonstre

class Entraineur(var id: Int, var nom: String, var argents:Int,

    var equipeMonstre: MutableList<IndividuMonstre> = mutableListOf(),
    var boiteMonstre: MutableList<IndividuMonstre> = mutableListOf(),
    //TODO sacAKube
    ) {

    fun afficheDetail(){
        println("Dresseur : ${this.nom}")
        println("Argents: ${this.argents} ")
    }
}