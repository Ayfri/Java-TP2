package fr.ayfri.inputs;

public class NumberInputManager extends AbstractInputManager {
	String minimumErrorMessage;
	String maximumErrorMessage;

	double minimum;
	double maximum;

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

	public NumberInputManager(final String message) {
		this(message, Double.MIN_VALUE, Double.MAX_VALUE);
	}

	public NumberInputManager(final String message, double minimum) {
		this(message, minimum, Double.MAX_VALUE);
	}

	public NumberInputManager(final String message, final double minimum, final String minimumErrorMessage, final double maximum, final String maximumErrorMessage) {
		this.message = message;
		this.minimum = minimum;
		this.maximum = maximum;
		this.minimumErrorMessage = minimumErrorMessage;
		this.maximumErrorMessage = maximumErrorMessage;
	}

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

	public long getLong() {
		return (long) getDouble();
	}

	public int getInt() {
		return (int) getDouble();
	}
}
