package wrappersoftware.login;
import java.util.Scanner;

public class TestLoginClass {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		//Egy lehetséges használata a Login osztálynak
		System.out.println("Egy lehetséges használata a Login osztálynak");
		System.out.println();
		
		if (new Login(scan).isPasswordCorrect()) {
			System.out.println("Admin!");
		}else {
			System.out.println("Nem sikerült belépnie adminként!");
		}
	}
}