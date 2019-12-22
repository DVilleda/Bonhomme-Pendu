package bonhommependu.modele;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Radhika
 */
public class MotCacheDAO {
    
    static ArrayList<String> motsFacile=new ArrayList<String>();
    static ArrayList<String> motsMoyen=new ArrayList<String>();
    static ArrayList<String> motsDifficile=new ArrayList<String>();
    
    
    
    public static void connextion(){
         Connection c = null;
      
      try {
         Class.forName("org.sqlite.JDBC");
         c = DriverManager.getConnection("jdbc:sqlite:test.db");
      } catch ( Exception e ) {
         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
         System.exit(0);
      }
    }
    
    public static void creerDB(){
        Connection c = null;
      Statement stmt = null;
      
      try {
         Class.forName("org.sqlite.JDBC");
         c = DriverManager.getConnection("jdbc:sqlite:testFinale.db");

         stmt = c.createStatement();
         String sql = "CREATE TABLE motFacile " +
                        "(ID INT PRIMARY KEY     NOT NULL," +
                        " MOT           TEXT    NOT NULL)";
                       
         stmt.executeUpdate(sql);
         
         sql = "CREATE TABLE motMoyen " +
                        "(ID INT PRIMARY KEY     NOT NULL," +
                        " MOT           TEXT    NOT NULL)";
                       
         stmt.executeUpdate(sql);
         
         sql = "CREATE TABLE motDifficile " +
                        "(ID INT PRIMARY KEY     NOT NULL," +
                        " MOT           TEXT    NOT NULL)";
                       
         stmt.executeUpdate(sql);
         stmt.close();
         c.close();
      } catch ( Exception e ) {
         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
         System.exit(0);
      }
    }
    
    public static  void insertMots(){
        Connection c = null;
      Statement stmt = null;
      
      try {
         Class.forName("org.sqlite.JDBC");
         c = DriverManager.getConnection("jdbc:sqlite:testFinale.db");
         c.setAutoCommit(false);

         stmt = c.createStatement();
         String sql = "INSERT INTO motFacile (ID,MOT) " + "VALUES (1, 'ARBRE');"; 
         stmt.executeUpdate(sql);
         
         sql = "INSERT INTO motFacile (ID,MOT) " + "VALUES (2, 'BAZAR');"; 
         stmt.executeUpdate(sql);
         
         sql = "INSERT INTO motFacile (ID,MOT) " + "VALUES (3, 'BEIGE');"; 
         stmt.executeUpdate(sql);
         
         sql = "INSERT INTO motFacile (ID,MOT) " +"VALUES (4, 'BONET');"; 
         stmt.executeUpdate(sql);
         
         sql = "INSERT INTO motFacile (ID,MOT) " +"VALUES (5, 'CADRE');"; 
         stmt.executeUpdate(sql);
         

         sql = "INSERT INTO motMoyen (ID,MOT) " +"VALUES (1, 'MANTEAU');"; 
         stmt.executeUpdate(sql);
         
         sql = "INSERT INTO motMoyen (ID,MOT) " +"VALUES (2, 'REFUSER');"; 
         stmt.executeUpdate(sql);
         
         sql = "INSERT INTO motMoyen (ID,MOT) " +"VALUES (3, 'BALAYER');"; 
         stmt.executeUpdate(sql);
        
         sql = "INSERT INTO motMoyen (ID,MOT) " +"VALUES (4, 'DROGUES');"; 
         stmt.executeUpdate(sql);
         
         sql = "INSERT INTO motMoyen (ID,MOT) " +"VALUES (5, 'BALAYER');"; 
         stmt.executeUpdate(sql);
         
         
         sql = "INSERT INTO motDifficile (ID,MOT) " +"VALUES (1, 'ALLOCATION');"; 
         stmt.executeUpdate(sql);
         
         sql = "INSERT INTO motDifficile (ID,MOT) " +"VALUES (2, 'CERTIFICAT');"; 
         stmt.executeUpdate(sql);
      
         sql = "INSERT INTO motDifficile (ID,MOT) " +"VALUES (3, 'CHEVREUILS');"; 
         stmt.executeUpdate(sql);
         
         sql = "INSERT INTO motDifficile (ID,MOT) " +"VALUES (4, 'GENERATION');"; 
         stmt.executeUpdate(sql);
         
         sql = "INSERT INTO motDifficile (ID,MOT) " +"VALUES (5, 'PANTOUFLES');"; 
         stmt.executeUpdate(sql);
      
         stmt.close();
         c.commit();
         c.close();
      } catch ( Exception e ) {
         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
         System.exit(0);
      }
      
    }
    
