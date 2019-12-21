package quebec.crosemont.g04.bonhommependu.modèle;

import java.io.File;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *  Classe d'acc�s aux donn�es g�n�rique
 * 
 */
public class JoueurDAOSQLite extends JoueurDAO {
    // le fichier SQLite original
    protected File fichier;
    
    public JoueurDAOSQLite(File unFichier){
        fichier=unFichier;
    }
    
    /**
    * Lit un objet � partir de son id
    *
    * @param id l'identifiant unique de l'objet � lire
    * @return l'objet lu ou null si l'objet ne peut pas �tre lu
    */
    @Override public Joueur lire(Object id) throws DAOException{
        Joueur lue;
        
        try{
            Connection conn=SQLConnectionFactory.getConnection(fichier);
            
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM joueur WHERE pseudo=?");
            stmt.setString(1,(String)id);
            ResultSet rs = stmt.executeQuery();
            
            lue=null;
            if(rs.next()){
                lue=new Joueur((String)id,rs.getInt("score"));
            }
            
            rs.close();
            conn.close();
            
        }
        catch(SQLException e){
            throw new DAOException(e);
        }
        return lue;
    }
    
    /**
    * Creer un nouvel objet
    *
    * @param objet l'objet � ajouter dans la source de donn�es
    * @return l'objet tel qui a �t� cr��
    */
    @Override public Joueur crèer(Joueur objet) throws DAOException{
        try{
            Connection conn=SQLConnectionFactory.getConnection(fichier);

            PreparedStatement stmt = conn.prepareStatement("INSERT INTO joueur(pseudo, score) VALUES (?, ?)");
            stmt.setString(1, objet.getPseudo());
            stmt.setInt(2, objet.getScore());

            stmt.executeUpdate();
            stmt.close();
      
            return lire(objet.getPseudo());
        }
        catch(SQLException e){
            throw new DAOException(e);
        }  
    }
    
    /**
    * Modifie un objet
    *
    * @param objet l'objet � modifier dans la source de donn�es
    * @return l'objet tel qu'il a �t� modifi�
    */
    @Override public  Joueur modifier(Joueur objet) throws DAOException{
        try{
            Connection conn=SQLConnectionFactory.getConnection(fichier);

            PreparedStatement stmt = conn.prepareStatement("UPDATE joueur SET score=? WHERE joueur=?");
            stmt.setInt(1, objet.getScore());
            stmt.setString(2, objet.getPseudo());

            stmt.executeUpdate();
            stmt.close();
      
            return lire(objet.getPseudo());
        }
        catch(SQLException e){
            throw new DAOException(e);
        }
    }
    
    /**
    * Supprime un objet
    *
    * @param objet l'objet � supprimer de la source de donn�es
    * @return l'objet supprim� ou null s'il n'a pas �t� trouv�
    */
    @Override public  Joueur supprimer(Joueur objet) throws DAOException{
        if(lire(objet.getPseudo())==null) return null;
    
        try{
            Connection conn=SQLConnectionFactory.getConnection(fichier);

            PreparedStatement stmt = conn.prepareStatement("DELETE FROM joueur WHERE pseudo = ?");
            stmt.setString(1, objet.getPseudo());

            stmt.executeUpdate();
            stmt.close();
      
            return objet;
        }
        catch(SQLException e){
            throw new DAOException(e);
        }
    }
    
    /**
   * R�cup�re l'ensembles des Joueur en ordre de score
   *
   * @return la liste de toutes les Joueurs
   */
  @Override public  ArrayList<Joueur> trouverTout() throws DAOException{
    ArrayList<Joueur> joueurs=new ArrayList<Joueur>();

    try{
      Connection conn=SQLConnectionFactory.getConnection(fichier);
      Statement stmt=conn.createStatement();

      if(stmt.execute("SELECT * FROM joueur ORDER BY score DESC")){
	ResultSet rs=stmt.getResultSet();

	while(rs.next()){
	  joueurs.add(new Joueur(rs.getString("pseudo"), rs.getInt("score")));
	}

	rs.close();
      }
      conn.close();
    }
    catch(SQLException e){
      throw new DAOException(e);
    }

    return joueurs;
    
  }
}
