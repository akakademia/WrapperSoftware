package wrappersoftware.admin;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;

import wrappersoftware.GetInputFromUser;

public class Login {
	private String adminPassword;
	private String passwordGivenByUser;
	private boolean isPasswordCorrect;

	public Login(Scanner scan) {
		try {
			loadAdminPasswordFromConfigFile();
			passwordGivenByUser = new GetInputFromUser(scan).getStringInputFromUser("Jelszó: ");
			setIsPasswordCorrect();
		} catch (Exception e) {
			System.out.println("Hiba történt: " + e.getMessage());
		}
	}

	/**
	 * <p>
	 * Bekéri a jelszót a felasználótól.
	 * </p>
	 * <p>
	 * Ha ez a jeszó egyezik az admin jelszóval akkor igaz értéket ad vissza,<br>
	 * ha nem egyezik akkor hamis-t.
	 * </p>
	 */
	public boolean isPasswordCorrect() {
		return isPasswordCorrect;
	}

	private void setIsPasswordCorrect() throws NullPointerException {
		if (adminPassword.equals(passwordGivenByUser)) {
			isPasswordCorrect = true;
		} else {
			System.out.println("Hibás jelszót adott meg!");
		}
	}

	private void loadAdminPasswordFromConfigFile() throws FileNotFoundException, IOException {
		File configFile = new File("src/main/java/wrappersoftware/admin/config.xml");
		FileInputStream fis = new FileInputStream(configFile);
		Properties properties = new Properties();
		properties.loadFromXML(fis);

		this.adminPassword = properties.getProperty("admin_password");
	}

	@Override
	public String toString() {
		return "" + isPasswordCorrect;
	}
}
