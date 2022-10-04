package application;

import java.util.ArrayList;
import java.util.List;

import cartes.classique.Carte32;
import joueur.Joueur;
import lanceur.Lanceur;
import view.IView;

public class Main  {
	private List<Joueur> lesJoueurs = new ArrayList<Joueur>();
	private int JoueurCourant = 0;

	public void initialiserJoueurs(IView affichage) {
		int nbJoueurs = affichage.readANumber("Combien de joueurs ? ");
		for (int i = 1; i <= nbJoueurs; i++) {
			String nom = affichage.readAString("Joueur " + i + ", Quel est votre nom ? ");
			this.addJoueur(new Joueur(nom, 0));
		}
	}
	
	public void addJoueur(Joueur joueur) {
		this.getLesJoueurs().add(joueur);
	}

	public Joueur getJoueurCourant() {
		return this.getLesJoueurs().get(JoueurCourant);
	}

	public void changerdeJoueur() {
		if(this.getLesJoueurs().size()-1 > this.JoueurCourant) {
			this.JoueurCourant++;
		}
		else {
			this.JoueurCourant=0;
		}
	}

	public String quelleCouleur(Carte32 carte) {
		switch (carte.getAtout().toString()) {
		case "❤️":
			return "rouge";
		case "♦️":
			return "rouge";
		case "♣️️":
			return "noir";
		case "♠️️":
			return "noir";
		default:
			return "noir";
		}
	}
	
	public Joueur quiEstLeGagnant() {
		Joueur gagnant = this.getLesJoueurs().get(0); 
		for(int i = 0; i<getLesJoueurs().size(); i++) {
			if(this.getLesJoueurs().get(i).getCartesGagnees() > gagnant.getCartesGagnees()) {
				gagnant = this.getLesJoueurs().get(i);
			}
		}
		return gagnant;
	}
	
	public List<Joueur> getLesJoueurs() {
		return lesJoueurs;
	}
	
	public static void main(String[] args) throws InterruptedException {
		Lanceur lanceur = new Lanceur(); 
		lanceur.ChoixInterface(args);
	}

}
