package joueur;

public class Joueur {
	
	private final String nom; 
	private int cartesGagnees = 0;
	
	public Joueur(String nom, int nbCartes) {
		super(); 
		this.nom = nom; 
		this.cartesGagnees = 0;
		
	}

	public int getCartesGagnees() {
		return cartesGagnees;
	}
	
	
	public void setCartesGagnees(int cartesGagnees) {
		this.cartesGagnees += cartesGagnees;
	}
	

	public String getNom() {
		return nom;
	}
	

}
