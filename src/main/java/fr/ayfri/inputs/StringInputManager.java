package fr.ayfri.inputs;

import fr.ayfri.gui.App;
import org.jetbrains.annotations.NotNull;

public class StringInputManager extends AbstractInputManager {
	private int minLength = 0;
	private int maxLength = 4096;

	public StringInputManager(@NotNull String message) {
		this.message = message;
	}

	public @NotNull String getString() {
		if (App.isGui) return menu.stringPrompt(message, minLength, maxLength);

		System.out.print(message);
		return scanner.nextLine();
	}

	public void setMaxLength(final int maxLength) {
		this.maxLength = maxLength;
	}

	public void setMinLength(final int minLength) {
		this.minLength = minLength;
	}
}
