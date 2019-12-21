package sample;

import java.io.File;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class JoueurDAOSQLiteTest {

    @Test
    public void testLectureJoueurExistante() throws DAOException{
        JoueurDAOSQLite dao = new JoueurDAOSQLite(new File(getClass().getResource("test.db").getFile()));

        Joueur note1 = dao.lire("Javier");
        Joueur note2 = dao.lire("Bambino");

        assertEquals("Javier (12)",note1.toString());
        assertEquals("Bambino (11)",note2.toString());
    }

    @Test
    public void testLectureJoueurInexistante() throws DAOException{
        JoueurDAOSQLite dao = new JoueurDAOSQLite(new File(getClass().getResource("test.db").getFile()));

        Joueur joueur = dao.lire("JoueuInexistant");

        assertNull(joueur.toString());
    }

    @Test
    public void testCréationJoueur() throws DAOException{
        JoueurDAOSQLite dao = new JoueurDAOSQLite(new File(getClass().getResource("test.db").getFile()));

        Joueur nouveauJoueur = new Joueur("Joe", 13);
        Joueur joueurRetourne = dao.créer(nouveauJoueur);

        //Vrifie la note retourne
        assertEquals(nouveauJoueur.toString(), dao.lire("Joe"));

        //Vrifie que la note a bien t sauvegarde dans le fichier
        dao = new JoueurDAOSQLite(new File(getClass().getResource("test.db").getFile()));
        assertEquals(nouveauJoueur.toString(), dao.lire("Joe"));

        //Supprime la note cre
        dao.supprimer(nouveauJoueur);
    }

    @Test
    public void testSuppressionJoueurExistante() throws DAOException{
        JoueurDAOSQLite dao = new JoueurDAOSQLite(new File(getClass().getResource("test.db").getFile()));

        Joueur nouveauJoueur = new Joueur("Allo",45);
        Joueur noteRetourne = dao.créer(nouveauJoueur);

        //Supprime la note cre
        dao.supprimer(nouveauJoueur);

        //Vrifie que la note a bien t supprime du le fichier
        dao = new JoueurDAOSQLite(new File(getClass().getResource("test.db").getFile()));
        assertNull(dao.lire("Allo"));

    }

    @Test
    public void testSuppressionJoueurInexistante() throws DAOException{
        Joueur retour;
        JoueurDAOSQLite dao = new JoueurDAOSQLite(new File(getClass().getResource("test.db").getFile()));

        Joueur nouveauJoueur = new Joueur("JoueurInexistant", 55);

        //Supprime la note sans l'avoir cre
        retour=dao.supprimer(nouveauJoueur);

        //Vrifie que la valeur retourne est null
        assertNull(retour);

    }

    @Test
    public void testModificationJoueurExistante() throws DAOException{
        JoueurDAOSQLite dao = new JoueurDAOSQLite(new File(getClass().getResource("test.db").getFile()));

        Joueur joueurOriginale = dao.lire("Bambino");
        Joueur joueurModifier = dao.lire("Bambino");

        joueurModifier.setScore(66);

        Joueur joueurRetourne = dao.modifier(joueurModifier);

        //Vrifie la note retourne
        assertEquals("Bambino (66)", joueurOriginale.toString());

        //Vrifie que la note a bien t sauvegarde dans le fichier
        dao = new JoueurDAOSQLite(new File(getClass().getResource("test.db").getFile()));
        assertEquals("Bambino (66)", joueurModifier.toString());

        //Dfait la modification
        dao.supprimer(joueurModifier);
        dao.créer(joueurOriginale);
    }

    @Test
    public void testModificationJoueurInexistante() throws DAOException{
        JoueurDAOSQLite dao = new JoueurDAOSQLite(new File(getClass().getResource("test.db").getFile()));

        Joueur joueurModifier = new Joueur("JoueurInexistant", 99);

        Joueur joueurRetourne = dao.modifier(joueurModifier);

        //Vrifie la note retourne
        assertNull(joueurRetourne);
    }

}
