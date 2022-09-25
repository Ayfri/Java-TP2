package fr.ayfri;

import fr.ayfri.inputs.CharInputManager;
import fr.ayfri.tp1.Exercice1;
import fr.ayfri.tp1.Exercice2;
import fr.ayfri.tp1.Exercice3;
import fr.ayfri.tp1.Exercice4;
import fr.ayfri.tp1.Exercice5;
import fr.ayfri.tp1.Exercice6;
import org.jetbrains.annotations.NotNull;

public final class Main {
	private static final char EXIT_CHAR = 'q';

	private Main() {}

	public static void main(String @NotNull [] args) {
		final var menu = new Menu();
		menu.addExercice(new Exercice1());
		menu.addExercice(new Exercice2());
		menu.addExercice(new Exercice3());
		menu.addExercice(new Exercice4());
		menu.addExercice(new Exercice5());
		menu.addExercice(new Exercice6());

		final var numberOfExercices = menu.getExerciceCount();
		final var validChars = new char[numberOfExercices + 1];
		validChars[0] = EXIT_CHAR;

		for (int i = 0; i < numberOfExercices; i++) {
			validChars[i + 1] = String.valueOf(i + 1).charAt(0);
		}

		final var inputManager = new CharInputManager("Entrez le numéro de l'exercice à exécuter (q pour quitter): ", "Numéro d'exercice invalide.", validChars);

		char input;
		do {
			menu.showMenu();
			input = inputManager.getChar();
			if (input != EXIT_CHAR) {
				menu.execute(input - 1 - '0');
				System.out.println("Fin du programme.");
			}
		} while (input != EXIT_CHAR);
		System.out.println("Au revoir !");
	}
}