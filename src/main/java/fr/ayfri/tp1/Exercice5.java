package fr.ayfri.tp1;

import fr.ayfri.Exercice;
import fr.ayfri.StringUtils;
import fr.ayfri.inputs.NumberInputManager;

import java.util.Arrays;

/**
 * @author Pierre
 */
public class Exercice5 extends Exercice<NumberInputManager> {
	private final NumberInputManager valueInputManager = new NumberInputManager("");

	public Exercice5() {
		title = "TP 1.4 : Somme";
		description = """
			Écrire et tester une méthode de la classe TP qui calcule la somme des éléments d’un tableau de flottants.
			""".stripIndent();

		inputManager = new NumberInputManager("Entrez la taille du tableau (0 pour terminer) : ", 0);
	}

	public static void main(String[] args) {
		new Exercice5().run();
	}

	@Override
	public void run() {
		int input = inputManager.getInt();
		if (input == 0) return;
		final var array = new double[input];

		for (var i = 0; i < input; i++) {
			valueInputManager.setPrompt("Entrez la valeur de l'élément " + (i + 1) + " : ");
			array[i] = valueInputManager.getDouble();
		}

		final var sum = Arrays.stream(array).sum();
		System.out.println("La somme des éléments du tableau est " + sum);
	}
}
