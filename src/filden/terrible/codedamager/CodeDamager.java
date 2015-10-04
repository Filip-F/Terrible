package filden.terrible.codedamager;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Set;

import filden.terrible.util.FileNavigator;

public class CodeDamager {
	public static void run(File basePath) {
		Set<File> codes = FileNavigator.getFiles(basePath,
				".*\\.(rkt|c|java|py|cpp|js|php))");
		for (File code : codes) {
			try {
				char c;
				StringBuilder sb = new StringBuilder();
				BufferedReader br = new BufferedReader(new FileReader(code));
				String content;
				while ((c = (char) br.read()) != -1)
					sb.append(c);
				content = sb.toString();
				BaseDamage.damage(content);
				switch (code.getAbsolutePath().substring(
						code.getAbsolutePath().lastIndexOf("."),
						code.getAbsolutePath().length())) {

				case "rkt":
					Racket.damage(content);
					break;
				case "c":
					C.damage(content);
					break;
				case "cpp":
					CPP.damage(content);
					break;
				case "js":
					JavaScript.damage(content);
					break;
				case "java":
					Java.damage(content);
					break;
				}
			} catch (FileNotFoundException e) {
			}
		}
	}
}
