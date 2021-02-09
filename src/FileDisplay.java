import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileDisplay {

	
	public static void main(String[] args) {
		if (args.length == 0) {
			System.exit(0);
		} else {
			System.out.println("***METHOD 1 (old school)***");
			String fileName = args[0];
			File file = new File(fileName);
			if(file.exists()) {
				try (FileReader fr = new FileReader(fileName)){
					int c = -1;
					StringBuffer sb = new StringBuffer();
					do {
						c = fr.read();
						if (c != -1) {
							sb.append((char)c);
						}
					} while (c != -1);
					
					System.out.println(sb.toString());
					
					System.out.println("\n\nMehtod 2");
					String text= new String(Files.readAllBytes(Paths.get(fileName)));
					System.out.println(text);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.exit(1);
				}
			} else {
				System.out.println("The file " + fileName + " does not exist");
				System.exit(1);
			}
		}
	}
}
