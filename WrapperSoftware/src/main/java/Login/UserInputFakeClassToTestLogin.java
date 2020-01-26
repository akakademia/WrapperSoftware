package Login;
import java.util.Scanner;

public class UserInputFakeClassToTestLogin {
	public UserInputFakeClassToTestLogin(Scanner scan) {
	}

	public String getInputFromUserFakeMethod(Scanner scan) {
		System.out.print("Kérem a jelszót: ");
		String text = scan.nextLine();

		return text;
	}
}
