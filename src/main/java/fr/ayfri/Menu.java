package fr.ayfri;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Pierre
 */
public final class Menu {
	private final @NotNull List<Exercice> exercices = new ArrayList<>();

	public void addExercice(@NotNull Exercice exercice) {
		exercices.add(exercice);
	}

	public int getExerciceCount() {
		return exercices.size();
	}

	public void execute(int index) {
		exercices.get(index).run();
	}

	public void showMenu() {
		System.out.println("Menu de sélection d'exercice :");
		for (int i = 0, exercicesSize = exercices.size(); i < exercicesSize; i++) {
			final var exercice = exercices.get(i);
			System.out.printf("%d - %s :%n%s", i + 1, exercice.getTitle(), exercice.getDescription());
		}
		System.out.println();
	}
}
