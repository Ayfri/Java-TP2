package fr.ayfri.tp2;

import fr.ayfri.Exercice;
import fr.ayfri.inputs.NumberInputManager;
import org.jetbrains.annotations.NotNull;

/**
 * Exercice 1 du TP 1.
 *
 * @author Pierre
 */
public class Exercice1 extends Exercice<NumberInputManager> {
	/**
	 * Constructeur de l'exercice 1.
	 */
	public Exercice1() {
		title = "TP 2.1 : Méthode d'Archimède 1/2";
		description = """
				Créer une méthode Cn de la classe Archimede qui prend :
					» X un double >=0
					» Y un double >=0
					La méthode calcule la valeur 2 * x * y / (x + y) : Utilisation Archimede.Cn(X, Y)
				Tester la Méthode Archimede.Cn
				Créer une méthode In de la classe Archimède qui prend :
					» X un double >=0
					» Y un double >=0
					La méthode calcule la valeur sqrt(x * y) : Utilisation Archimede.In(X, Y)
				Tester la Méthode Archimede.In
			""".stripIndent();

		inputManager = new NumberInputManager("Entrez une valeur positive : ", 0);
	}

	public static final class Archimede {
		public double Cn(double x, double y) {
			return 2 * x * y / (x + y);
		}

		public double In(double x, double y) {
			return Math.sqrt(x * y);
		}
	}

	/**
	 * Créé une instance de l'exercice 1 et l'exécute, permettant de tester l'exercice directement.
	 *
	 * @param args Les arguments de la ligne de commande (non utilisés).
	 */
	public static void main(String @NotNull [] args) {
		new Exercice1().run();
	}

	@Override
	public void run() {
		final var archimede = new Archimede();

		final var x = inputManager.getInt();
		final var y = inputManager.getInt();

		System.out.printf("Cn(%d, %d) = %s%n", x, y, archimede.Cn(x, y));
		System.out.printf("In(%d, %d) = %s%n", x, y, archimede.In(x, y));
	}
}
