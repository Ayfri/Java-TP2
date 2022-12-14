package fr.ayfri.gui.prompts;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Dialog;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import org.jetbrains.annotations.NotNull;

/**
 * Dialogue pour demander un nombre.
 *
 * @author Pierre
 */
public class NumberPrompt extends Dialog<Double> {
	/**
	 * Propriété indiquant si le nombre est un entier.
	 */
	private boolean integers = false;

	/**
	 * Crée et affiche un nouveau dialogue.
	 * @param message Message à afficher.
	 * @param min Valeur minimale.
	 * @param max Valeur maximale.
	 */
	public NumberPrompt(final @NotNull String message, final double min, final double max) {
		final var content = new VBox(10);
		content.setAlignment(Pos.CENTER);
		content.setPadding(new Insets(15, 25, 15, 25));

		final var input = new TextField();
		input.setOnAction(event -> {
			try {
				final var number = Double.parseDouble(input.getText());
				if (
					number >= min &&
					number <= max ||
					(integers && number != (long) number)
				) {
					setResult(number);
					close();
				}
			} catch (final NumberFormatException ignored) {
			}
		});

		input.setOnKeyReleased(event -> {
			try {
				final var number = Double.parseDouble(input.getText());
				if (
					number < min ||
					number > max ||
					(integers && number != (long) number)
				) input.setStyle("-fx-text-fill: red;");
				else input.setStyle("-fx-text-fill: black;");
			} catch (final NumberFormatException e) {
				input.setStyle("-fx-text-fill: red;");
			}
		});

		content.getChildren().add(input);
		getDialogPane().setContent(content);
		setTitle(message);
		setHeaderText(message);
	}

	public void setIntegers(final boolean integers) {
		this.integers = integers;
	}
}
