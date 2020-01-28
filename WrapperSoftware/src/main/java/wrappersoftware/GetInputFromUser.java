package wrappersoftware;

import java.util.Scanner;

public class GetInputFromUser {
	private Scanner scan;
	private String friendlyMessage;

	public GetInputFromUser(Scanner scan, String friendlyMessage) {
		this.scan = scan;
		this.friendlyMessage = friendlyMessage;
	}

	public GetInputFromUser(Scanner scan) {
		this.scan = scan;
	}

	private double getDoubleFromUser() {
		double doubleNumber = scan.nextDouble();
		scan.nextLine();
		return doubleNumber;
	}

	private int getIntegerFromUser() {
		int integerNumber = scan.nextInt();
		scan.nextLine();
		return integerNumber;
	}

	public String getPasswordFromUser(Scanner scan) {
		String password;
		do {
			System.out.print("Kérem, adja meg jelszót: ");
			password = scan.nextLine();
		} while (password.length() < 1);
		return password;
	}

	public int getValidIntegerFromUser(int lowestValue, int highestValue) {
		int integerNumber;
		while (true) {
			try {
				System.out.println(friendlyMessage);
				integerNumber = getIntegerFromUser();
				if (isIntegerNotValid(integerNumber, lowestValue, highestValue)) {
					System.out.println("A megadott szám tartományon kívüli.");
				} else {
					break;
				}
			} catch (Exception e) {
				System.out.println("Csak egész számot adhat meg.");
				scan.nextLine();
			}
		}
		return integerNumber;
	}

	public double getValidDoubleFromUser(double lowestValue, double highestValue) {
		double doubleNumber;
		while (true) {
			try {
				System.out.println(friendlyMessage);
				doubleNumber = getDoubleFromUser();
				if (isDoubleNotValid(doubleNumber, lowestValue, highestValue)) {
					System.out.println("A megadott szám tartományon kívüli.");
				} else {
					break;
				}
			} catch (Exception e) {
				System.out.println("Csak számot adhat meg.");
				scan.nextLine();
			}
		}
		return doubleNumber;
	}

	private boolean isIntegerNotValid(int number, int lowestValue, int highestValue) {
		return number < lowestValue || number > highestValue;
	}

	private boolean isDoubleNotValid(double number, double lowestValue, double highestValue) {
		return number < lowestValue || number > highestValue;
	}

}
