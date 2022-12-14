package fr.ayfri.gui.prompts;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Dialog;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import org.jetbrains.annotations.NotNull;

/**
 * Dialogue pour demander un caractère.
 *
 * @author Pierre
 */
public class CharPrompt extends Dialog<Character> {
	/**
	 * Crée et affiche un nouveau dialogue.
	 * @param message Message à afficher.
	 * @param allowedChars Caractères autorisés.
	 * @param caseSensitive Sensibilité à la casse.
	 */
	public CharPrompt(final @NotNull String message, final char @NotNull [] allowedChars, final boolean caseSensitive) {
		final var content = new VBox(10);
		content.setAlignment(Pos.CENTER);
		content.setPadding(new Insets(15, 25, 15, 25));

		final var input = new TextField();
		input.setOnAction(event -> {
			if (input.getText().length() > 1) return;

			final var c = input.getText().charAt(0);
			for (final char allowedChar : allowedChars) {
				if (caseSensitive && c == allowedChar) {
					setResult(c);
					close();
					return;
				} else if (!caseSensitive && Character.toLowerCase(c) == Character.toLowerCase(allowedChar)) {
					setResult(c);
					close();
					return;
				}
			}
		});

		input.setOnKeyReleased(event -> {
			if (input.getText().length() > 1) {
				input.setStyle("-fx-text-fill: red;");
				return;
			}

			final var c = input.getText().charAt(0);
			for (final char allowedChar : allowedChars) {
				if (caseSensitive && c == allowedChar) {
					input.setStyle("-fx-text-fill: black;");
					return;
				} else if (!caseSensitive && Character.toLowerCase(c) == Character.toLowerCase(allowedChar)) {
					input.setStyle("-fx-text-fill: black;");
					return;
				}
			}
		});

		content.getChildren().add(input);
		getDialogPane().setContent(content);
		setTitle(message);
		setHeaderText(message);
	}
}
