package quebec.crosemont.g04.bonhommependu;

import java.util.*;


public class Lettre {

    //Attributs de la classe
    protected char lettre ;
    protected boolean visible=false;

    /**
     * Creation d'un objet de type lettre. Cet objet contient le charactere et une valeure boolean qui affectera si la lettre sera cache ou visible
     * @param uneLettre
     */
    public Lettre(char uneLettre){
        lettre = uneLettre;
        visible=false;
    }
    //accesseurs
    /**
     * @return la lettre en format char
     */
    public char getLettre() {
        return lettre;
    }

    /**
     * @return si la lettre est visible ou non en boolean
     */
    public boolean estVisible() {
        return visible;
    }

    //Methodes

    /**
     * rend une lettre visible
     */
    public void setVisible(){
        visible=true;
    }

    /**
     * cache la lettre 
     */
    public void setCache(){
        visible=false;
    }
}
