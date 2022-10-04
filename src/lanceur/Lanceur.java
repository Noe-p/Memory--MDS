package lanceur;

import controller.FxController;
import controller.SwingController;
import controller.TextController;
import view.ITextView;
import view.TextView;

public class Lanceur {
	private final ITextView ConsoleText =  new TextView();

	
	public void ChoixInterface(String[] args) throws InterruptedException  {
		int choix = ConsoleText.readANumber("Quelle interface voulez-vous ? (1-Console, 2-Swing, 3-FX)");
		switch(choix) {
			case 1 : 
				new TextController();
				break;
			case 2 : 
				new SwingController();
				break;
			case 3: 
				FxController test = new FxController();
				test.lancer(args);
				break;
		}
			
	}
}
