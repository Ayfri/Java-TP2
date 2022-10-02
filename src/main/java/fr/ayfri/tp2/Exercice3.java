package fr.ayfri.tp2;

import fr.ayfri.Exercice;
import fr.ayfri.inputs.NumberInputManager;
import org.jetbrains.annotations.NotNull;

import java.math.BigInteger;

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

		inputManager = new NumberInputManager("Entrez un nombre", 0);
	}

	/**
	 * Créé une instance de l'exercice 3 et l'exécute, permettant de tester l'exercice directement.
	 *
	 * @param args Les arguments de la ligne de commande (non utilisés).
	 */
	public static void main(String @NotNull [] args) {
		new Exercice3().run();
	}

	@Override
	public void run() {
		var n = BigInteger.valueOf(inputManager.getInt());
		var nFact = fact(n);
		System.out.println(n + "! = " + nFact);

		var first = BigInteger.valueOf(inputManager.getInt());
		var second = BigInteger.valueOf(inputManager.getInt());
		var combination = combination(first, second);
		System.out.println(first + " parmi " + second + " = " + combination);
	}

	private @NotNull BigInteger fact(BigInteger n) {
		var result = BigInteger.ONE;
		for (int i = 1; i <= n.intValue(); i++) {
			result = result.multiply(BigInteger.valueOf(i));
		}
		return result;
	}

	private BigInteger combination(@NotNull BigInteger n, @NotNull BigInteger p) {
		BigInteger result;
		result = fact(n).divide(fact(p).multiply(fact(n.subtract(p))));
		return result;
	}
}
