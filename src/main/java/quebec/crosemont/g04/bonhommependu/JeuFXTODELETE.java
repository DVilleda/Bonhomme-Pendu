
package quebec.crosemont.g04.bonhommependu;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.input.*;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class JeuFXTODELETE extends Application {

    // Buttons alphabet
    Button btnA = new Button("A");
    Button btnB = new Button("B");
    Button btnC = new Button("C");
    Button btnD = new Button("D");
    Button btnE = new Button("E");
    Button btnF = new Button("F");
    Button btnG = new Button("G");
    Button btnH = new Button("H");
    Button btnI = new Button("I");
    Button btnJ = new Button("J");
    Button btnK = new Button("K");
    Button btnL = new Button("L");
    Button btnM = new Button("M");
    Button btnN = new Button("N");
    Button btnO = new Button("O");
    Button btnP = new Button("P");
    Button btnQ = new Button("Q");
    Button btnR = new Button("R");
    Button btnS = new Button("S");
    Button btnT = new Button("T");
    Button btnU = new Button("U");
    Button btnV = new Button("V");
    Button btnW = new Button("W");
    Button btnX = new Button("X");
    Button btnY = new Button("Y");
    Button btnZ = new Button("Z");

    VBox dispo_v = new VBox();
    GridPane lettres = new GridPane();

    HBox zoneJeu = new HBox();



    @Override
    public void start(Stage primaryStage) throws Exception{

        /** Load la bombe pour le jeu
         * L'image a un ratio de 1:1 pour ajustement des dimensions
         * Le ImageView est la variable qui doit etre ajouter a la scene pour apparaitre dans le jeu
         */
        File fil = new File(("Images/BombGame.jpg"));
        FileInputStream fichier = new FileInputStream(fil);
        Image imageBombe = new Image(fichier);
        final ImageView selectedBomb = new ImageView();
        selectedBomb.setImage(imageBombe);
        selectedBomb.setFitWidth(150);
        selectedBomb.setFitHeight(150);

        /**Load le personnage du jeu
         * L'image a un ratio de 2:1 pour ajustement des dimensions
         * Le ImageView est la variable qui doit etre ajouter a la scene pour apparaitre dans le jeu
         */
        File file = new File(("Images/Stickman.png"));
        FileInputStream unFichier = new FileInputStream(file);
        Image imageJeu = new Image(unFichier);
        final ImageView selectedImage = new ImageView();
        selectedImage.setImage(imageJeu);
        selectedImage.setFitWidth(200);
        selectedImage.setFitHeight(400);

        //Ajouter les images dans la zone de jeu
        zoneJeu.getChildren().add(selectedBomb);
        zoneJeu.getChildren().add(selectedImage);


        /**EventHandler KeyEvent qui va lire la touche appuyer
         * Dans cette version il lit la touche et envoie une alerte sur quel touche a etait appuye
         */
        EventHandler<KeyEvent> toucheClavier =
                new EventHandler<KeyEvent>() {
                    @Override
                    public void handle(KeyEvent keyEvent) {
                        Alert alerte = new Alert(Alert.AlertType.INFORMATION);
                        alerte.setContentText("Vous avez appuyez une touche: "+ keyEvent.getText().toUpperCase());
                        alerte.show();
                    }
                };

        /**
         * EventHandler ActionEvent qui va lire le clavier virtuel du jeu.
         * Dans cette version il lit le button et envoie une alerte
         */
        EventHandler<ActionEvent> clavierVirtuel =
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent keyEvent) {
                        String texte = ((Button) keyEvent.getTarget()).getText();
                        Alert alerte = new Alert(Alert.AlertType.INFORMATION);
                        alerte.setContentText("Vous avez appuyez un boutton: "+texte);
                        alerte.show();
                    }
                };

        /**
         * Ajouter le EventHandler a chaque boutton du clavier de l'application
         */
        btnA.addEventHandler(ActionEvent.ACTION,clavierVirtuel);
        btnB.addEventHandler(ActionEvent.ACTION,clavierVirtuel);
        btnC.addEventHandler(ActionEvent.ACTION,clavierVirtuel);
        btnD.addEventHandler(ActionEvent.ACTION,clavierVirtuel);
        btnE.addEventHandler(ActionEvent.ACTION,clavierVirtuel);
        btnF.addEventHandler(ActionEvent.ACTION,clavierVirtuel);
        btnG.addEventHandler(ActionEvent.ACTION,clavierVirtuel);
        btnH.addEventHandler(ActionEvent.ACTION,clavierVirtuel);
        btnI.addEventHandler(ActionEvent.ACTION,clavierVirtuel);
        btnJ.addEventHandler(ActionEvent.ACTION,clavierVirtuel);
        btnK.addEventHandler(ActionEvent.ACTION,clavierVirtuel);
        btnL.addEventHandler(ActionEvent.ACTION,clavierVirtuel);
        btnM.addEventHandler(ActionEvent.ACTION,clavierVirtuel);
        btnN.addEventHandler(ActionEvent.ACTION,clavierVirtuel);
        btnO.addEventHandler(ActionEvent.ACTION,clavierVirtuel);
        btnP.addEventHandler(ActionEvent.ACTION,clavierVirtuel);
        btnQ.addEventHandler(ActionEvent.ACTION,clavierVirtuel);
        btnR.addEventHandler(ActionEvent.ACTION,clavierVirtuel);
        btnS.addEventHandler(ActionEvent.ACTION,clavierVirtuel);
        btnT.addEventHandler(ActionEvent.ACTION,clavierVirtuel);
        btnU.addEventHandler(ActionEvent.ACTION,clavierVirtuel);
        btnV.addEventHandler(ActionEvent.ACTION,clavierVirtuel);
        btnW.addEventHandler(ActionEvent.ACTION,clavierVirtuel);
        btnX.addEventHandler(ActionEvent.ACTION,clavierVirtuel);
        btnY.addEventHandler(ActionEvent.ACTION,clavierVirtuel);
        btnZ.addEventHandler(ActionEvent.ACTION,clavierVirtuel);



        //1er ligne de lettres (13 lettres par lignes)
        lettres.add(btnA,0,0);
        lettres.add(btnB,1,0);
        lettres.add(btnC,2,0);
        lettres.add(btnD,3,0);
        lettres.add(btnE,4,0);
        lettres.add(btnF,5,0);
        lettres.add(btnG,6,0);
        lettres.add(btnH,7,0);
        lettres.add(btnI,8,0);
        lettres.add(btnJ,9,0);
        lettres.add(btnK,10,0);
        lettres.add(btnL,11,0);
        lettres.add(btnM,12,0);

        //2e ligne de lettres
        lettres.add(btnN,0,1);
        lettres.add(btnO,1,1);
        lettres.add(btnP,2,1);
        lettres.add(btnQ,3,1);
        lettres.add(btnR,4,1);
        lettres.add(btnS,5,1);
        lettres.add(btnT,6,1);
        lettres.add(btnU,7,1);
        lettres.add(btnV,8,1);
        lettres.add(btnW,9,1);
        lettres.add(btnX,10,1);
        lettres.add(btnY,11,1);
        lettres.add(btnZ,12,1);


        dispo_v.getChildren().add(zoneJeu);
        dispo_v.getChildren().add(lettres);


        Scene scene = new Scene(dispo_v);
        scene.addEventHandler(KeyEvent.KEY_PRESSED,(toucheClavier));

        primaryStage.setTitle("Bonhomme Bombe");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
