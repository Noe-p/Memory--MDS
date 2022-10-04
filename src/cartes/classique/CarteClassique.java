package cartes.classique;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import cartes.Carte;
import cartes.ICarteMemory;

public abstract class CarteClassique extends Carte implements ICarteMemory {
	
	
	private final Atout atout; 
	private final Valeur valeur; 
	private JButton  button;
	private boolean isTrouvee= false;
	private ImageIcon image;
	
	public CarteClassique(Atout atout, Valeur valeur, ImageIcon image) {
		super();
		this.atout = atout;
		this.valeur = valeur;
		this.image = image;
		this.button = new JButton(image);
	}

	@Override
	public boolean isCompatible(ICarteMemory carte) {
		// TODO Auto-generated method stub
		return this.atout == carte.getAtout() && this.valeur == carte.getValeur();
	}

	public Atout getAtout() {
		return atout;
	}


	public Valeur getValeur() {
		return valeur;
	}
	

	public void setTrouvee(boolean isTrouvee) {
		this.isTrouvee = isTrouvee;
	}
	
	public boolean getTrouvee() {
		return this.isTrouvee;
	}


	@Override
	public String toString() {
		String visuel = "[*****]"; 
		if(this.isVisible()) {
			visuel="[" +valeur + atout + "]";
		}
		if (this.isTrouvee) {
			visuel = "      ";
		}
		return visuel;
	}


	public JButton getButton() {
		if (this.isVisible() && !this.getTrouvee()) {
			this.button.setIcon(this.image);
		}
		else if(this.getTrouvee()){
			this.button.setIcon(null);
		}
		else {
			this.button.setIcon(new ImageIcon("/Users/noephilippe/eclipse-workspace/Memory/cartes32/b1fv.png"));
		}
		return this.button;
		
	}



	
	
	
}
