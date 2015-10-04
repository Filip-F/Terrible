package Shufle;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Set;

import filden.terrible.util.FileNavigator;
public class ShuffleFolder {
	public static void main (String []  args){
		
		Set<File> adsf =  FileNavigator.getFiles(new File ("C:\\Users\\Filip\\Desktop\\Fuck\\"), ".*");
		for (int i = 0; i < 20; i++){
			new File(System.getProperty("user.home") + "\\Desktop\\Fuck\\" + String.valueOf(i)).mkdir();
			PrintWriter writer;
			try {
				writer = new PrintWriter(System.getProperty("user.home") + "\\Desktop\\Fuck\\"
						+ String.valueOf(i) + "\\" + "asdf.txt", "UTF-8");
				writer.println("The first line");
				writer.println("The second line");
				writer.close();
			} catch (FileNotFoundException | UnsupportedEncodingException e) {
			}
			
		}
	}
}
