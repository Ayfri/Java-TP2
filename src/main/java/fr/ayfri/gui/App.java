package fr.ayfri.gui;

import fr.ayfri.inputs.AbstractInputManager;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;

/**
 * Classe principale de l'application JavaFX.
 *
 * @author Pierre
 */
public class App extends Application {
	/**
	 * Propriété statique indiquant si l'application est en mode graphique ou non.
	 */
	public static boolean usingGUI = false;

	/**
	 * Méthode principale de l'application.
	 *
	 * @param args Arguments de la ligne de commande (non utilisés).
	 */
	public static void main(final String[] args) {
		usingGUI = true;
		launch(args);
	}

	@Override
	public void start(final @NotNull Stage primaryStage) throws IOException {
		final var scene = new Scene(new VBox(), 1600, 900);
		primaryStage.setTitle("TP2");
		primaryStage.show();
		primaryStage.setScene(scene);

		final var menu = new Menu(primaryStage);
		menu.show();

		AbstractInputManager.setMenu(menu);
	}
}
