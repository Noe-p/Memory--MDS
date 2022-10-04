package view;

import java.util.List;
import java.util.Scanner;

import cartes.classique.Carte32;
import cartes.paquet.Paquet32;
import joueur.Joueur;

/**
 * Your class in package ihm to read from the keyboard and write on the screen
 * @author Allain
 *
 */
public class TextView implements ITextView {

	// The Scanner is in another class according to MVC Design Pattern
	private static final Scanner sc = new Scanner(System.in); 

	/**
	 * @param text
	 * @return
	 */
	public int readANumber(String text) {
		System.out.println(text);
		int number = sc.nextInt();		
		//System.out.println("number given = "+number);
		return number;
	}

	/**
	 * @param text
	 * @return
	 */
	public String readAString(String text) {
		System.out.println(text);
		String word = sc.next();		
		//System.out.println("number given = "+word);
		return word;
	}

	public void close() {
		sc.close();
	}

	public void print(Object object) {
		System.out.println(object);
	}
	
	public void pressEnter() {
		System.out.println("press Enter to continue...");
		sc.nextLine();	
	}
	
	public boolean readABoolean(String string) {
		System.out.println(string+" y/Y n/N");
		String word = sc.next();		
		return word.equals("y")||word.equals("Y");
	}

	@Override
	public void afficherLeJeu(Paquet32 paquet, List<Joueur> lesJoueurs, Joueur joueur) {
		System.out.println(paquet);
		this.print("\n****************** SCORE **********************");
		for(int i=0; i<lesJoueurs.size(); i++) {
			this.print(lesJoueurs.get(i).getNom() + " a " + lesJoueurs.get(i).getCartesGagnees() + " carte(s).");
		}
		this.print("****************** SCORE **********************\n");
	}

	@Override
	public Carte32 choisirUneCarte(Paquet32 paquet) {
		int numCarte = this.readANumber("Choisissez une carte : ");
		while(paquet.trouverCarte(numCarte).isVisible()) {
			numCarte = this.readANumber("Cette carte est déjà retrounée !\n Choisisser une carte à retourner : ");
		}
		return paquet.trouverCarte(numCarte);
	}
	
	public void finDuJeu(Joueur gagnant, List<Joueur> joueurs) {
		this.print("\n\n**********************************");
		this.print("Le jeu est terminé !");
		this.print(gagnant.getNom() + " a gagné avec "+gagnant.getCartesGagnees()+" cartes gagnées !!!");
	
	}
	
}
