package fr.ayfri;

import fr.ayfri.inputs.AbstractInputManager;
import org.jetbrains.annotations.NotNull;

/**
 * @param <T> Le type du gestionnaire d'entrée.
 *
 * @author Pierre
 * La classe abstraite Exercice permet de créer des exercices.
 */
public abstract class Exercice<T extends AbstractInputManager> {
	/**
	 * La description de l'exercice.
	 */
	protected @NotNull String description;
	/**
	 * Le titre de l'exercice.
	 */
	protected @NotNull String title;

	/**
	 * Le gestionnaire d'entrées.
	 */
	public @NotNull T inputManager;

	/**
	 * La méthode pour exécuter l'exercice.
	 */
	public abstract void run();

	/**
	 * Getter de la description.
	 *
	 * @return La description de l'article.
	 */
	public @NotNull String getDescription() {
		return description;
	}

	/**
	 * Getter du titre.
	 *
	 * @return Le titre de l'article.
	 */
	public @NotNull String getTitle() {
		return title;
	}
}
