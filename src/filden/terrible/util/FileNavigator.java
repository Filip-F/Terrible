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
				fileGetter(f, pattern, files);
			}
		}
		return files;
	}

	private static Set<File> folderGetter(File folder,
			Set<File> folders) {
		for (File f : folder.listFiles()) {
			if (f.isDirectory()) {
				folders.add(f);
				folderGetter(f, folders);
			}
		}
		return folders;
	}

	public static Set<File> getFiles(File startLocation, String regexp) {
		return fileGetter(startLocation, Pattern.compile(regexp),
				new HashSet<File>());
	}

	public static Set<File> getFolders(File startLocation) {
		return folderGetter(startLocation,
				new HashSet<File>());
	}
}
