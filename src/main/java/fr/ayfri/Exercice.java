package fr.ayfri;

import fr.ayfri.inputs.AbstractInputManager;

public abstract class Exercice<T extends AbstractInputManager> {
	protected String description;
	protected String title;
	public T inputManager;

	public abstract void run();

	public String getDescription() {
		return description;
	}

	public String getTitle() {
		return title;
	}
}
