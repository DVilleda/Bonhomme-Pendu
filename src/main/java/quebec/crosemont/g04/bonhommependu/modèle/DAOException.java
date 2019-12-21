package quebec.crosemont.g04.bonhommependu.modèle;

/**
 * Une exception pouvant survenir lors de l'acc�s � une source de donn�es
 *
 */
public class DAOException extends Exception{
    public Exception exceptionOriginale;
    
    public DAOException(Exception ex){
        exceptionOriginale=ex;
    }
}
