package view;

import java.io.IOException;

import javafx.scene.Scene;
import javafx.stage.Stage;

public interface IFxView extends IView{
	public void creerLaFenetre(Stage racine) throws IOException;
}
