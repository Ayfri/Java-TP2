package fr.ayfri;

public class StringUtils {
	private StringUtils() {
	}

	public static String formatNumber(final String string, final int length) {
		return string.length() > length ? string.substring(0, length) : padNumber(string, length);
	}

	public static String padNumber(final String number, final int length) {
		return padLeft(number, length, '0');
	}
	public static String padLeft(final String string, final int length, final char padChar) {
		return String.format("%" + length + "s", string).replace(' ', padChar);
	}
}
