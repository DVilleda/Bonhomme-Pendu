package quebec.crosemont.g04.bonhommependu;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;


public class Resultat {
    //attributs
    String pseudonyme="";
    LocalDateTime dateDebut;
    LocalDateTime dateFin;
    int temps;
    Difficulte difficulte;

    /**
     *
     * @param unNom
     * @param uneDifficulte
     */
    public Resultat(String unNom,Difficulte uneDifficulte){
        pseudonyme = unNom;
        difficulte = uneDifficulte;
        dateDebut = LocalDateTime.now();
    }

    /**
     *
     * @param unNom
     * @param uneDifficulte
     * @param uneDuree
     */
    public Resultat(String unNom, Difficulte uneDifficulte, int uneDuree){
        pseudonyme = unNom;
        difficulte = uneDifficulte;
        temps = uneDuree;
    }

    //accesseurs
    /**
     * Permet de calculer le temps ecoule pour une partie. Convertie tous les objet LocalDateTime en LocalTime
     * et ensuite calcule le resultat en transformant les heures et minutes en secondes.
     * @return Le resultat varie selon si la partie est fini ou non
     */
    public int getTemps(){
        if(dateFin==null){
            LocalTime tempsActuel = LocalTime.now();
            LocalTime tempsDebut = dateDebut.toLocalTime();

            int heures = tempsActuel.getHour() - tempsDebut.getHour();
            int minutes = tempsActuel.getMinute() - tempsDebut.getMinute();
            int secondes = tempsActuel.getSecond() - tempsDebut.getSecond();

            temps = secondes + (minutes * 60)+(heures * 3600);
        }else{
            LocalTime tempsFin = dateFin.toLocalTime();
            LocalTime tempsDebut = dateDebut.toLocalTime();

            int heures = tempsFin.getHour() - tempsDebut.getHour();
            int minutes = tempsFin.getMinute() - tempsDebut.getMinute();
            int secondes = tempsFin.getSecond() - tempsDebut.getSecond();

            temps = secondes + (minutes * 60) + (heures * 3600);
        }
        return temps;
    }

    //Methodes

    @Override
    public String toString() {
       String ligne="";
       ligne+="Pseudonyme: "+pseudonyme;
       ligne+=" Difficulte: "+difficulte.toString();
       ligne+=" Duree de la partie: "+temps;
       return ligne;
    }
}
