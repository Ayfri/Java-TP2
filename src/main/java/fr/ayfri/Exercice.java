package fr.ayfri;

import fr.ayfri.inputs.AbstractInputManager;

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
	protected String description;
	/**
	 * Le titre de l'exercice.
	 */
	protected String title;

	/**
	 * Le gestionnaire d'entrées.
	 */
	public T inputManager;

	/**
	 * La méthode pour exécuter l'exercice.
	 */
	public abstract void run();

	/**
	 * Getter de la description.
	 *
	 * @return La description de l'article.
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Getter du titre.
	 *
	 * @return Le titre de l'article.
	 */
	public String getTitle() {
		return title;
	}
}
