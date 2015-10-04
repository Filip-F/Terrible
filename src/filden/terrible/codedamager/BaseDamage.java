package filden.terrible.codedamager;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BaseDamage {
	static Scanner scanner;
	public void damage (File code){
		try {
			scanner = new Scanner(code);
			//Damage goes here
		} catch (FileNotFoundException e) {
		}
	}
}
