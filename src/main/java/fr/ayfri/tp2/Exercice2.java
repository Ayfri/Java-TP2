package fr.ayfri.tp2;

import fr.ayfri.Exercice;
import fr.ayfri.inputs.NumberInputManager;
import org.jetbrains.annotations.NotNull;

/**
 * Exercice 2 du TP 1.
 *
 * @author Pierre
 */
public final class Exercice2 extends Exercice<NumberInputManager> {

	/**
	 * Constructeur de l'exercice 2.
	 */
	public Exercice2() {
		title = "TP 2.2 : Méthode d'Archimède 2/2";
		description = """
				Écrire la méthode An (et la tester) qui code l’algorithme (en utilisant l’exercice 2.1) N est un entier passé en paramètre.
					X = 4
					Y = 2*sqrt(2)
					Pour i = 1 jusqu’à N faire:
						X = Archimede.Cn(X ,Y)
						Y = Archimede.In(X ,Y)
					Renvois un tableau contenant X et Y.
			""".stripIndent();

		inputManager = new NumberInputManager("Tester l'algorithme avec un entier positif : ", 0);
		count++;
	}

	/**
	 * Créé une instance de l'exercice 2 et l'exécute, permettant de tester l'exercice directement.
	 *
	 * @param args Les arguments de la ligne de commande (non utilisés).
	 */
	public static void main(final String @NotNull [] args) {
		new Exercice2().run();
	}

	/**
	 * Méthode An.
	 *
	 * @param n Nombre d'itérations.
	 *
	 * @return Un tableau contenant X et Y.
	 */
	public double @NotNull [] An(final int n) {
		final var archimede = new Exercice1.Archimede();
		double x = 4;
		double y = 2 * 1.4142135623730951;

		for (int i = 1; i <= n; i++) {
			x = archimede.Cn(x, y);
			y = archimede.In(x, y);
		}

		return new double[]{ x, y };
	}

	@Override
	public void run() {
		final var n = inputManager.getInt();
		final var result = An(n);
		System.out.printf("X = %s%nY = %s%n", result[0], result[1]);
	}
}
