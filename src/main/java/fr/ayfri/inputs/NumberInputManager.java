package fr.ayfri.inputs;

/**
 * NumberInputManager est un gestionnaire d'entrées qui permet de demander un nombre.
 *
 * @author Pierre
 */
public class NumberInputManager extends AbstractInputManager {
	/**
	 * Le nombre maximum.
	 * Valeur par défaut : {@link Double#MAX_VALUE}
	 */
	double maximum;
	/**
	 * Le message d'erreur si l'utilisateur entre un nombre trop grand.
	 */
	String maximumErrorMessage;

	/**
	 * Le nombre minimum.
	 * Valeur par défaut : -{@link Double#MAX_VALUE}
	 */
	double minimum;
	/**
	 * Le message d'erreur si l'utilisateur entre un nombre trop petit.
	 */
	String minimumErrorMessage;

	/**
	 * Crée un nouveau gestionnaire d'entrées pour les nombres.
	 *
	 * @param message Le message à afficher pour demander une entrée.
	 */
	public NumberInputManager(final String message) {
		this(message, -Double.MAX_VALUE, Double.MAX_VALUE);
	}

	/**
	 * Crée un nouveau gestionnaire d'entrées pour les nombres.
	 *
	 * @param message Le message à afficher pour demander une entrée.
	 * @param minimum Le nombre minimum.
	 * @param maximum Le nombre maximum.
	 */
	public NumberInputManager(final String message, final double minimum, final double maximum) {
		this.message = message;
		this.minimum = minimum;
		this.maximum = maximum;

		if (minimum == 0) {
			minimumErrorMessage = "Erreur, la valeur ne peut pas être negative.";
		} else {
			minimumErrorMessage = "Erreur, le nombre doit être supérieur ou égal à " + (long) minimum + ".";
		}

		maximumErrorMessage = "Erreur, le nombre doit être inférieur ou égal à " + (long) maximum + ".";
	}

	/**
	 * Demande à l'utilisateur d'entrer un nombre et le retourne.
	 *
	 * @param message Le message à afficher pour demander une entrée.
	 * @param minimum Le nombre minimum.
	 */
	public NumberInputManager(final String message, double minimum) {
		this(message, minimum, Double.MAX_VALUE);
	}

	/**
	 * Demande à l'utilisateur d'entrer un nombre et le retourne en tant que {@code int}.
	 *
	 * @return Le nombre entré par l'utilisateur.
	 */
	public int getInt() {
		return (int) getDouble();
	}

	/**
	 * Demande à l'utilisateur d'entrer un nombre et le retourne en tant que {@code double}.
	 *
	 * @return Le nombre entré par l'utilisateur.
	 */
	public double getDouble() {
		double value = Double.NaN;
		do {
			System.out.print(message);
			if (!scanner.hasNextDouble()) continue;

			value = scanner.nextDouble();

			if (value < minimum) System.out.println(minimumErrorMessage);
			else if (value > maximum) System.out.println(maximumErrorMessage);
		} while (value < minimum || value > maximum);

		return value;
	}

	/**
	 * Demande à l'utilisateur d'entrer un nombre et le retourne en tant que {@code long}.
	 *
	 * @return Le nombre entré par l'utilisateur.
	 */
	public long getLong() {
		return (long) getDouble();
	}
}
