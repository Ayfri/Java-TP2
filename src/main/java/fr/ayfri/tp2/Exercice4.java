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
		final var n = inputManager.getInt();
		final var p = inputManager.getInt();

		System.out.printf("Cnp(%d, %d) = %s%n", n, p, Cnp(n, p));
	}

	public static int Factoriel(int n) {
		int result = 1;
		for (int i = 1; i <= n; i++) {
			result *= i;
		}
		return result;
	}

	public static int Cnp(int n, int p) {
		int result;
		result = Factoriel(n) / (Factoriel(n - p) * Factoriel(p));
		return result;
	}
}
