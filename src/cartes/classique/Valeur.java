package cartes.classique;

public enum Valeur {
	SEPT("7"), HUIT("8"), NEUF("9"), DIX("10"), VALET("V"), DAME("D"), ROI("R"), AS("as");

	private String valeur;

	Valeur(String string) {
		// TODO Auto-generated constructor stub
		this.valeur = string;
	}
	
	
	public String toString() {
		return this.valeur;
	}

}
