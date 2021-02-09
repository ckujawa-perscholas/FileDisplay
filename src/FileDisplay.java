import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileDisplay {

	
	public static void main(String[] args) {
		if (args.length == 0) {
			System.exit(0);
		} else {
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
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				System.out.println("The file " + fileName + " does not exist");
			}
		}
	}
}
