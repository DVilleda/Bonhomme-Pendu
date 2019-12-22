package bonhommependu;

import  bonhommependu.modele.MotCache;
import  bonhommependu.modele.MotCacheDAO;
import  bonhommependu.modele.Difficulte;
import  bonhommependu.modele.Joueur;
import  bonhommependu.modele.JoueurDAOSQLite;

import javafx.event.ActionEvent;
import javafx.event.EventTarget;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;

import java.util.ArrayList;

public class Controller {
    @FXML
    private Label mot;
    @FXML
    private Button btnlead;
    @FXML
    private Label lettres;
    @FXML
    private WebView webView;
    @FXML
    private Button fermer;
    @FXML
    private Label nbEssais;
    @FXML
    private Button a;
    @FXML
    private Button b;
    @FXML
    private Button c;
    @FXML
    private Button d;
    @FXML
    private Button e;
    @FXML
    private Button f;
    @FXML
    private Button g;
    @FXML
    private Button h;
    @FXML
    private Button i;
    @FXML
    private Button j;
    @FXML
    private Button k;
    @FXML
    private Button l;
    @FXML
    private Button m;
    @FXML
    private Button n;
    @FXML
    private Button o;
    @FXML
    private Button p;
    @FXML
    private Button q;
    @FXML
    private Button r;
    @FXML
    private Button s;
    @FXML
    private Button t;
    @FXML
    private Button u;
    @FXML
    private Button v;
    @FXML
    private Button w;
    @FXML
    private Button x;
    @FXML
    private Button y;
    @FXML
    private Button z;

    //Les attributs dans le controleur
    MotCache unMot ;
    boolean motVisible =true;
    ArrayList<String> listeMots = new ArrayList<String>();
    MotCacheDAO dao = new MotCacheDAO();
    int vie = 0;
    ArrayList<Joueur> lbWV = new ArrayList<Joueur>();

    /**
     * Rend tous les buttons visible pour le debut d'une nouvelle partie
     */
    public void buttonVisible(){
        a.setVisible(true);
        b.setVisible(true);
        c.setVisible(true);
        d.setVisible(true);
        e.setVisible(true);
        f.setVisible(true);
        g.setVisible(true);
        h.setVisible(true);
        i.setVisible(true);
        j.setVisible(true);
        k.setVisible(true);
        l.setVisible(true);
        m.setVisible(true);
        n.setVisible(true);
        o.setVisible(true);
        p.setVisible(true);
        q.setVisible(true);
        r.setVisible(true);
        s.setVisible(true);
        t.setVisible(true);
        u.setVisible(true);
        v.setVisible(true);
        w.setVisible(true);
        x.setVisible(true);
        y.setVisible(true);
        z.setVisible(true);
    }

    /**
     * Envoie les donnes au leaderboard. Normalment ce serait a partir de la bd.
     * Dans ce cas c'est a partir d'un dummy liste de joueurs.
     */
   public void obtenirLB(){
       lbWV.add(new Joueur("Danny",5));
       lbWV.add(new Joueur("Dio",50));
       lbWV.add(new Joueur("Johnny",40));
       lbWV.add(new Joueur("President Valentine",100));
       lbWV.add(new Joueur("Gyro",60));
       String lbTexte="";
       for (int i=0; i<lbWV.size();i++) {
           lbTexte+=lbWV.get(i).toString()+"</br>";
       }
       webView.getEngine().loadContent(lbTexte);
   }

    /**
     * Obtiens le mots Moyen de la db
     * pour recreer la db ou inserer les mots on enleves le slash avant
     * certaines commandes
     */
   public void creerListeMotsMoyen(){
       ArrayList<String> motString;
       dao.connextion();
       //dao.creerDB();
       //dao.insertMots();
       listeMots=dao.chercherMotMoyen();
    }

    /**
     * Affiche le leaderboard dans un deuxieme ecran, mais du a des problemes
     * on utilise un leaderboard dummy.
     * Les donnes sont dans un WebView
     * @param event Le button leaderboard
     */
    @FXML
    public void affichtableau(ActionEvent event){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("lb.fxml"));
            Parent rootlb = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Leaderboard");
            stage.setScene(new Scene(rootlb));
            stage.show();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * Part le jeu en prenant un mot dans la BD au hasard
     * Dans cette version seul les mots de difficulte moyenne sont compris
     * Ca veut dire il y a 5 mots possibles
     */
    public void jouer(){
        creerListeMotsMoyen();
        int numeroHasardListe = ThreadLocalRandom.current().nextInt(0,5);
        String motDeListe = listeMots.get(numeroHasardListe);
        System.out.println("Mot de la bd: "+motDeListe);
        unMot = new MotCache(motDeListe);
        mot.setVisible(true);
        mot.setText(unMot.toString());
        btnlead.setVisible(false);
        buttonVisible();
        nbEssais.setText("Nb d'essais pris: 0");
        lettres.setText("Lettres utilisées :");
        vie =0;
    }

    /**
     * Permet de cacher les buttons apres une utilisation
     * @param evenement le button du clavier
     */
    @FXML
    public void cacher(ActionEvent evenement){
        Button cible = (Button) evenement.getTarget(); //getTarget retourne un Object
        cible.setVisible(false);
    }

    /**
     * La methode principal pour verifier si la lettre est bonne
     * Elle va chercher la lettre dans le mot et ajuster le texte dans les lettre utilises et cacher
     * les buttons
     * @param evenement le button du clavier
     */
    @FXML
    public void handle(ActionEvent evenement) {
        Button cible = (Button) evenement.getTarget(); //getTarget retourne un Object
        unMot.revelerLettre(cible.getText());
        mot.setText(unMot.toString());
        cacher(evenement);
        vie++;
        int comp=0;
        String lesLettres = lettres.getText();
        String lesEssais = "Nb d'essais pris: "+vie;
        nbEssais.setText(lesEssais);

        char laLettre = cible.getId().charAt(0);
        for (int i = 0; i < unMot.getLettreListe().size(); i++) {
            comp = Character.compare(unMot.getLettreListe().get(i).getLettre(), laLettre);
            if (comp != 0) {
                lettres.setText(lesLettres + "" + cible.getId());
            }
        }
    }


    /**
     * permet de fermer le leaderboard
     * @param actionEvent le button fermer
     */
    public void fermerlb(ActionEvent actionEvent) {
        Stage stage = (Stage) fermer.getScene().getWindow();
        stage.close();
    }
};


