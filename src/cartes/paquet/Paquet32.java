package cartes.paquet;

import javax.swing.ImageIcon;

import cartes.classique.Atout;
import cartes.classique.Carte32;
import cartes.classique.Valeur;

public class Paquet32 extends Paquet<Carte32> {

	public Paquet32() {
		super();
		// TODO Auto-generated constructor stub
		
		for (Atout atout : Atout.values()) {
			for(Valeur valeur : Valeur.values()) {
				super.add(new Carte32(atout, valeur, new ImageIcon("/Users/noephilippe/eclipse-workspace/Memory/cartes32/"+valeur+atout+".png")));
			}
		}
		
		super.melanger();
		
	}
	
}
