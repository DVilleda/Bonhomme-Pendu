
package quebec.crosemont.g04.bonhommependu.modèle;

/**
 * Classe d'acc�s aux donn�es g�n�rique
 * 
 */
public abstract class DAO<T> {
    /**
    * Lit un objet � partir de son id
    * @param id l'identifiant unique de l'objet � lire
    * @return l'objet lu ou null si non trouv�
    */
    public abstract T lire(Object id) throws DAOException;
    
    /**
    *Cr�e un nouvel objet
    *
    * @param objet l'objet � ajouter dans la source de donn�es
    * @return l'objet tel qu'il a �t� cr�� dans la source de donn�es
    */
    public abstract T crèer(T objet) throws DAOException;
    
    /**
    * Modifie un objet dans la source de donn�es
    *
    * @param objet l'objet � modifier dans la source de donn�es
    * @return l'objet tel qu'il a �t� modifi� dans la source de donn�es
    */
    public abstract T modifier(T objet) throws DAOException;
    
    /**
    * Supprime un objet dans la source de donn�es
    *
    * @param objet l'objet � supprimer de la source de donn�es
    * @return l'objet supprim� ou null s'il n'a pas �t� trouv�
    */
    public abstract T supprimer(T objet) throws DAOException;
    
}
