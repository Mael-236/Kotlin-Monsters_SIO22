package org.example.monstre
import java.io.File

class EspeceMonstre (
    /* indice des monstres */ var id : Int,
    /* nom du monstre */ var nom: String,
    /* type du monstre */ var type: String,
    /* degats attaque de base */ val baseAttaque: Int,
    /* */ val baseDefense: Int,
    /* */ val baseVitesse: Int,
    /* */ val baseAttaqueSpe: Int,
    /* */ val baseDefenseSpe: Int,
    /* */ val basePv: Int,
    /* */ val modAttaque: Double,
    /* */ val modDefense: Double,
    /* */ val modVitesse: Double,
    /* */ val modAttaqueSpe: Double,
    /* */ val modDefenseSpe: Double,
    /* */ val modPv: Double,
    /* */ val description: String = "",
    /* */ val particularites: String = "",
    /* */ val caractères: String = ""
) {

    fun afficheArt(deFace: Boolean=true): String{
        val nomFichier = if(deFace) "front" else "back";
        val art=  File("src/main/resources/art/${this.nom.lowercase()}/$nomFichier.txt").readText()
        val safeArt = art.replace("/", "∕")
        return safeArt.replace("\\u001B", "\u001B")
    }
}