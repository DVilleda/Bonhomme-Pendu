package quebec.crosemont.g04.bonhommependu.modèle;

import java.io.File;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class JoueurDAOSQLiteTest {
  
  @Test
  public void testLectureJoueurExistante() throws DAOException{
    JoueurDAOSQLite dao = new JoueurDAOSQLite(new File(getClass().getResource("/test.db").getFile()));

    Joueur note1 = dao.lire("Javier");
    Joueur note2 = dao.lire("Bambino");

    assertEquals(new Joueur("Javier", 12), note1);
    assertEquals(new Joueur("Bambino", 11), note2);    
  }

  @Test
  public void testLectureNoteInexistante() throws DAOException{
    JoueurDAOSQLite dao = new JoueurDAOSQLite(new File(getClass().getResource("/test.db").getFile()));

    Joueur joueur = dao.lire("JoueuInexistant");

    assertNull(joueur);
  }

  @Test
  public void testCréationNote() throws DAOException{
    JoueurDAOSQLite dao = new JoueurDAOSQLite(new File(getClass().getResource("/test.db").getFile()));

    Joueur nouveauJoueur = new Joueur("Joe", 13);
    Joueur joueurRetournée = dao.crèer(nouveauJoueur);

    //V�rifie la note retourn�e
    assertEquals(nouveauJoueur, dao.lire("Joe"));

    //V�rifie que la note a bien �t� sauvegard�e dans le fichier
    dao = new JoueurDAOSQLite(new File(getClass().getResource("/test.db").getFile()));
    assertEquals(nouveauJoueur, dao.lire("Joe"));

    //Supprime la note cr��e
    dao.supprimer(nouveauJoueur);
  }
  
  @Test
  public void testSuppressionNoteExistante() throws DAOException{
    JoueurDAOSQLite dao = new JoueurDAOSQLite(new File(getClass().getResource("/test.db").getFile()));

    Joueur nouveauJoueur = new Joueur("Allo",45);
    Joueur noteRetournée = dao.crèer(nouveauJoueur);

    //Supprime la note cr��e
    dao.supprimer(nouveauJoueur);

    //V�rifie que la note a bien �t� supprim�e du le fichier
    dao = new JoueurDAOSQLite(new File(getClass().getResource("/test.db").getFile()));
    assertNull(dao.lire("Allo"));

  }

  @Test
  public void testSuppressionNoteInexistante() throws DAOException{
    Joueur retour;
    JoueurDAOSQLite dao = new JoueurDAOSQLite(new File(getClass().getResource("/test.db").getFile()));

    Joueur nouveauJoueur = new Joueur("JoueurInexistant", 55);

    //Supprime la note sans l'avoir cr��e
    retour=dao.supprimer(nouveauJoueur);

    //V�rifie que la valeur retourn�e est null
    assertNull(retour);

  }
  
  @Test
  public void testModificationNoteExistante() throws DAOException{
    JoueurDAOSQLite dao = new JoueurDAOSQLite(new File(getClass().getResource("/test.db").getFile()));

    Joueur joueurOriginale = dao.lire("Bambino");
    Joueur joueuràModifier = dao.lire("Bambino");

    joueuràModifier.setScore(66);

    Joueur joueurRetournée = dao.modifier(joueuràModifier);
    
    //V�rifie la note retourn�e
    assertEquals(joueuràModifier, dao.lire("Bambino"));

    //V�rifie que la note a bien �t� sauvegard�e dans le fichier
    dao = new JoueurDAOSQLite(new File(getClass().getResource("/test.db").getFile()));
    assertEquals(joueuràModifier, dao.lire("Premi�re note"));

    //D�fait la modification
    dao.supprimer(joueuràModifier);
    dao.crèer(joueurOriginale);
  }

  @Test
  public void testModificationNoteInexistante() throws DAOException{
    JoueurDAOSQLite dao = new JoueurDAOSQLite(new File(getClass().getResource("/test.db").getFile()));

    Joueur joueuràModifier = new Joueur("JoueurInexistant", 99);

    Joueur joueurRetournée = dao.modifier(joueuràModifier);
    
    //V�rifie la note retourn�e
    assertNull(joueurRetournée);
  }
  
}
