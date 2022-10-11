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
 * Menu graphique de l'application.
 *
 * @author Pierre
 */
public final class Menu extends VBox {

	/**
	 * Stage de l'application.
	 */
	private final Stage stage;

	/**
	 * Constructeur du menu.
	 *
	 * @param stage Stage de l'application.
	 */
	public Menu(@NotNull final Stage stage) {
		this.stage = stage;
	}

	/**
	 * Affiche un dialogue pour demander une booléenne.
	 *
	 * @param message Message à afficher.
	 *
	 * @return Réponse de l'utilisateur.
	 */
	public boolean booleanPrompt(final String message) {
		try {
			final var dialog = new BooleanPrompt(message);
			final var result = dialog.showAndWait();
			return result.isPresent() && "Oui".equals(result.get().getText());
		} catch (final Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Affiche un dialogue pour demander un caractère.
	 *
	 * @param message       Message à afficher.
	 * @param allowedChars  Caractères autorisés.
	 * @param caseSensitive Sensibilité à la casse.
	 *
	 * @return Réponse de l'utilisateur.
	 */
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

	/**
	 * Affiche un dialogue pour demander un nombre flottant.
	 *
	 * @param message Message à afficher.
	 * @param min     Valeur minimale.
	 * @param max     Valeur maximale.
	 *
	 * @return Réponse de l'utilisateur.
	 */
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

	/**
	 * Affiche un dialogue pour demander un nombre entier.
	 *
	 * @param message Message à afficher.
	 * @param min     Valeur minimale.
	 * @param max     Valeur maximale.
	 *
	 * @return Réponse de l'utilisateur.
	 */
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

	/**
	 * Affiche l'interface graphique.
	 *
	 * @throws IOException Si le fichier FXML n'a pas pu être chargé.
	 */
	public void show() throws IOException {
		final var myFxmlURL = ClassLoader.getSystemResource("layout.fxml");
		final var fxmlLoader = new FXMLLoader(Objects.requireNonNull(myFxmlURL));
		fxmlLoader.load();
		final VBox root = fxmlLoader.getRoot();

		stage.setScene(new Scene(root, 1600, 900));
		stage.show();
	}

	/**
	 * Affiche un dialogue pour demander une chaîne de caractères.
	 *
	 * @param message   Message à afficher.
	 * @param minLength Longueur minimale.
	 * @param maxLength Longueur maximale.
	 *
	 * @return Réponse de l'utilisateur.
	 */
	public String stringPrompt(final String message, final int minLength, final int maxLength) {
		try {
			final var dialog = new StringPrompt(message, minLength, maxLength);
			final var optionalResult = dialog.showAndWait();
			return optionalResult.orElse("");
		} catch (final Exception e) {
			e.printStackTrace();
			return "";
		}
	}
}
