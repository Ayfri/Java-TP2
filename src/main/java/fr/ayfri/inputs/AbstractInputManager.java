package fr.ayfri.inputs;

import org.jetbrains.annotations.NotNull;

import java.util.Scanner;

/**
 * AbstractInputManager est une classe abstraite qui fournit un objet Scanner et un message pour demander une entrée.
 *
 * @author Pierre
 */
public abstract class AbstractInputManager {
	/**
	 * Le scanner pour lire les entrées.
	 */
	protected final @NotNull Scanner scanner = new Scanner(System.in);
	/**
	 * Le message à afficher pour demander une entrée.
	 */
	protected @NotNull String message;

	/**
	 * Setter du message.
	 *
	 * @param message Le message à afficher pour demander une entrée.
	 */
	public void setPrompt(final @NotNull String message) {
		this.message = message;
	}
}
