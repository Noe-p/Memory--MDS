package view;

import java.io.IOException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.SwingUtilities;

import cartes.classique.Carte32;
import cartes.paquet.Paquet32;
import javafx.embed.swing.SwingNode;
import javafx.fxml.FXMLLoader;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import joueur.Joueur;

public class FxView implements IFxView {
	private Stage racine = null;
	private Scene scene = null;
	private GridPane rootNode = null;
	

	@Override
	public int readANumber(String text) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String readAString(String text) {



        rootNode.add(new Label(text), 0, 0);
        TextField firstValue = new TextField();
        rootNode.add(firstValue, 1, 0);
        rootNode.add(new Label("Sum is:"), 0, 2);
        Button aButton = new Button("Calculate");
        rootNode.add(aButton, 1, 2);
        GridPane.setHalignment(aButton, HPos.LEFT);
        TextField value2 = new TextField();

        aButton.setOnAction(e -> {
            String value1 = String.valueOf(firstValue.getText());
            value2.setText(value1);
        });


        return String.valueOf(value2.getText());
	}

	@Override
	public void print(Object object) {
		 Label label = new Label(object.toString());
	     rootNode.add(label, 0, 0);
	}

	@Override
	public void afficherLeJeu(Paquet32 paquet, List<Joueur> lesJoueurs, Joueur joueur) {
		this.rootNode = new GridPane();
		int nb = 1;
       //createSwingContent(swingNode);
      // this.rootNode.add(swingNode, 0, 3);

	}
	

	@Override
	public Carte32 choisirUneCarte(Paquet32 paquet) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void finDuJeu(Joueur gagnant,List<Joueur> joueurs) {
		// TODO Auto-generated method stub

	}

	public void creerLaFenetre(Stage racine) throws IOException{
		this.racine = racine;
		Parent root = FXMLLoader.load(getClass().getResource("TestFXML.fxml"));
		Scene scene = new Scene(root, 1000, 1000);
		this.scene = scene;
		this.racine.setScene(this.scene);
		this.racine.setTitle("Memory");
		this.racine.show();
		GridPane rootNode = new GridPane();
        rootNode.setPadding(new Insets(15));
        rootNode.setHgap(10);
        rootNode.setVgap(10);
        rootNode.setAlignment(Pos.CENTER);
        this.rootNode = rootNode;

	    this.scene.setRoot(rootNode);
		
	}



	

}
