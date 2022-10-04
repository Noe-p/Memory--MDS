package cartes;

import cartes.classique.Atout;
import cartes.classique.Valeur;

public interface ICarteMemory extends ICarte {

	public boolean isCompatible(ICarteMemory carte); 
	public Atout getAtout();
	public Valeur getValeur(); 
	
}
