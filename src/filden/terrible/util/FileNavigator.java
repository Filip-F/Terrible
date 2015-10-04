package filden.terrible.util;

import java.io.File;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

public class FileNavigator {

	private static Set<File> fileGetter(File file, Pattern pattern,
			Set<File> files) {
		for (File f : file.listFiles()) {
			if (f.isFile()) {
				if (pattern.matcher(f.getName()).matches()) {
					files.add(f);
				}
			} else if (f.isDirectory()) {
				System.out.println("Hi");
				fileGetter(f, pattern, files);
			}
		}
		return files;
	}

	public static Set<File> getFiles(File startLocation, String regexp) {
		return fileGetter(startLocation, Pattern.compile(regexp),
				new HashSet<File>());
	}
}
