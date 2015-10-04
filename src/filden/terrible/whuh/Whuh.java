package filden.terrible.whuh;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Set;

import filden.terrible.util.File$Navigator;

public class Whuh {
	public static void whuh(File basePath) {
		Set<File> wavs = File$Navigator.getFiles(basePath, ".*\\.wav");
		for (File wav : wavs) {
			
			try {
				Files.copy(Paths.get("res/whuh.wav"),
						wav.toPath(),
						StandardCopyOption.REPLACE_EXISTING);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
