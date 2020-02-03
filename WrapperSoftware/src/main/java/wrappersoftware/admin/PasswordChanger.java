package wrappersoftware.admin;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Properties;
import java.util.Scanner;

import wrappersoftware.GetInputFromUser;

public class PasswordChanger {

	private String newPassword;
	private boolean isNewPasswordStored;
	private Scanner scan;

	public PasswordChanger(Scanner scan) {
		this.scan = scan;
	}

	public boolean isNewPasswordStored() {
		return isNewPasswordStored;
	}

	public void initPasswordChanger(Scanner scan) {
		System.out.println("Jelszó változtatáshoz ellenőrizni kell a jogosultságok!");
		System.out.println();

		if (isAdminVerifiedByLogin()) {
			printOutRulesToChangePassword();
			setNewPassword(scan);

			if (isNewPasswordValid()) {
				storeNewPasswordToConfigFile();
			} else {
				System.out.println("Hibás jelszó formátum! Módosítás nem lehetséges.");
			}
		}
	}

	private void setNewPassword(Scanner scan) {
		this.newPassword = new GetInputFromUser(scan).getStringInputFromUser("Új jelszó: ");
	}

	public void printOutRulesToChangePassword() {
		System.out.println();
		System.out.println("Az új jelszó az abc kis és nagy betűiből és számokból álhat.");
		System.out.println("Min. 8 karakter hosszúnak kell lennie.");
		System.out.println("Nem tartalmazhat szóközt és speciális karaktereket!");
		System.out.println();
	}

	private boolean isNewPasswordValid() {
		return newPassword.matches("^[a-zöüóőúéáűíA-ZÖÜÓŐÚÉÁŰÍ0-9]{8,}$");
	}

	private boolean isAdminVerifiedByLogin() {
		return new Login(scan).isPasswordCorrect();
	}

	private void storeNewPasswordToConfigFile() {
		File configFile = new File("src/main/java/wrappersoftware/admin/config.xml");
		try {
			FileOutputStream fos = new FileOutputStream(configFile);
			Properties propConfig = new Properties();
			propConfig.setProperty("admin_password", newPassword);
			propConfig.storeToXML(fos, "Jelszó módosítása");

			System.out.println();
			System.out.println("Jelszó módosítva!");
			
			this.isNewPasswordStored = true;

		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println("Hiba");
		}
	}

	@Override
	public String toString() {
		return "Új jelszó letárolva? " + isNewPasswordStored;
	}
	
	
}
