package filden.terrible.whuh;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Set;

import filden.terrible.util.FileNavigator;

public class Whuh {
	public static void whuh(File basePath) {
		Set<File> wavs = FileNavigator.getFiles(basePath, ".*\\.wav");
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

	public static void main(String[] args) {
		whuh(new File("C:\\Users\\Filip\\Desktop\\Media"));
	}
}
