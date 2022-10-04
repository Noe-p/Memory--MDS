package controller;
import javafx.application.*;
import javafx.stage.Stage;
import jeu.memory.MemoryModel;
import view.FxView;
import view.IFxView;

public class FxController extends Application{
	private final IFxView fxView = new FxView();
	private final MemoryModel memory = new MemoryModel();
	 
	public void lancer(String[] args) {
		launch(args);
	}
	
	@Override
	 public void start(Stage racine) throws Exception {
			fxView.creerLaFenetre(racine);
		 	memory.initialiserLeJeu();
		 	//String test = fxView.readAString("Test");
		 	fxView.print("Coucou");
		 	

	}
	
	
	 
	
}