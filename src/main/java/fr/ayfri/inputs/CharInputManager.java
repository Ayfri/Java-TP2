package fr.ayfri.inputs;

import java.util.Scanner;

public class CharInputManager extends AbstractInputManager {
	String invalidInputMessage;

	char[] validInputs;

	public CharInputManager(final String message, final char[] validInputs) {
		this(message, "Erreur, la valeur entrée est invalide.", validInputs);
	}

	public CharInputManager(final String message, final String invalidInputMessage, final char[] validInputs) {
		this.message = message;
		this.invalidInputMessage = invalidInputMessage;
		this.validInputs = validInputs;
	}

	public char getChar() {
		char value;
		do {
			System.out.print(message);
			value = scanner.nextLine().charAt(0);

			if (!isValidInput(value)) {
				System.out.println(invalidInputMessage);
			}
		} while (!isValidInput(value));

		return value;
	}

	public boolean isValidInput(char input) {
		for (char validInput : validInputs) {
			if (input == validInput) {
				return true;
			}
		}

		return false;
	}
}
