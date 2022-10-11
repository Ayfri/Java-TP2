package fr.ayfri.inputs;

import fr.ayfri.gui.Menu;
import org.jetbrains.annotations.NotNull;

import java.util.Scanner;

/**
 * AbstractInputManager est une classe abstraite qui fournit un objet Scanner et un message pour demander une entrée.
 *
 * @author Pierre
 */
public abstract class AbstractInputManager {
	/**
	 * Le menu graphique pour demander une entrée.
	 */
	protected static Menu menu = null;

	/**
	 * Le scanner pour lire les entrées.
	 */
	protected final @NotNull Scanner scanner = new Scanner(System.in);
	/**
	 * Le message à afficher pour demander une entrée.
	 */
	protected @NotNull String message = "";

	/**
	 * Setter du menu.
	 *
	 * @param menu Le menu de l'application.
	 */
	public static void setMenu(final @NotNull Menu menu) {
		AbstractInputManager.menu = menu;
	}

	/**
	 * Setter du message.
	 *
	 * @param message Le message à afficher pour demander une entrée.
	 */
	public void setPrompt(final @NotNull String message) {
		this.message = message;
	}
}
