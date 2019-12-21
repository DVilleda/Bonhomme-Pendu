package quebec.crosemont.g04.bonhommependu.modèle;

import java.util.ArrayList;
/**
 *  Classe d'acc�s aux donn�es des Joueurs
 * 
 */
public abstract class JoueurDAO extends DAO<Joueur>{
    /**
    * R�cup�re l'ensembles des Joueurs
    *
    * @return la liste de tous les joueurs
    */
    public abstract ArrayList<Joueur> trouverTout() throws DAOException;
    
}
