package sample;

import java.util.ArrayList;
/**
 *  Classe d'accès aux données des Joueurs
 *
 */
public abstract class JoueurDAO extends DAO<Joueur>{
    /**
     * Récupère l'ensembles des Joueurs
     *
     * @return la liste de tous les joueurs
     */
    public abstract ArrayList<Joueur> trouverTout() throws DAOException;

}

