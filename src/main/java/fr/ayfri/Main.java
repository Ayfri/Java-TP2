package fr.ayfri;

import fr.ayfri.inputs.CharInputManager;
import fr.ayfri.tp1.Tp01;

import java.util.List;

public class Main {
	private static final char EXIT_CHAR = 'q';

	public static void main(String[] args) {
		var menu = new Menu();
		menu.addExercice(new Tp01());

		var numberOfExercices = menu.getExerciceCount();
		var validChars = new char[numberOfExercices + 1];
		validChars[0] = EXIT_CHAR;

		for (var i = 0; i < numberOfExercices; i++) {
			validChars[i + 1] = String.valueOf(i).charAt(0);
		}

		var inputManager = new CharInputManager("Entrez le numéro de l'exercice à exécuter (q pour quitter): ", "Numéro d'exercice invalide.", validChars);

		char input;
		do {
			menu.showMenu();
			input = inputManager.getChar();
			if (input != EXIT_CHAR) {
				menu.execute(input - '0');
			}
		} while (input != EXIT_CHAR);
		System.out.println("Au revoir !");
	}
}