package org.example.dresseur

class Entraineur(var id: Int, var nom: String, var argents:Int,
    //TODO equipeMonstre
    //TODO boiteMonstre
    //TODO sacAKube
    ) {

    fun afficheDetail(){
        println("Dresseur : ${this.nom}")
        println("Argents: ${this.argents} ")
    }
}