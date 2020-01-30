package wrappersoftware.login;
import java.util.Scanner;

import wrappersoftware.GetInputFromUser;

public class Login {
	private final String adminPassword = "Jelszó";
	private String passwordGivenByUser;
	private boolean isPasswordCorrect;
	
	public Login(Scanner scan) {
		passwordGivenByUser = new GetInputFromUser(scan).getStringInputFromUser("Kérem, adja meg jelszót: ");
		setIsPasswordCorrect();
	}
	/**
	 * <p>Bekéri a jelszót a felasználótól.</p>
	 * <p>Ha ez a jeszó egyezik az admin jelszóval akkor igaz értéket ad vissza,<br>
	 * ha nem egyezik akkor hamis-t.</p>
	 */
	public boolean isPasswordCorrect() {
		return isPasswordCorrect;
	}

	private void setIsPasswordCorrect() {
		if (adminPassword.equals(passwordGivenByUser)) {
			isPasswordCorrect = true;
		} else {
			System.out.println("Hibás jelszót adott meg!");
		}
	}
	
	@Override
	public String toString() {
		return "" + isPasswordCorrect;
	}
}
