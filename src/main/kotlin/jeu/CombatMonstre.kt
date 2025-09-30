package org.example.jeu

import org.example.monstre.IndividuMonstre
import org.example.dresseur.Entraineur
import org.example.item.Utilisable
import org.example.joueur

class CombatMonstre(var monstreJoueur: IndividuMonstre, var monstreSauvage: IndividuMonstre) {

    var round = 1

    fun gameOver(): Boolean {
        /**
         * Vérifie si le joueur a perdu le combat.
         *
         * Condition de défaite :
         * - Aucun monstre de l'équipe du joueur n'a de PV > 0.
         *
         * @return `true` si le joueur a perdu, sinon `false`.
         */
        if (monstreJoueur.pv > 0) {
            return false
        }
        else{
            return true
        }
    }

    fun joueurGagne(): Boolean {
        if (monstreSauvage.pv <= 0) {
            println("${joueur.nom} a gagné !")
            var gainExp = monstreSauvage.exp * 0.20
            gainExp = monstreJoueur.exp
            println("${monstreJoueur.nom} gagne $gainExp exp")
            return true
        }
        else{
            if (monstreSauvage.entraineur == joueur) {
                println("${monstreSauvage.nom} a été capturé !")
                return true
            }
            else{
                return false
            }
        }
    }

    fun actionAdversaire() {
        if (monstreSauvage.pv > 0) {
            monstreSauvage.attaquer(monstreJoueur)
        }
    }

    fun actionJoueur(sacAItems: Entraineur): Boolean {
        if (gameOver() == true) {
            return false
        }
        else {
            println("1 : attaque")
            println("2 : item")
            println("3 : changer monstre")
            var choixAction = readln().toInt()
            if (choixAction == 1) {
              monstreJoueur.attaquer(monstreSauvage)
            }
            else if (choixAction == 2) {
//                println(sacAItems)
                for ((index,unItem) in joueur.sacAItems.withIndex())
                {
                    println("$index => ${unItem.nom}")
                }
                var indexChoix=readln().toInt()
                var objetChoisi = joueur.sacAItems[indexChoix]
                if (objetChoisi is Utilisable) {
                    var captureReussi = objetChoisi.utiliser(monstreSauvage)
                    if (captureReussi == true) {
                        return false
                    }
                }
                else {
                    println("Objet non utilisable")
                }
            }
            else if (choixAction == 3) {
                println(joueur.equipeMonstre)
                var indexChoix = readln().toInt()
                var choixMonstre = joueur.equipeMonstre[indexChoix]
                if (choixMonstre.pv <= 0) {
                    println("Impossible ! Ce monstre est KO")
                }
                else {
                    println("$choixMonstre remplace $monstreJoueur")
                    monstreJoueur = choixMonstre
                }
            }
            return true
        }
    }

    fun afficheCombat() {
        println("======== Début Round : $round ========")
        println("Niveau : ${monstreSauvage.niveau}")
        println("PC : ${monstreSauvage.pv / monstreSauvage.pvMax}")
    }
}