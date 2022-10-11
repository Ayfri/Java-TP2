package fr.ayfri;

import java.lang.reflect.InvocationTargetException;

/**
 * Classe pour les actions non-sécurisées.
 */
public final class Unsafe {
	/**
	 * Package des exercices.
	 */
	private static final String exercicesPackage = "fr.ayfri.tp2";

	/**
	 * Constructeur privé pour empêcher l'instanciation.
	 */
	private Unsafe() {}

	/**
	 * Exécute un exercice en récupérant la classe correspondante, créant une instance et appelant la méthode {@link Exercice#run()}.
	 *
	 * @param number Le numéro de l'exercice.
	 *
	 * @throws RuntimeException Si l'exercice n'existe pas.
	 */
	public static void executeExercice(final int number) throws RuntimeException {
		try {
			final var clazz = Class.forName(exercicesPackage + ".Exercice" + number);
			final var object = clazz.getConstructor().newInstance();
			if (object instanceof Exercice<?> exercice) exercice.run();
		} catch (final ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		} catch (final NoSuchMethodException | InvocationTargetException e) {
			throw new RuntimeException(e);
		}
	}
}
