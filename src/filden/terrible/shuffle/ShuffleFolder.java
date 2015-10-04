package filden.terrible.shuffle;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class ShuffleFolder {
	final static int NUM_FOLDERS = 100;
	static int numRuns = 0;
	static String dir;
	static StringBuilder build = new StringBuilder();
	public static void main(String[] args) {
		
		System.out.println("Please enter a directory");
		dir = new java.util.Scanner(System.in).nextLine();
		for (int i = 0; i < dir.length(); i++){
			
			if (dir.charAt(i) == '\\'||dir.charAt(i) == '/')
				build.append("\\");
			else build.append(dir.charAt(i));
		}
		dir = build.toString();
		for (File file : new File(dir).listFiles()) {
			if (!file.isDirectory()) {
				makeFolders();
				numRuns++;
				Path filePath1 = file.toPath();
				String string = file.getAbsolutePath().substring(0, file.getAbsolutePath().lastIndexOf("\\")) + "\\"
						+ String.valueOf((int) (Math.random() * NUM_FOLDERS) + NUM_FOLDERS * (numRuns - 1)) + "\\"
						+ file.getAbsolutePath().substring(file.getAbsolutePath().lastIndexOf("\\"),
								file.getAbsolutePath().lastIndexOf("\\"))
						+ ((int) (Math.random() * 999999));

				Path filePath2 = (new File(string)).toPath();
				try {
					Files.move(filePath1, filePath2, StandardCopyOption.REPLACE_EXISTING);
					Files.delete(filePath1);
				} catch (IOException e) {
				}
			}
		}
	}

	public static void makeFolders() {
		for (int i = 0 + NUM_FOLDERS * numRuns; i < NUM_FOLDERS + NUM_FOLDERS * numRuns; i++) {
			new File(dir + "\\" + String.valueOf(i)).mkdir();
			PrintWriter writer;
			try {
				writer = new PrintWriter(dir + "\\" + String.valueOf(i) + "\\" + "asdf.txt", "UTF-8");
				writer.println("The first line");
				writer.println("The second line");
				writer.close();
			} catch (FileNotFoundException | UnsupportedEncodingException e) {
			}
		}
	}
}
