import java.io.File;
import java.util.Set;
public class ShuffleFolder {
	public static void main (String []  args){
		
		//Set<File> adsf =  FileNavigator.getFiles(new File ("C:\\Users\\Filip\\Desktop\\Fuck\\"), ".*");
		for (int i = 0; i < 20; i++)
			new File(System.getProperty("user.home") + "\\Desktop\\Fuck\\" + String.valueOf(i)).mkdir();
	}
}
