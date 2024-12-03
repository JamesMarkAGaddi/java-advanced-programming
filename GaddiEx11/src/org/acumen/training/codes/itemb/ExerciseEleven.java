package org.acumen.training.codes.itemb;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class ExerciseEleven {

	public void execute(String filename, String message) {

		Runnable fileReadTask = new Runnable() {
			@Override
			public void run() {
				Reader.readFile(filename);
			}
		};

		Runnable fileWriteTask = new Runnable() {
			@Override
			public void run() {
				Writer.writeFile(filename, message);
			}
		};

		Thread[] writeThreads = new Thread[5];
		for (int i = 0; i < writeThreads.length; i++) {
			writeThreads[i] = new Thread(fileWriteTask, "Writer " + (i + 1)); // to monitor write threads
			writeThreads[i].start();
		}

		for (Thread writeThread : writeThreads) {
			try {
				writeThread.join(); // to make sure the thread is finished
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		Thread readThread = new Thread(fileReadTask, "Reader");
		readThread.start();
	}

	private static class Reader {
		public synchronized static void readFile(String filename) {
			Path filePath = Paths.get(filename);
			Charset utf8 = Charset.forName("UTF-8");

			try (BufferedReader bReader = Files.newBufferedReader(filePath, utf8)) {
				String line;
				while ((line = bReader.readLine()) != null) {
					System.out.println(line);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private static class Writer {
		public synchronized static void writeFile(String filename, String words) {
			Path path = Paths.get(filename);
			Charset charset = Charset.forName("UTF-8");

			try (BufferedWriter bWriter = Files.newBufferedWriter(path, charset, 
					StandardOpenOption.CREATE, StandardOpenOption.APPEND)) {
				bWriter.write(words);
				bWriter.write("\n");// Append message with newline
				System.out.println(Thread.currentThread().getName() + " has written to the file.");
				Thread.sleep(1000); // Simulating some delay while reading
			} catch (IOException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
