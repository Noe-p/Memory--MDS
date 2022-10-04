package controller;

import jeu.memory.MemoryModel;
import view.SwingView;
import view.ISwingView;

public class SwingController extends MemoryModel{
	private final ISwingView ihmSwing = new SwingView();

	
	 public SwingController() throws InterruptedException {
	 	ihmSwing.creerLaFenetre();
	 	
	 	initialiserLeJeu();
	 	initialiserJoueurs(ihmSwing);
	 	
		
		while(getNombreCartesTrouvees() < 32) {
			tour(ihmSwing);
		}
		
		ihmSwing.finDuJeu(quiEstLeGagnant(), getLesJoueurs());
	 }
}
