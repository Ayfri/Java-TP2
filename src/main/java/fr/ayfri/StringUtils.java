package fr.ayfri;

public final class StringUtils {
	private StringUtils() {
	}

	public static String formatNumberRequiredLength(final String number, final int length) {
		return number.length() > length ? number.substring(0, length) : padNumber(number, length);
	}

	public static String padNumber(final String number, final int length) {
		return padLeft(number, length, '0');
	}

	public static String padLeft(final String string, final int length, final char padChar) {
		return String.format("%" + length + "s", string).replace(' ', padChar);
	}
}
