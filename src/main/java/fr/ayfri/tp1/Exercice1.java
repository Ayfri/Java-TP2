package fr.ayfri.tp1;

import fr.ayfri.Exercice;
import fr.ayfri.inputs.NumberInputManager;

/**
 * @author Pierre
 */
public class Tp01 extends Exercice<NumberInputManager> {
	public Tp01() {
		title = "TP 1";
		description = """
				Écrire un programme qui calcule la racine carrée de nombres fournis par l’utilisateur.
				Ce programme devra afficher une erreur si l’utilisateur fournit des valeurs négatives, et s’arrêter lorsque l’utilisateur entre la valeur 0.
			""".stripIndent();

		inputManager = new NumberInputManager("Entrez une valeur positive (0 pour quitter) : ", 0);
	}

	public static void main(String[] args) {
		new Tp01().run();
	}

	@Override
	public void run() {
		int a;

		do {
			a = inputManager.getInt();
			if (a != 0) {
				System.out.println("La racine carrée de " + a + " est " + getSqrt(a));
			}
		} while (a != 0);
		System.out.println("Fin du programme.");
	}

	private double getSqrt(int a) {
		return Math.sqrt(a);
	}
}
