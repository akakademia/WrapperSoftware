package wrappersoftware.report;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FileMaker {

	public void writeOutDataToFile(String data, String path, String costumerName) {
		PrintWriter out;
		try {
			File file = new File(path + "/" + generateFileName(costumerName));
			out = new PrintWriter(file, "UTF-8");
			out.print(data);
			out.close();
			System.out.println("File-ba mentés sikeres volt: " + file.getAbsolutePath());
			System.out.println();
		} catch (FileNotFoundException e) {
			System.out.println("Hiba: " + e);
		} catch (UnsupportedEncodingException e) {
			System.out.println("Hiba: " + e);
		}
	}

	public String generateDateAndTime() {
		LocalDateTime myDateObj = LocalDateTime.now();
		DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String formattedDate = myDateObj.format(myFormatObj);

		return formattedDate;
	}

	public String generateFileName(String costumerName) {

		return generateDateAndTime() + "_" + costumerName.substring(0, 4) + ".html";
	}
}
