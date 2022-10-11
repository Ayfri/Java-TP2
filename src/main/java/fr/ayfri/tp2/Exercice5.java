package fr.ayfri.tp2;

import fr.ayfri.Exercice;
import fr.ayfri.gui.App;
import fr.ayfri.inputs.BooleanInputManager;
import fr.ayfri.inputs.NumberInputManager;
import fr.ayfri.inputs.StringInputManager;
import org.jetbrains.annotations.NotNull;

/**
 * Exercice 5 du TP 1.
 *
 * @author Pierre
 */
public class Exercice5 extends Exercice<NumberInputManager> {
	/**
	 * Les statistiques de l'ordinateur.
	 */
	private final @NotNull Statistics computerStatistics = new Statistics();

	/**
	 * Les statistiques du joueur.
	 */
	private final @NotNull Statistics playerStatistics = new Statistics();

	/**
	 * L'inputManager pour savoir si le joueur veut rejouer.
	 */
	private final @NotNull BooleanInputManager replayInputManager = new BooleanInputManager("Voulez-vous rejouer ? (y/n) : ");

	/**
	 * L'inputManager pour récupérer le nom du joueur.
	 */
	private final @NotNull StringInputManager stringInputManager = new StringInputManager("Entrez votre nom : ");

	/**
	 * Constructeur de l'exercice 5.
	 */
	public Exercice5() {
		title = "TP 2.5 - Jeu de Nim";
		description = """
				La règle : il y a plusieurs allumettes (supérieur ou égales à 16) et on en retire 1,2 ou 3 et celui qui prend la dernière a gagné.
				Vous jouez contre l’ordinateur, le joueur de départ est choisi aléatoirement.
				(Remarque : Si l’ordinateur est le deuxième joueur, il doit normalement gagner.)
			""".stripIndent();

		inputManager = new NumberInputManager("");
		count++;
	}

	/**
	 * Créé une instance de l'exercice 5 et l'exécute, permettant de tester l'exercice directement.
	 *
	 * @param args Les arguments de la ligne de commande (non utilisés).
	 */
	public static void main(final String @NotNull [] args) {
		new Exercice5().run();
	}

	@Override
	public void run() {
		final var playerName = stringInputManager.getString();

		do {
			inputManager.setPrompt("Entrez le nombre d'allumettes de départ (> 15) : ");
			inputManager.setMinMax(16, Integer.MAX_VALUE);

			final var allumettes = inputManager.getInt();
			final var game = new Nim(allumettes);
			var computerPlaying = Math.random() < 0.5;
			System.out.printf("%s commence !%n", computerPlaying ? "L'ordinateur" : playerName);

			inputManager.setPrompt("Entrez le nombre d'allumettes à retirer (1, 2 ou 3) : ");
			inputManager.setMinMax(1, 3);

			final var playerStarted = !computerPlaying;

			while (game.getAllumettes() > 0) {
				if (computerPlaying) {
					final int allumettesToTake = playerStarted ? game.getAllumettes() % 4 : (int) (Math.random() * 3) + 1;
					System.out.printf("%s %s enlève : %s%n", game.displayAllumettes(), "L'ordinateur", allumettesToTake);

					if (game.play(allumettesToTake)) {
						System.out.printf("L'ordinateur a gagné !%n %s a perdu :(%n", playerName);
						computerStatistics.win();
						playerStatistics.lose();
						break;
					}
				} else {
					System.out.printf("%s %s enlève : ", game.displayAllumettes(), playerName);
					final var allumettesToTake = inputManager.getInt();
					if (App.usingGUI) System.out.println(allumettesToTake);
					if (game.play(allumettesToTake)) {
						System.out.printf("%s a gagné !%nL'ordinateur a perdu >:)%n", playerName);
						playerStatistics.win();
						computerStatistics.lose();
						break;
					}
				}

				computerPlaying = !computerPlaying;
			}

			System.out.printf(
				"%nStatistiques : %s a gagné %d fois et perdu %d fois, l'ordinateur a gagné %d fois et perdu %d fois%n%n",
				playerName,
				playerStatistics.wins,
				playerStatistics.losses,
				computerStatistics.wins,
				computerStatistics.losses
			);
		} while (replayInputManager.getBoolean());
	}

	/**
	 * La classe Nim pour gérer le jeu.
	 *
	 * @author Pierre
	 */
	private static final class Nim {
		/**
		 * Le nombre d'allumettes au départ.
		 */
		private final int startingAllumettes;

		/**
		 * Le nombre d'allumettes actuel.
		 */
		private int allumettes;

		/**
		 * Constructeur de la classe Nim.
		 *
		 * @param allumettes Le nombre d'allumettes au départ.
		 */
		public Nim(final int allumettes) {
			this.allumettes = allumettes;
			this.startingAllumettes = allumettes;
		}

		/**
		 * Créé un String représentant les allumettes.
		 *
		 * @return Le String représentant les allumettes.
		 */
		public @NotNull String displayAllumettes() {
			return String.format("%" + startingAllumettes + "s", "|".repeat(allumettes));
		}

		/**
		 * Joue le nombre d'allumettes spécifié.
		 *
		 * @param allumettes Le nombre d'allumettes à jouer.
		 *
		 * @return Si le joueur a gagné.
		 */
		public boolean play(final int allumettes) {
			this.allumettes -= allumettes;
			return this.allumettes <= 0;
		}

		/**
		 * Getter pour le nombre d'allumettes.
		 *
		 * @return Le nombre d'allumettes actuel.
		 */
		public int getAllumettes() {
			return allumettes;
		}
	}

	/**
	 * La classe Statistics pour gérer les statistiques.
	 *
	 * @author Pierre
	 */
	private static class Statistics {

		/**
		 * Le nombre de victoires.
		 */
		private int wins = 0;

		/**
		 * Le nombre de défaites.
		 */
		private int losses = 0;

		/**
		 * Incrémente le nombre de défaites.
		 */
		public void lose() {
			losses++;
		}

		/**
		 * Incrémente le nombre de victoires.
		 */
		public void win() {
			wins++;
		}
	}
}
