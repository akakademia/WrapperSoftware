package wrappersoftware.admin;

import java.util.Scanner;

public class PasswordChangerInit {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		PasswordChanger p = new PasswordChanger(scan);
		p.initPasswordChanger(scan);
		System.out.println(p.isNewPasswordStored());
		
	}

}
