package view;

import java.util.List;

import cartes.classique.Carte32;
import cartes.paquet.Paquet32;
import joueur.Joueur;

public interface IView {
	public  int readANumber(String text);
	public String readAString(String text);
	public void print(Object object);
	public void afficherLeJeu(Paquet32 paquet, List<Joueur> lesJoueurs, Joueur joueur);
	public Carte32 choisirUneCarte(Paquet32 paquet);
	public void finDuJeu(Joueur joueur, List<Joueur> joueurs);
}
