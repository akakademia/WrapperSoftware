package wrappersoftware.report;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;

public class FileMaker {
	String path;

	
	public FileMaker() {
		this.path = "src/main/java/wrappersoftware/report/index.html";
	}
	
	public FileMaker(String path) {
		this.path = path;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	
	/***
	 * 
	 * @param data
	 * Bemenő adatok String formátumban amiket file-ba ír a metódus, default construktor esetén default path-be
	 * máskülönben a meghatározott elérési útra és file néven.
	 */
	public void writeOutDataToFile(String data) {
		PrintWriter out;
		try {
			out = new PrintWriter(new File(path), "UTF-8");
			out.print(data);
			out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
}
