package bonhommependu;

import javafx.event.ActionEvent;
import javafx.event.EventTarget;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Controller {

    @FXML
    private VBox leaderboard;
    @FXML
    private Label mot;
    @FXML
    private Button btnlead;
    @FXML
    private Label lettres;
    @FXML
    private Label essais;
    @FXML
    private Label vicdef;
    @FXML
    private Label motss;
    @FXML
    private GridPane allo;


    MotCache unMot ;
    Partie unePartie = new Partie("La Partie",Difficulte.MOYEN);


    /*@FXML
    @FXML*/

    @FXML
    public void affichtableau(){
        leaderboard.setVisible(true);

    }

    public void jouer(){
        unMot = new MotCache("aaa");
        int vie = 5;
        mot.setVisible(true);
        mot.setText(unMot.toString());
        leaderboard.setVisible(false);
        btnlead.setVisible(false);

    }
    @FXML
    public void handle(ActionEvent evenement) {
        Button cible = (Button) evenement.getTarget(); //getTarget retourne un Object
        unMot.revelerLettre(cible.getId());
           /* Alert alerte = new Alert(Alert.AlertType.INFORMATION);
            alerte.setTitle("Lettre");
            alerte.setContentText(cible.getId());
            alerte.showAndWait();*/
        mot.setText(unMot.toString());
        int comp;
        String lesLettres = lettres.getText();
        char laLettre = cible.getId().charAt(0);
        for (int i = 0; i < unMot.getLettreListe().size(); i++) {
            comp = Character.compare(unMot.getLettreListe().get(i).getLettre(), laLettre);
            if (comp != 0) {
                lettres.setText(lesLettres + "" + cible.getId());
            }else{

            }
        }



    }
    public void victoire(){
        int conter=0;
        for (int i=0;i<unMot.getLettreListe().size();i++){

            if (unMot.getLettreListe().get(i).estVisible()==true){

                conter+=1;
            }
        }
        System.out.println(conter);
        System.out.println( unMot.getLettreListe().size());
        if (conter == unMot.getLettreListe().size()){
            ecranFvictoire();
        } else {
            ecranFdef();
        }
    }
    @FXML
    public void ecranFvictoire(){
        allo.setVisible(true);
        essais.setText("hahahahah c'est pas compté");
        motss.setText(unMot.toString());
        vicdef.setText("victoire");
    }
    @FXML
    public void ecranFdef(){
        allo.setVisible(true);
        essais.setText("hahahahah c'est pas compté");
        motss.setText(unMot.toString());
        vicdef.setText("defaite");
    }





};


