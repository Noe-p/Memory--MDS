package controller;

import jeu.memory.MemoryModel;
import view.TextView;
import view.ITextView;

public class TextController extends MemoryModel {
	
	private final ITextView ConsoleText = new TextView();

	public TextController() throws InterruptedException{
		initialiserLeJeu();
		initialiserJoueurs(ConsoleText);
		
		while(getNombreCartesTrouvees() < 32) {
			if(tour(ConsoleText)) {
				ConsoleText.print("\nBravo "+getJoueurCourant().getNom()+" vous avez toruver les cartes ! \n");
			}else {
				ConsoleText.print("\n Perdu ! \n");
			}
		}
		ConsoleText.finDuJeu(quiEstLeGagnant(), getLesJoueurs());
		
	}
}
