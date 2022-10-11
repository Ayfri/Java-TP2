package fr.ayfri.tp2;

import fr.ayfri.Exercice;
import fr.ayfri.inputs.NumberInputManager;
import org.jetbrains.annotations.NotNull;

/**
 * Exercice 3 du TP 1.
 *
 * @author Pierre
 */
public final class Exercice3 extends Exercice<NumberInputManager> {
	/**
	 * Constructeur de l'exercice 3.
	 */
	public Exercice3() {
		title = "TP 2.3 - Impôts";
		description = """
				Écrire une fonction MesImpôts qui prend en paramètre vos gaines de l’année et qui calcule vos impôts à payer en 2022.
			""".stripIndent();

		inputManager = new NumberInputManager("Vos gains annuels : ", 0);
		count++;
	}

	/**
	 * Calcule les impôts à payer.
	 *
	 * @param gains Les gains de l'année.
	 *
	 * @return Les impôts à payer.
	 */
	public static double calculate(final double gains) {
		final var taux = (gains <= 10225) ? 0 : (gains <= 26070) ? 0.11 : (gains <= 74545) ? 0.3 : (gains <= 160336) ? 0.41 : 0.45;
		return taux * gains;
	}

	@Override
	public void run() {
		final var gains = inputManager.getDouble();
		System.out.printf("Vous devez payer %.2f€ d'impôts.", calculate(gains));
	}

	/**
	 * Créé une instance de l'exercice 3 et l'exécute, permettant de tester l'exercice directement.
	 *
	 * @param args Les arguments de la ligne de commande (non utilisés).
	 */
	public static void main(final String @NotNull [] args) {
		new Exercice3().run();
	}
}
