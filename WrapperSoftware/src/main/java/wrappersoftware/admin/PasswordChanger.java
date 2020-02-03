package wrappersoftware.admin;

import java.util.Scanner;

public class PasswordChanger {
	
	private boolean hasAdminRights;
	private String newPassword;
	private boolean isNewPasswordValid;
	private Scanner scan;
	private Login adminChecker;
	
	
	public PasswordChanger(Scanner scan) {
		this.scan = scan;
		this.adminChecker = new Login(scan);
	}


	/*
	 * Jogosultság ellenőrzése...régi jelszó bekérése
	 * Új jelszó bekérése
	 * Új jelszó validálása
	 * Valid jelszó esetén új jelszó letárolása és tájékoztatás a sikerről
	 * Nem valid jelszó esetén tájékoztatás a sikertelenségről
	 */

	
	public void initPasswordChange() {
		System.out.println("Adja meg a régi jelszót!");
		if (isAdminLogedIn()) {
			System.out.println("Jogosult jelszót változtatni!");
			//.......
		}else {
			System.out.println("Nem jogosult jelszót változtatni!");
		}
	}
	
	private boolean isAdminLogedIn() {
		return adminChecker.isPasswordCorrect();
	}
}
