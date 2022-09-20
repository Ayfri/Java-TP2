package fr.ayfri.tp1;

import fr.ayfri.Exercice;
import fr.ayfri.StringUtils;
import fr.ayfri.inputs.NumberInputManager;

import java.util.Arrays;

/**
 * @author Pierre
 */
public class Exercice4 extends Exercice<NumberInputManager> {
	private static final int RESULT_STRING_LENGTH = 6;

	public Exercice4() {
		title = "TP 1.4 : Suite";
		description = """
			Calculer la somme des n premiers termes de la suite
			Un = Un-1 + 1 / n avec n > 0 et U1 = 1
			""".stripIndent();

		inputManager = new NumberInputManager("Entrez le nombre de terme de la suite à calculer n avec n > 0 (0 pour terminer) : ", 0);
	}

	public static void main(String[] args) {
		new Exercice4().run();
	}

	private double getSum(final int n) {
		var sum = 0d;
		for (var i = 1; i <= n; i++) {
			sum += 1d / i;
		}
		return sum;
	}

	private String getFormattedSum(final int n) {
		var sum = getSum(n);
		return StringUtils.formatNumber(String.valueOf(sum), RESULT_STRING_LENGTH);
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
}
