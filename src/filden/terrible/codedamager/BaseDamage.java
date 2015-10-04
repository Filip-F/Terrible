package filden.terrible.codedamager;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BaseDamage {
	static Scanner scanner;

	public static String damage(String content) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < content.length(); i++) {
			if (content.charAt(i) == '+' || content.charAt(i) == '-') {
				sb.append(Math.random() > 0.5 ? '+' : '-');
			} else {
				sb.append(content.charAt(i));
			}
		}
		return sb.toString();
	}
}
