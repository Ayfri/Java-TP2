package fr.ayfri.tp1;

import fr.ayfri.Exercice;
import fr.ayfri.inputs.CharInputManager;
import fr.ayfri.inputs.NumberInputManager;

/**
 * Exercice 3 du TP 1.
 *
 * @author Pierre
 */
public class Exercice3 extends Exercice<NumberInputManager> {
	/**
	 * Un gestionnaire d'entrées pour recommencer ou non l'exercice.
	 */
	private final CharInputManager restartInputManager = new CharInputManager("Voulez-vous recommencer ? (O/N) ", new char[]{ 'O', 'N' });

	/**
	 * Constructeur de l'exercice 3.
	 */
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

	/**
	 * Créé une instance de l'exercice 3 et l'exécute, permettant de tester l'exercice directement.
	 *
	 * @param args Les arguments de la ligne de commande (non utilisés).
	 */
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

	/**
	 * Convertit un nombre binaire en décimal.
	 *
	 * @param binary Le nombre binaire à convertir.
	 *
	 * @return Le nombre binaire converti en décimal.
	 */
	private long binaryToDecimal(long binary) {
		return Long.parseLong(Long.toString(binary), 2);
	}

	/**
	 * Convertit un nombre décimal en binaire.
	 *
	 * @param decimal Le nombre décimal à convertir.
	 *
	 * @return Le nombre décimal converti en binaire.
	 */
	private long decimalToBinary(long decimal) {
		return Long.parseLong(Long.toBinaryString(decimal));
	}
}
