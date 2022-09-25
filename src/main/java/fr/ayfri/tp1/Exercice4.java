package fr.ayfri.tp1;

import fr.ayfri.Exercice;
import fr.ayfri.inputs.NumberInputManager;

/**
 * Exercice 4 du TP 1.
 *
 * @author Pierre
 */
public class Exercice4 extends Exercice<NumberInputManager> {
	/**
	 * Constante pour indiquer le nombre de décimales à afficher.
	 */
	private static final int RESULT_STRING_LENGTH = 4;

	/**
	 * Constructeur de l'exercice 4.
	 */
	public Exercice4() {
		title = "TP 1.4 : Suite";
		description = """
				Calculer la somme des n premiers termes de la suite
				Un = Un-1 + 1 / n avec n > 0 et U1 = 1
			""".stripIndent();

		inputManager = new NumberInputManager("Entrez le nombre de terme de la suite à calculer n avec n > 0 (0 pour terminer) : ", 0);
	}

	/**
	 * Créé une instance de l'exercice 4 et l'exécute, permettant de tester l'exercice directement.
	 *
	 * @param args Les arguments de la ligne de commande (non utilisés).
	 */
	public static void main(String[] args) {
		new Exercice4().run();
	}

	@Override
	public void run() {
		int input;
		do {
			input = inputManager.getInt();
			if (input == 0) break;

			System.out.println("La somme des " + input + " premiers termes de la suite est " + getFormattedSum(input));
		} while (true);
	}

	/**
	 * Formate la somme des n premiers termes de la suite.
	 *
	 * @param n Le nombre de termes de la suite à calculer.
	 *
	 * @return La somme des n premiers termes de la suite formatée avec {@link #RESULT_STRING_LENGTH} décimales.
	 */
	private String getFormattedSum(final int n) {
		return String.format("%." + RESULT_STRING_LENGTH + "f", getSum(n));
	}

	/**
	 * Calcule la somme des n premiers termes de la suite.
	 *
	 * @param n Le nombre de termes de la suite à calculer.
	 *
	 * @return La somme des n premiers termes de la suite.
	 */
	private double getSum(final int n) {
		var sum = 0d;
		for (var i = 1; i <= n; i++) {
			sum += 1d / i;
		}
		return sum;
	}
}
