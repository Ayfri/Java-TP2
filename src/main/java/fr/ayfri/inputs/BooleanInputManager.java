package fr.ayfri.inputs;

import org.jetbrains.annotations.NotNull;

public class BooleanInputManager extends AbstractInputManager {
	public BooleanInputManager(@NotNull String message) {
		this.message = message;
	}

	public boolean getBoolean() {
		if (isGui) {
			return menu.booleanPrompt(message);
		}

		boolean result = false;
		boolean validInput = false;
		do {
			System.out.print(message);

			switch (scanner.nextLine().toLowerCase()) {
				case "true", "1", "yes", "y" -> {
					result = true;
					validInput = true;
				}
				case "false", "0", "no", "n" -> validInput = true;
			}
		} while (!validInput);

		return result;
	}
}
