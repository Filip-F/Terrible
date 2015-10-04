package Shufle;

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
	public static void main(String[] args) {
		java.util.Scanner scan = new java.util.Scanner(System.in);
		System.out.println("Please enter a directory, remember to enter it like \"C:\\Users\\Blah\\...\"");
		String dir = scan.nextLine();
		for (File file : new File(dir).listFiles()) {
			if (!file.isDirectory()) {
				makeFolders();
				numRuns++;
				Path filePath1 = file.toPath();
				String string = file.getAbsolutePath().substring(0, file.getAbsolutePath().lastIndexOf("\\")) + "\\"
						+ String.valueOf((int) (Math.random() * NUM_FOLDERS) + NUM_FOLDERS * (numRuns-1))
						+ file.getAbsolutePath().substring(file.getAbsolutePath().lastIndexOf("\\"), file.getAbsolutePath().length());
				System.out.println(string);
				Path filePath2 = (new File(string)).toPath();
				try {
					Files.move(filePath1, filePath2, StandardCopyOption.REPLACE_EXISTING);
				} catch (IOException e) {
				}
			}
		}
	}
	public static void makeFolders (){
		for (int i = 0 + NUM_FOLDERS*numRuns; i < NUM_FOLDERS + NUM_FOLDERS*numRuns; i++) {
			new File(System.getProperty("user.home") + "\\Desktop\\Fuck\\" + String.valueOf(i)).mkdir();
			PrintWriter writer;
			try {
				writer = new PrintWriter(
						System.getProperty("user.home") + "\\Desktop\\Fuck\\" + String.valueOf(i) + "\\" + "asdf.txt",
						"UTF-8");
				writer.println("The first line");
				writer.println("The second line");
				writer.close();
			} catch (FileNotFoundException | UnsupportedEncodingException e) {
			}
		}
	}
}
