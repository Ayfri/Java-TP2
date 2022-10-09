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

public class ButtonController implements Initializable {
	public static final Charset CHARSET = StandardCharsets.UTF_8;
	@FXML
	public Button button1;
	@FXML
	public Button button2;
	@FXML
	public Button button3;
	@FXML
	public Button button4;
	@FXML
	public Button button5;

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

	private void redirectStandardOut(TextArea area) {
		try {
			PipedInputStream in = new PipedInputStream();
			System.setOut(new PrintStream(new PipedOutputStream(in), true, StandardCharsets.UTF_8));

			Thread thread = new Thread(new StreamReader(in, area));
			thread.setDaemon(true);
			thread.start();
		} catch (IOException ex) {
			throw new UncheckedIOException(ex);
		}
	}

	private static class StreamReader implements Runnable {

		private final StringBuilder buffer = new StringBuilder();
		private final BufferedReader reader;
		private final TextArea textArea;
		private boolean notify = true;

		StreamReader(InputStream input, TextArea textArea) {
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
			} catch (IOException ex) {
				throw new UncheckedIOException(ex);
			}
		}

		private void appendTextToTextArea() {
			synchronized (buffer) {
				textArea.appendText(buffer.toString());
				buffer.delete(0, buffer.length());
				notify = true;
			}
		}
	}
}
