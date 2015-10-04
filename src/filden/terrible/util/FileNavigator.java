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
				if (f.isFile()) {
					if (pattern.matcher(f.getName()).matches()) {
						System.out.println("asdf");
						files.add(f);
					}
				} else if (f.isDirectory()) {
					fileGetter(f, pattern, files);
				}
			}
		}
		return files;
	}

	public static Set<File> getFiles(File startLocation, String regexp) {
		return fileGetter(startLocation, Pattern.compile("regexp"),
				new HashSet<File>());
	}

	public static void main(String[] args) {
		for (File f : getFiles(new File(
				"C:\\Users\\Denton\\Desktop\\New folder"), ".*\\.txt")) {
			System.out.println(f.getName());
		}
		System.out.println(Pattern.compile(".*\\.txt").matcher("1.txt").matches());
	}
}
