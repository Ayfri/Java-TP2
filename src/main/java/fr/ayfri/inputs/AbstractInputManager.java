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
	protected static boolean isGui = false;
	protected static Menu menu;

	/**
	 * Le scanner pour lire les entrées.
	 */
	protected final @NotNull Scanner scanner = new Scanner(System.in);
	/**
	 * Le message à afficher pour demander une entrée.
	 */
	protected @NotNull String message;

	public static void setIsGui(final boolean isGui, final @NotNull Menu menu) {
		AbstractInputManager.isGui = isGui;
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
