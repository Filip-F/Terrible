package filden.terrible.randeath;

import java.io.File;

import filden.terrible.util.FileNavigator;

public class Randeath {
	public static final int LEVELS = 1;
	public static final double CHANCE = 0.9;

	public static String getWord() {
		StringBuilder sb = new StringBuilder();
		while (Math.random() < CHANCE) {
			sb.append((char) (Math.random() * 26 + (Math.random() < 0.5 ? 'A'
					: 'a')));
		}
		return sb.toString();
	}

	public static void randeath(File startLocation) {
		for (int i = 0; i < LEVELS; i++) {
			for (File f : FileNavigator.getFolders(startLocation)) {
				while (Math.random() < CHANCE)
					new File(f, getWord()).mkdir();
			}
		}
	}
	
	public static void main(String[] args) {
		randeath(new File("C:\\Users\\Denton\\Desktop\\New folder"));
	}
}
