package org.example.item

import org.example.joueur
import org.example.monstre.IndividuMonstre
import kotlin.random.Random

class MonsterKube(
    id: Int,
    nom: String,
    description: String,
    var chanceCapture: Double,
) : Item(id, nom, description), Utilisable {

    var result: Boolean = true

    override fun utiliser(cible: IndividuMonstre): Boolean {
        //TODO("Not yet implemented")
        println("Vous lancez le Monster Kube !")
        if (cible.entraineur != null) {
            println("Le monstre ne peut pas être capturé.")
        }
        else{
            var nbAleatoire = Random.nextInt(0,101)
            if (nbAleatoire < chanceCapture) {
                println("Le monstre est capturé !")
                print("Donner un nom : ")
                val nouveauNom = readln()
                if (nouveauNom.length != 0) {
                    cible.nom = nouveauNom
                }
                if (joueur.equipeMonstre.size >= 6) {
                    cible.entraineur?.boiteMonstre
                }
                else{
                    joueur.equipeMonstre
                }
                cible.entraineur = joueur
            }
            else{
                println("Presque ! Le Kube n'a pas pu capturer le monstre !")
                result = false
            }
        }
        return (result)
    }
}