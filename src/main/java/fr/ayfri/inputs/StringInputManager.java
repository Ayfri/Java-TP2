package fr.ayfri.inputs;

import org.jetbrains.annotations.NotNull;

public class StringInputManager extends AbstractInputManager {
	public StringInputManager(@NotNull String message) {
		this.message = message;
	}

	public @NotNull String getString() {
		System.out.print(message);
		return scanner.nextLine();
	}
}
