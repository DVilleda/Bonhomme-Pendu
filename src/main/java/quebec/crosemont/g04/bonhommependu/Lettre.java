package quebec.crosemont.g04.bonhommependu;

import java.util.*;


public class Lettre {

    //Attributs de la classe
    protected char lettre ;
    protected boolean visible=false;

    public Lettre(char uneLettre){
        lettre = uneLettre;
        visible=false;
    }

    public char getLettre() {
        return lettre;
    }

    public boolean estVisible() {
        return visible;
    }

    public void setVisible(){
        visible=true;
    }

    public void setCache(){
        visible=false;
    }
}
