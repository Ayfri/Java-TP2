package fr.ayfri.gui;

import fr.ayfri.Unsafe;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.io.PrintStream;
import java.io.UncheckedIOException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ResourceBundle;

/**
 * Controlleur de l'application graphique permettant de gérer les boutons.
 *
 * @author Pierre
 */
public class ButtonController implements Initializable {
	/**
	 * Le jeu de caractères utilisé pour lire les entrées.
	 */
	public static final Charset CHARSET = StandardCharsets.UTF_8;

	/**
	 * Le bouton pour l'exercice 1.
	 */
	@FXML
	public Button button1;

	/**
	 * Le bouton pour l'exercice 2.
	 */
	@FXML
	public Button button2;

	/**
	 * Le bouton pour l'exercice 3.
	 */
	@FXML
	public Button button3;

	/**
	 * Le bouton pour l'exercice 4.
	 */
	@FXML
	public Button button4;

	/**
	 * Le bouton pour l'exercice 5.
	 */
	@FXML
	public Button button5;

	/**
	 * La zone de texte pour l'affichage des résultats.
	 */
	@FXML
	public TextArea console;

	@Override
	public void initialize(final URL location, final ResourceBundle resources) {
		button1.setOnAction(event -> Unsafe.executeExercice(1));
		button2.setOnAction(event -> Unsafe.executeExercice(2));
		button3.setOnAction(event -> Unsafe.executeExercice(3));
		button4.setOnAction(event -> Unsafe.executeExercice(4));
		button5.setOnAction(event -> Unsafe.executeExercice(5));

		redirectStandardOut(console);
	}

	/**
	 * Redirige la sortie standard vers la zone de texte.
	 *
	 * @param area La zone de texte à rediriger.
	 */
	private void redirectStandardOut(final TextArea area) {
		try {
			final PipedInputStream in = new PipedInputStream();
			System.setOut(new PrintStream(new PipedOutputStream(in), true, StandardCharsets.UTF_8));

			final Thread thread = new Thread(new StreamReader(in, area));
			thread.setDaemon(true);
			thread.start();
		} catch (final IOException ex) {
			throw new UncheckedIOException(ex);
		}
	}

	/**
	 * Classe permettant de lire le flux d'entrée et de l'afficher dans la zone de texte.
	 */
	private static class StreamReader implements Runnable {

		/**
		 * Propriété pour le buffer de lecture.
		 */
		private final StringBuilder buffer = new StringBuilder();

		/**
		 * Propriété pour le flux d'entrée.
		 */
		private final BufferedReader reader;

		/**
		 * Propriété de la zone de texte à rediriger.
		 */
		private final TextArea textArea;

		/**
		 * Propriété notifiant si le flux est fermé.
		 */
		private boolean notify = true;

		/**
		 * Constructeur de la classe.
		 *
		 * @param input    Le flux d'entrée.
		 * @param textArea La zone de texte à rediriger.
		 */
		StreamReader(final InputStream input, final TextArea textArea) {
			this.reader = new BufferedReader(new InputStreamReader(input, CHARSET));
			this.textArea = textArea;
		}

		@Override
		public void run() {
			try (reader) {
				int charAsInt;
				while ((charAsInt = reader.read()) != -1) {
					synchronized (buffer) {
						buffer.append((char) charAsInt);
						if (notify) {
							notify = false;
							Platform.runLater(this::appendTextToTextArea);
						}
					}
				}
			} catch (final IOException ex) {
				throw new UncheckedIOException(ex);
			}
		}

		/**
		 * Ajoute le texte dans la zone de texte.
		 */
		private void appendTextToTextArea() {
			synchronized (buffer) {
				textArea.appendText(buffer.toString());
				buffer.delete(0, buffer.length());
				notify = true;
			}
		}
	}
}
