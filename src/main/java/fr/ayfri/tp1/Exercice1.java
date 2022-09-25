package fr.ayfri.tp1;

import fr.ayfri.Exercice;
import fr.ayfri.inputs.NumberInputManager;

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
		title = "TP 1.1 : Racine d’un nombre";
		description = """
				Écrire un programme qui calcule la racine carrée de nombres fournis par l’utilisateur.
				Ce programme devra afficher une erreur si l’utilisateur fournit des valeurs négatives, et s’arrêter lorsque l’utilisateur entre la valeur 0.
			""".stripIndent();

		inputManager = new NumberInputManager("Entrez une valeur positive (0 pour quitter) : ", 0);
	}

	/**
	 * Créé une instance de l'exercice 1 et l'exécute, permettant de tester l'exercice directement.
	 *
	 * @param args Les arguments de la ligne de commande (non utilisés).
	 */
	public static void main(String[] args) {
		new Exercice1().run();
	}

	@Override
	public void run() {
		long a;
		do {
			a = inputManager.getLong();
			if (a != 0) {
				System.out.println("La racine carrée de " + a + " est " + getSqrt(a));
			}
		} while (a != 0);
	}

	/**
	 * Calcule la racine carrée d'un nombre.
	 *
	 * @param number La valeur dont on veut la racine carrée.
	 *
	 * @return La racine carrée de {@code number}.
	 */
	private double getSqrt(long number) {
		return Math.sqrt(number);
	}
}
