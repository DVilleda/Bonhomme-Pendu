package quebec.crosemont.g04.bonhommependu;

import java.util.*;

public class MotCache {

    //attributs de la classe Mot
    protected String mot = "";
    protected static char[] motCaracteres;
    public ArrayList<Lettre> lettreListe= new ArrayList<Lettre>();

    /**
     * Constructeur de la classe MotCache qui construit le mot cache a partir d'un String
     * Ce string est ensuite converti en ArrayList de type de Lettre qui par defaut seront caches lors du jeu
     *
     * @param unMot c'est le mot cache a etre decouvert pendant le jeu
     */
    public MotCache(String unMot) {
        mot = unMot;
        motCaracteres = unMot.toCharArray();

        //boucle pour construile la liste de lettres
        for (int i = 0; i < motCaracteres.length; i++) {
            lettreListe.add(i,new Lettre(motCaracteres[i]));
        }
    }

    //Methodes de la classe MotCache
    /**
     *
     */
    public void revelerLettreIndex(int index){
        lettreListe.get(index).setVisible();
    }

    public void revelerLettre(String uneLettre){
        int position = 0;
        while(position != -1){
            position = mot.indexOf(uneLettre, position);
            if (position != -1) {
                 revelerLettreIndex(position);
                position ++;
            }
        }
    }
    /**
     *
     */
    public void reveler(){
        for (int i = 0; i < lettreListe.size(); i++) {
            lettreListe.get(i).setVisible();
        }
    }

    /**
     *
     */
    public void cacher(){
        for (int i = 0; i < lettreListe.size(); i++) {
            lettreListe.get(i).setCache();
        }
    }


    /**
     *
     * @return
     */
    @Override
    public String toString() {
        String msg = "";

        for (int i = 0; i < lettreListe.size(); i++) {
            if (lettreListe.get(i).estVisible()) {
                msg += String.valueOf(lettreListe.get(i).getLettre());
            } else if (!lettreListe.get(i).estVisible()) {
                msg += " ";
            }
        }

        return msg;
    }


    public static void main(String args[]) {
        String mot="bonjour";

        //Test de base de la classe
        MotCache unMot = new MotCache(mot);

        //Mot en char
        System.out.println("Test pour voir que le mot a ete cree");
        for(char c : motCaracteres){
            System.out.print(c);
        }

        System.out.println("\n \nMot avant d etre reveler");
        System.out.println("Le mot est: "+unMot.toString());

        System.out.println("\nMot apres revelation de quelques lettres avec index");
        unMot.revelerLettreIndex(3);
        unMot.revelerLettreIndex(0);
        unMot.revelerLettreIndex(2);
        System.out.println("Le mot est: "+unMot.toString());

        System.out.println("\nMot apres revelation de quelques lettres avec une lettre");
        unMot.cacher();
        unMot.revelerLettre("o");
        unMot.revelerLettre("b");
        unMot.revelerLettre("r");
        unMot.revelerLettre("z");
        System.out.println("Le mot est: "+unMot.toString());

        System.out.println("\nMot apres revelation");
        unMot.reveler();
        System.out.println("Le mot est: "+unMot.toString());
    }
}
