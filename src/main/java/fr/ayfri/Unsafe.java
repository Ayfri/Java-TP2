package fr.ayfri;

import java.lang.reflect.InvocationTargetException;

public class Unsafe {
	private static final String exercicesPackage = "fr.ayfri.tp2";

	private Unsafe() {}

	public static void executeExercice(final int number) throws RuntimeException {
		try {
			final var clazz = Class.forName(exercicesPackage + ".Exercice" + number);
			final var object = clazz.getConstructor().newInstance();
			if (object instanceof Exercice<?> exercice) {
				exercice.run();
			}
		} catch (final ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException | InvocationTargetException e) {
			throw new RuntimeException(e);
		}
	}
}
