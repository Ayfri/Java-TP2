package fr.ayfri.tp2;

import fr.ayfri.Exercice;
import fr.ayfri.inputs.NumberInputManager;
import org.jetbrains.annotations.NotNull;

/**
 * Exercice 4 du TP 1.
 *
 * @author Pierre
 */
public class Exercice4 extends Exercice<NumberInputManager> {

	/**
	 * Constructeur de l'exercice 4.
	 */
	public Exercice4() {
		title = "TP 2.4 : Chance Euro millions";
		description = """
				Créer la fonction Factoriel qui prend en paramètre un entier n > 0 et qui calcul le factoriel de n!.
				Créer la fonction Cnp qui prend en paramètre 2 entiers n > 0 et p > 0 et qui calcule Cnp = n! / ((n-p)! * p!).
				Tester la fonction Cnp et ensuite faites le calcul Cnp(50,5) * Cnp(11,2), il doit être égal à 116 531 800.
			""".stripIndent();

		inputManager = new NumberInputManager("Tester la fonction Cnp avec : ", 0);
		count++;
	}

	/**
	 * Créé une instance de l'exercice 4 et l'exécute, permettant de tester l'exercice directement.
	 *
	 * @param args Les arguments de la ligne de commande (non utilisés).
	 */
	public static void main(String @NotNull [] args) {
		new Exercice4().run();
	}

	@Override
	public void run() {
		final var n = inputManager.getLong();
		inputManager.setMaximum(n);
		final var p = inputManager.getLong();

		System.out.printf("Cnp(%d, %d) = %.0f%n", n, p, cnp(n, p));

		final var n2 = inputManager.getLong();
		inputManager.setMaximum(n2);
		final var p2 = inputManager.getLong();

		System.out.printf("Cnp(%d, %d) = %f%n", n2, p2, cnp(n2, p2));
		System.out.printf("Cnp(%d, %d) * Cnp(%d, %d) = %.0f%n", n, p, n2, p2, cnp(n, p) * cnp(n2, p2));

		System.out.printf("Cnp(50, 5) * Cnp(11, 2) = %.0f%n", cnp(50, 5) * cnp(11, 2));
	}

	private static double cnp(double n, double p) {
		return factorial(n) / (factorial(p) * factorial(n - p));
	}

	private static double factorial(double n) {
		var result = 1d;
		for (var i = 1L; i <= n; i++) {
			result *= i;
		}
		return result;
	}
}
