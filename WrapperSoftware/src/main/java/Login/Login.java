package Login;
import java.util.Scanner;

public class Login {
	private Scanner scan;
	
	private final String adminPassword = "Jelszó";
	private String passwordGivenByUser;
	private boolean isPasswordCorrect;
	
	private UserInputFakeClassToTestLogin input = new UserInputFakeClassToTestLogin(scan);

	public Login(Scanner scan) {
		passwordGivenByUser = input.getInputFromUserFakeMethod(scan);
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
