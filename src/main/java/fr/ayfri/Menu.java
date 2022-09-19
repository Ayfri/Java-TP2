package fr.ayfri;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Pierre
 */
public final class Menu {
	private final ArrayList<Exercice> exercices = new ArrayList<>();

	public void addExercice(Exercice exercice) {
		exercices.add(exercice);
	}

	public List<Exercice> getExercices() {
		return exercices;
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
