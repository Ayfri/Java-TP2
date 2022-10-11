package fr.ayfri.inputs;

import fr.ayfri.gui.App;
import org.jetbrains.annotations.NotNull;

/**
 * BooleanInputManager est une classe qui permet de demander un booléen à l'utilisateur.
 *
 * @author Pierre
 */
public class BooleanInputManager extends AbstractInputManager {
	/**
	 * Crée un nouveau gestionnaire d'entrées pour les booléens.
	 *
	 * @param message Le message à afficher pour demander une entrée.
	 */
	public BooleanInputManager(@NotNull final String message) {
		this.message = message;
	}

	/**
	 * Demande à l'utilisateur d'entrer un booléen et le retourne.
	 *
	 * @return Le booléen entré par l'utilisateur.
	 */
	public boolean getBoolean() {
		if (App.usingGUI) return menu.booleanPrompt(message);

		var result = false;
		var validInput = false;
		do {
			System.out.print(message);

			switch (scanner.nextLine().toLowerCase()) {
				case "true", "1", "yes", "y" -> {
					result = true;
					validInput = true;
				}
				case "false", "0", "no", "n" -> validInput = true;
			}
		} while (!validInput);

		return result;
	}
}
