package fr.ayfri.tp1;

import fr.ayfri.Exercice;
import fr.ayfri.inputs.NumberInputManager;

/**
 * @author Pierre
 */
public class Exercice2 extends Exercice<NumberInputManager> {

	private static final String SPACE = "=";
	public static final String FULL = "*";

	public Exercice2() {
		title = "TP 1.2 : Arbre de noel";
		description = """
				Afficher un arbre de Noel en utilisant les symboles = et *. La hauteur de l’arbre sera donnée par l’utilisateur.
			""".stripIndent();

		inputManager = new NumberInputManager("Hauteur de l'arbre : ", 0);
	}

	public static void main(String[] args) {
		new Exercice2().run();
	}

	@Override
	public void run() {
		final var height = inputManager.getInt();
		final var width = height * 2 - 1;
		final var middle = width / 2;
		final var builder = new StringBuilder();

		for (var i = 0; i < height; i++) {
			builder.append(SPACE.repeat(middle - i));
			builder.append(FULL.repeat(i * 2 + 1));
			builder.append(SPACE.repeat(middle - i));
			builder.append("\n");
		}

		for (var i = 0; i < 2; i++) {
			builder.append(SPACE.repeat(middle - i));
			builder.append(FULL.repeat(i * 2 + 1));
			builder.append(SPACE.repeat(middle - i));
			builder.append("\n");
		}

		System.out.println(builder);
	}
}
