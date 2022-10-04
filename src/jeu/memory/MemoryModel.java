package jeu.memory;



import application.Main;
import cartes.classique.Carte32;
import cartes.paquet.Paquet32;
import view.IView;

public class MemoryModel extends Main {
	
	private Paquet32 paquet = null;
	private int nombreCartesTrouvees = 0;


	public void initialiserLeJeu() {
		this.paquet = new Paquet32();
	}
	
	
	public int getNombreCartesTrouvees() {
		return nombreCartesTrouvees;
	}

	public void setNombreCartesTrouvees(int nombreCartesTrouvees) {
		this.nombreCartesTrouvees = nombreCartesTrouvees;
	}

	public boolean tour(IView affichage) throws InterruptedException {
		affichage.afficherLeJeu(this.paquet, getLesJoueurs(), getJoueurCourant());
		
		
		Carte32 jeuCarte1 = affichage.choisirUneCarte(this.paquet);
		jeuCarte1.retourner();
		affichage.afficherLeJeu(this.paquet, getLesJoueurs(), getJoueurCourant());

		
		Carte32 jeuCarte2 = affichage.choisirUneCarte(this.paquet);
		jeuCarte2.retourner();	
		affichage.afficherLeJeu(this.paquet, getLesJoueurs(), getJoueurCourant());

		if(quelleCouleur(jeuCarte1) == quelleCouleur(jeuCarte2) && jeuCarte1.getValeur() == jeuCarte2.getValeur()) {
			jeuCarte1.setTrouvee(true);
			jeuCarte2.setTrouvee(true);
			getJoueurCourant().setCartesGagnees(2);
			this.nombreCartesTrouvees+=2;
			return true;
		}
		else {
            Thread.sleep(1000);
			jeuCarte2.retourner();	
			jeuCarte1.retourner();	
			affichage.afficherLeJeu(this.paquet, getLesJoueurs(), getJoueurCourant());
			changerdeJoueur();
			return false;
		}
	
		
	}
	
	public Paquet32 getPaquet() {
		return paquet;
	}
	
}


