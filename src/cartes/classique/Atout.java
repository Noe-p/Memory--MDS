package cartes.classique;

public enum Atout {
	PIQUE("♠️"), COEUR("❤️"), CARREAU("♦️"), TREFFLE("♣️");

	private String visuel;

	Atout(String caractere) {
		this.visuel=caractere;
	}
	
	public String toString() {
		return this.visuel;
	}
}
