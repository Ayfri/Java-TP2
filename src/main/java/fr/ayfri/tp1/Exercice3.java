package fr.ayfri.tp1;

import fr.ayfri.Exercice;
import fr.ayfri.inputs.CharInputManager;
import fr.ayfri.inputs.NumberInputManager;

/**
 * @author Pierre
 */
public class Exercice3 extends Exercice<NumberInputManager> {
	private final CharInputManager restartInputManager = new CharInputManager("Voulez-vous recommencer ? (O/N) ", new char[]{ 'O', 'N' });

	public Exercice3() {
		title = "TP 1.3 : Nombre binaire";
		description = """
			Écrire un programme permettant de :
				– Transformer un nombre binaire vers son équivalent décimale
			    – Transformer un nombre décimal en binaire
			""".stripIndent();

		inputManager = new NumberInputManager("Rentrer votre choix : ", 0);
		restartInputManager.setCaseInsensitive(true);
	}

	public static void main(String[] args) {
		new Exercice3().run();
	}

	@Override
	public void run() {
		do {
			System.out.println(
				"""
					Voulez-vous convertir :
						1 - Transformer un nombre binaire vers son équivalent décimale
						2 - Transformer un nombre décimal en binaire
						"""
			);

			final int choice = inputManager.getInt();
			switch (choice) {
				case 1 -> {
					System.out.println("Entrez un nombre binaire : ");
					final var binary = inputManager.getLong();
					System.out.printf("%d en binaire vaux %d en décimal%n", binary, binaryToDecimal(binary));
				}
				case 2 -> {
					System.out.println("Entrez un nombre décimal : ");
					final var decimal = inputManager.getLong();
					System.out.printf("%d en décimal vaux %d en binaire%n", decimal, decimalToBinary(decimal));
				}
				default -> System.out.println("Choix invalide");
			}
		} while (restartInputManager.getChar() == 'O');
	}

	public long binaryToDecimal(long binary) {
		var decimal = 0L;
		var i = 0;
		while (binary != 0) {
			decimal += (binary % 10) * Math.pow(2, i);
			++i;
			binary /= 10;
		}
		return decimal;
	}

	public long decimalToBinary(long decimal) {
		var binary = 0L;
		var n = 1L;
		while (decimal != 0) {
			binary += (decimal % 2) * n;
			decimal /= 2;
			n *= 10;
		}
		return binary;
	}
}
