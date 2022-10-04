package cartes;

public abstract class Carte implements ICarte{
	private boolean visible = false; 
	
	@Override
	public boolean isVisible() {
		// TODO Auto-generated method stub
		return this.visible;
	}
	
	@Override
	public void retourner() {
		this.visible=!this.visible; 

	}
	
	public void setVisible(boolean visible) {
		this.visible = visible;
	}
}
