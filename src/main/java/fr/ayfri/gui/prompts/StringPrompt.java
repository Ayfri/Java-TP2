package fr.ayfri.gui.prompts;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Dialog;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import org.jetbrains.annotations.NotNull;

/**
 * @author pierr
 */
public class StringPrompt extends Dialog<String> {
	public StringPrompt(final @NotNull String message, final int minLength, final int maxLength) {
		var content = new VBox(10);
		content.setAlignment(Pos.CENTER);
		content.setPadding(new Insets(15, 25, 15, 25));

		var input = new TextField();
		input.setOnAction(event -> {
			final int length = input.getText().length();
			if (length >= minLength && length <= maxLength) {
				setResult(input.getText());
				close();
			}
		});

		input.setOnKeyReleased(event -> {
			final int length = input.getText().length();
			if (length < minLength || length > maxLength) {
				input.setStyle("-fx-text-fill: red;");
			} else {
				input.setStyle("-fx-text-fill: black;");
			}
		});

		content.getChildren().add(input);
		getDialogPane().setContent(content);
		setTitle(message);
		setHeaderText(message);
	}
}
