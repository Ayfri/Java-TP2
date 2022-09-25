package fr.ayfri.tp1;

import fr.ayfri.Exercice;
import fr.ayfri.inputs.NumberInputManager;

/**
 * Exercice 2 du TP 1.
 *
 * @author Pierre
 */
public class Exercice2 extends Exercice<NumberInputManager> {

	/**
	 * Constante pour le caractère "Rempli" pour le dessin du sapin.
	 */
	private static final String FULL = "*";
	/**
	 * Constante pour le caractère "Espace" pour le dessin du sapin.
	 */
	private static final String SPACE = "=";

	/**
	 * Constructeur de l'exercice 2.
	 */
	public Exercice2() {
		title = "TP 1.2 : Arbre de noel";
		description = """
				Afficher un arbre de Noel en utilisant les symboles = et *. La hauteur de l’arbre sera donnée par l’utilisateur.
			""".stripIndent();

		inputManager = new NumberInputManager("Hauteur de l'arbre : ", 0);
	}

	/**
	 * Créé une instance de l'exercice 2 et l'exécute, permettant de tester l'exercice directement.
	 *
	 * @param args Les arguments de la ligne de commande (non utilisés).
	 */
	public static void main(String[] args) {
		new Exercice2().run();
	}

	@Override
	public void run() {
		final int height = inputManager.getInt();
		final int width = height * 2 - 1;
		final int middle = width / 2;
		final var builder = new StringBuilder();

		for (int i = 0; i < height; i++) {
			builder.append(SPACE.repeat(middle - i));
			builder.append(FULL.repeat(i * 2 + 1));
			builder.append(SPACE.repeat(middle - i));
			builder.append("\n");
		}

		for (int i = 0; i < 2; i++) {
			builder.append(SPACE.repeat(middle - i));
			builder.append(FULL.repeat(i * 2 + 1));
			builder.append(SPACE.repeat(middle - i));
			builder.append("\n");
		}

		System.out.println(builder);
	}
}
