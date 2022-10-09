package fr.ayfri.gui;

import fr.ayfri.gui.prompts.BooleanPrompt;
import fr.ayfri.gui.prompts.CharPrompt;
import fr.ayfri.gui.prompts.NumberPrompt;
import fr.ayfri.gui.prompts.StringPrompt;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.Objects;

/**
 * @author Pierre
 */
public final class Menu extends VBox {
	private final Stage stage;

	public Menu(@NotNull Stage stage) {
		this.stage = stage;
	}

	public boolean booleanPrompt(final String message) {
		try {
			final var dialog = new BooleanPrompt(message);
			final var result = dialog.showAndWait();
			return result.isPresent() && result.get().getText().equals("Oui");
		} catch (final Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public char charPrompt(final String message, final char @NotNull [] allowedChars, final boolean caseSensitive) {
		try {
			final var dialog = new CharPrompt(message, allowedChars, caseSensitive);
			final var result = dialog.showAndWait();
			return result.orElse(' ');
		} catch (final Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	public double doublePrompt(final String message, final double min, final double max) {
		try {
			final var dialog = new NumberPrompt(message, min, max);
			final var result = dialog.showAndWait();
			return result.orElse(0d);
		} catch (final Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	public long longPrompt(final String message, final double min, final double max) {
		try {
			final var dialog = new NumberPrompt(message, min, max);
			dialog.setIntegers(true);
			final var result = dialog.showAndWait();
			return result.orElse(0d).intValue();
		} catch (final Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	public void show() throws IOException {
		final var myFxmlURL = ClassLoader.getSystemResource("layout.fxml");
		final var fxmlLoader = new FXMLLoader(Objects.requireNonNull(myFxmlURL));
		fxmlLoader.load();
		VBox root = fxmlLoader.getRoot();

		stage.setScene(new Scene(root, 1600, 900));
		stage.show();
	}

	public String stringPrompt(final String message, final int minLength, final int maxLength) {
		try {
			final var dialog = new StringPrompt(message, minLength, maxLength);
			final var result = dialog.showAndWait();
			return result.orElse("");
		} catch (final Exception e) {
			e.printStackTrace();
			return "";
		}
	}
}
