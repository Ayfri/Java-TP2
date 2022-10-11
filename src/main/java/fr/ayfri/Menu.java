package fr.ayfri;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

/**
 * La classe Menu permet de créer le menu des exercices.
 *
 * @author Pierre
 */
public final class Menu {
	/**
	 * La liste des exercices.
	 */
	private final @NotNull List<Exercice<?>> exercices = new ArrayList<>();

	/**
	 * Ajoute un exercice à la liste des exercices.
	 *
	 * @param exercice L'exercice à ajouter à la liste.
	 */
	public void addExercice(@NotNull final Exercice<?> exercice) {
		exercices.add(exercice);
	}

	/**
	 * Lance l'exercice correspondant au numéro donné.
	 *
	 * @param index L'index de l'exercice à exécuter.
	 */
	public void execute(final int index) {
		exercices.get(index).run();
	}

	/**
	 * Affiche le menu des exercices.
	 */
	public void showMenu() {
		System.out.println("Menu de sélection d'exercice :");
		for (int i = 0, exercicesSize = exercices.size(); i < exercicesSize; i++) {
			final var exercice = exercices.get(i);
			System.out.printf("%d - %s :%n%s\n", i + 1, exercice.getTitle(), exercice.getDescription());
		}
	}

	/**
	 * Retourne le nombre d'exercices.
	 *
	 * @return Le nombre d'exercices dans la liste.
	 */
	public int getExerciceCount() {
		return exercices.size();
	}
}