    public static void chercherMotFacile(){
        Connection c = null;
   Statement stmt = null;
   try {
      Class.forName("org.sqlite.JDBC");
      c = DriverManager.getConnection("jdbc:sqlite:testFinale.db");
      c.setAutoCommit(false);
      

      stmt = c.createStatement();
      ResultSet rs = stmt.executeQuery( "SELECT * FROM motFacile;" );
      
      while ( rs.next() ) {
         int id = rs.getInt("id");
         String  mot = rs.getString("mot");
         motsFacile.add(mot);
         
         System.out.println( "ID = " + id );
         System.out.println( "MOT = " + mot );
         System.out.println();
      }
      rs.close();
      stmt.close();
      c.close();
   } catch ( Exception e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      System.exit(0);
   }
    }
    
   public static ArrayList<String> chercherMotMoyen(){
        Connection c = null;
   Statement stmt = null;
   try {
      Class.forName("org.sqlite.JDBC");
      c = DriverManager.getConnection("jdbc:sqlite:testFinale.db");
      c.setAutoCommit(false);
      

      stmt = c.createStatement();
      ResultSet rs = stmt.executeQuery( "SELECT * FROM motMoyen;" );
      
      while ( rs.next() ) {
         int id = rs.getInt("id");
         String  mot = rs.getString("mot");
         motsMoyen.add(mot);
         
         System.out.println( "ID = " + id );
         System.out.println( "MOT = " + mot );
         System.out.println();
      }
      rs.close();
      stmt.close();
      c.close();
   } catch ( Exception e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      System.exit(0);
   }
      return motsMoyen;
    }
    
   public static void chercherMotDifficile(){
        Connection c = null;
   Statement stmt = null;
   try {
      Class.forName("org.sqlite.JDBC");
      c = DriverManager.getConnection("jdbc:sqlite:testFinale.db");
      c.setAutoCommit(false);
      

      stmt = c.createStatement();
      ResultSet rs = stmt.executeQuery( "SELECT * FROM motDifficile;" );
      
      while ( rs.next() ) {
         int id = rs.getInt("id");
         String  mot = rs.getString("mot");
         motsDifficile.add(mot);
         
         System.out.println( "ID = " + id );
         System.out.println( "MOT = " + mot );
         System.out.println();
      }
      rs.close();
      stmt.close();
      c.close();
   } catch ( Exception e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      System.exit(0);
   }
       
    }

    /**
     * mini class pour tester le DAO MOTCACHE
     * @param args
     */
   public static void main(String args[]) {
       MotCacheDAO dao = new MotCacheDAO();
       dao.connextion();
       //dao.creerDB();
       //dao.insertMots();
       //dao.chercherMotMoyen();

       ArrayList<String> listeMots = dao.chercherMotMoyen();
       for (int i=0;i<listeMots.size();i++){
           System.out.println("TEST"+listeMots.get(i));
       }

       ArrayList<MotCache> listeArray = new ArrayList<>();

       for (int i=0;i<listeMots.size();i++){
           listeArray.add(new MotCache(listeMots.get(i)));
       }

       for (int i=0;i<listeArray.size();i++){
           listeArray.get(i).reveler();
           System.out.println("TEST 2 : "+listeArray.get(i));
       }
   }
    
    
}
