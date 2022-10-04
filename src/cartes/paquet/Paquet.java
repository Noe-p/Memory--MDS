package cartes.paquet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import cartes.ICarte;

public abstract class Paquet<T extends ICarte> {
	
	private List<T> lesCartes = new ArrayList<T>();
	
	public boolean add(T uneCarte) {
		return this.lesCartes.add(uneCarte);
	}
	
	public T remove(int i) {
		return this.lesCartes.remove(i);
	}
	
	public boolean isEmpty() {
		return this.lesCartes.isEmpty();
	}
	
	public int size() {
		return this.lesCartes.size();
	}
	
	public T trouverCarte(int i) {
		return this.lesCartes.get(i-1);
	}
	
	public void melanger() {
		Collections.shuffle(this.lesCartes);
	}

	@Override
	public String toString() {
		String visuel = ""; 
		int compteur = 1; 
		for(T t: lesCartes) {
			visuel+=t.toString()+compteur + " "; 
			if(compteur%6==0) {
				visuel+="\n";
			}
			compteur++;
		}
		return visuel;
	}
	
	

}
