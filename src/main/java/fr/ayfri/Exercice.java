package fr.ayfri;

import fr.ayfri.inputs.AbstractInputManager;

public abstract class Exercice<T extends AbstractInputManager> {
	protected String title;
	protected String description;
	public T inputManager;

	public abstract void run();

	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}
}
