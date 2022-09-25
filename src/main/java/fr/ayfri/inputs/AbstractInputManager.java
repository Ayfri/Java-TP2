package fr.ayfri.inputs;

import java.util.Scanner;

public abstract class AbstractInputManager {
	protected Scanner scanner = new Scanner(System.in);
	String message;

	public void setPrompt(final String message) {
		this.message = message;
	}
}
