package fr.ayfri.gui.prompts;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Dialog;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import org.jetbrains.annotations.NotNull;

public class BooleanPrompt extends Dialog<Button> {
	public BooleanPrompt(final @NotNull String message) {
		var content = new VBox(10);
		content.setAlignment(Pos.CENTER);
		content.setPadding(new Insets(15, 25, 15, 25));

		var yes = new Button("Oui");
		yes.setPadding(new Insets(10, 20, 10, 20));
		yes.setOnAction(event -> {
			setResult(yes);
			close();
		});

		var no = new Button("Non");
		no.setPadding(new Insets(10, 20, 10, 20));
		no.setOnAction(event -> {
			setResult(no);
			close();
		});

		var buttons = new HBox(10);
		buttons.setAlignment(Pos.CENTER);
		buttons.getChildren().addAll(yes, no);
		content.getChildren().addAll(buttons);

		getDialogPane().setContent(content);
		setTitle(message);
		setHeaderText(message);
	}
}
