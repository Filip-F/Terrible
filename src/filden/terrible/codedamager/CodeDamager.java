package filden.terrible.codedamager;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Set;

import filden.terrible.util.FileNavigator;

public class CodeDamager {
	public static void run(File basePath) {
		Set<File> codes = FileNavigator.getFiles(basePath, ".*\\.(rkt|c|java|py|cpp|js|php))");
		for (File code : codes) {
			try {
				switch(code.getAbsolutePath().substring(code.getAbsolutePath().lastIndexOf("."), code.getAbsolutePath().length())){
				BaseDamage.damage(code);
				case "rkt": Racket.damage(code); break;
				case "c" : C.damage(code); break;
				case "cpp" CPP.damage(code); break;
				case "js" : JavaScript.damage(code); break;
				case "c" : C.damage(code); break;
				}
			} catch (FileNotFoundException e) {
			}
		}
	}
}

