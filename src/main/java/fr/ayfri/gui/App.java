package fr.ayfri.gui;

import fr.ayfri.inputs.AbstractInputManager;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;

public class App extends Application {
	public static boolean isGui = false;

	public static void main(final String[] args) {
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
