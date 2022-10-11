package fr.ayfri.inputs;

import fr.ayfri.gui.App;
import org.jetbrains.annotations.NotNull;

/**
 * StringInputManager est un gestionnaire d'entrées qui permet de demander une chaîne de caractères.
 *
 * @author Pierre
 */
public class StringInputManager extends AbstractInputManager {
	/**
	 * Propriété pour la longueur minimale de la chaîne de caractères.
	 */
	private int minLength = 0;
	/**
	 * Propriété pour la longueur maximale de la chaîne de caractères.
	 */
	private int maxLength = 4096;

	/**
	 * Crée un nouveau gestionnaire d'entrées pour les chaînes de caractères.
	 *
	 * @param message Le message à afficher pour demander une entrée.
	 */
	public StringInputManager(@NotNull final String message) {
		this.message = message;
	}

	/**
	 * Demande à l'utilisateur d'entrer une chaîne de caractères et la retourne.
	 *
	 * @return La chaîne de caractères entrée par l'utilisateur.
	 */
	public @NotNull String getString() {
		if (App.usingGUI) return menu.stringPrompt(message, minLength, maxLength);

		System.out.print(message);
		return scanner.nextLine();
	}

	/**
	 * Setter pour la longueur minimale de la chaîne de caractères.
	 *
	 * @param maxLength La longueur maximale de la chaîne de caractères.
	 */
	public void setMaxLength(final int maxLength) {
		this.maxLength = maxLength;
	}

	/**
	 * Setter pour la longueur maximale de la chaîne de caractères.
	 *
	 * @param minLength La longueur minimale de la chaîne de caractères.
	 */
	public void setMinLength(final int minLength) {
		this.minLength = minLength;
	}
}
