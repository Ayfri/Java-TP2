package fr.ayfri.tp1;

import fr.ayfri.Exercice;
import fr.ayfri.inputs.NumberInputManager;

import java.util.Arrays;

/**
 * Exercice 6 du TP 1.
 *
 * @author Pierre
 */
public class Exercice6 extends Exercice<NumberInputManager> {
	/**
	 * Le constructeur de l'exercice 6.
	 */
	public Exercice6() {
		title = "TP 1.6 : Tableau";
		description = """
				Écrire un programme qui demande à l'utilisateur de taper le contenu d'un tableau de réels de 3 lignes et 3 colonnes et qui affiche ce tableau mais en affichant la moyenne des éléments de chaque ligne, de chaque colonne.
			""".stripIndent();

		inputManager = new NumberInputManager("Entrez la taille du tableau (0 pour terminer) : ", 0);
	}

	/**
	 * Créé une instance de l'exercice 6 et l'exécute, permettant de tester l'exercice directement.
	 *
	 * @param args Les arguments de la ligne de commande (non utilisés).
	 */
	public static void main(String[] args) {
		new Exercice6().run();
	}

	@Override
	public void run() {
		final int size = inputManager.getInt();
		if (size == 0) return;
		final var array = new double[size][size];

		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				inputManager.setPrompt("Entrez la valeur de l'élément [" + (i + 1) + ", " + (j + 1) + "] : ");
				array[i][j] = inputManager.getDouble();
			}
		}

		final var grid = new StringBuilder();
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				final var number = array[i][j];
				final var numberString = number % 1 == 0 ? String.valueOf((long) number) : String.valueOf(number);
				final var spaces = " ".repeat(5 - String.valueOf(number).length());
				grid.append(numberString).append(spaces);
			}
			final var average = Arrays.stream(array[i]).average().orElse(0);
			grid.append("(").append(average).append(")\n");
		}

		for (int i = 0; i < size; i++) {
			var sum = 0d;
			for (int j = 0; j < size; j++) {
				sum += array[j][i];
			}
			final var average = sum / size;
			grid.append("(").append(average).append(")\t");
		}

		System.out.println(grid);
	}
}
