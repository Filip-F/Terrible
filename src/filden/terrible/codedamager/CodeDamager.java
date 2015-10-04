package filden.terrible.codedamager;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Set;

import filden.terrible.util.FileNavigator;

public class CodeDamager {
	public static void run(File basePath) {
		Set<File> codes = FileNavigator.getFiles(basePath, ".*\\.(rkt|c|java|py|cpp|js|php))");
		for (File code : codes) {
			damage(code);
		}
	}
	public static void damage(File code){
		
	}
}
