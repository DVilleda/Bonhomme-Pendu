package quebec.crosemont.g04.bonhommependu;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;


enum Difficulte{
    /**
     * L'enum qui contient la difficulte de la partie
     */
   FACILE,
   MOYEN,
   DIFFICILE
}


public class Partie {
    //attributs
    String pseudonyme="";
    Difficulte difficulte;

    /**
     *
     * @param unNom
     * @param uneDifficulte
     */
    public Partie(String unNom,Difficulte uneDifficulte){
        pseudonyme = unNom;
        difficulte = uneDifficulte;
    }

    /**
     *
     * @param unNom
     * @param uneDifficulte
     * @param uneDuree
     */

    //accesseurs
    
    /**
     * @return retourne le pseudonyme du joeur
     */
    public String getPseudo(){
    	return pseudonyme;
    }

    //Methodes
    /**
     * 
     */
    public void changerPseudo(String unNom){
    	pseudonyme = unNom;
    }
    
    /**
     * Methode toString() pour la classe Partie. Cette methode va permettre de voir toutes
     * les donnees d'une partie qui serviront a construire une table de classement.
     */
    @Override
    public String toString() {
       String ligne="";
       ligne+="Pseudonyme: "+pseudonyme;
       ligne+=" Difficulte: "+difficulte.toString();
       return ligne;
    }
}