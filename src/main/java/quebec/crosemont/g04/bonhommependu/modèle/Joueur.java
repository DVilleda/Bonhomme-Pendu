package sample;


/**
 * Un Classement
 *
 */
public class Joueur {

    //nom du joueur (pseudo)
    protected String pseudo;
    //score du joueur
    protected int score;

    /*
     * Constructeur
     *
     * @param unPseudo, le pseudonyme du joueur.
     * @param unScore, le pointage du joueur.
     */
    public Joueur(String unPseudo,int unScore){
        pseudo=unPseudo;
        score=unScore;
    }

    /**
     * Accesseur du pseudo
     *
     * @return le pseudo du joueur
     */
    public String getPseudo(){
        return pseudo;
    }

    /**
     * Accesseur du score du joueur
     *
     *
     */
    public int getScore(){
        return score;
    }

    /**
     * Mutateur de score
     *
     * @param unScore le nouveau score du joueur
     */
    public void setScore(int unScore){
        score=unScore;
    }

    /**
     * Retourne vrai si et seulement si le nom du joueur est le m�me
     *
     * @param autreJoueur Un joueur a comparer
     * @return vrai si et seulement si le pseudo du joueur est le m�me
     */

    public boolean equals(Joueur autreJoueur){
        boolean valeur=false;
        if (autreJoueur.getPseudo().equals(pseudo)){
            valeur=true;
        }
        return valeur;

    }
    public String toString(){
        String msg;
        return msg = this.getPseudo() + " (" + this.getScore() + ")";
    }

}
