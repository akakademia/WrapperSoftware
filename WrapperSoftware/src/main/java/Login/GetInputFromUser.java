package Login;

import java.util.Scanner;

public class GetInputFromUser {
	private Scanner scan;
	private int integerNumber;
	private double doubleNumber;
	private String friendlyMessage;
	private String incorrectInputMessage;
	private String exceptionMessage;

	public GetInputFromUser(Scanner scan, String friendlyMessage, String incorrectInputMessage, String exceptionMessage) {
		this.scan = scan;
		this.friendlyMessage = friendlyMessage;
		this.incorrectInputMessage = incorrectInputMessage;
		this.exceptionMessage = exceptionMessage;
	}

	public GetInputFromUser(Scanner scan) {
		this.scan = scan;
	}

	private double getDoubleFromUser() {
		doubleNumber = scan.nextDouble();
		scan.nextLine();
		return doubleNumber;
	}

	private int getIntegerFromUser() {
		integerNumber = scan.nextInt();
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

	public void getValidIntegerFromUser(int lowestValue, int highestValue) {
		while (true) {
			try {
				System.out.println(friendlyMessage);
				integerNumber = getIntegerFromUser();
				if (isIntegerNotValid(integerNumber, lowestValue, highestValue)) {
					System.out.println(incorrectInputMessage);
				} else {
					break;
				}
			} catch (Exception e) {
				System.out.println(exceptionMessage);
				scan.nextLine();
			}
		}
	}

	public void getValidDoubleFromUser(double lowestValue, double highestValue) {
		while (true) {
			try {
				System.out.println(friendlyMessage);
				doubleNumber = getDoubleFromUser();
				if (isDoubleNotValid(doubleNumber, lowestValue, highestValue)) {
					System.out.println(incorrectInputMessage);
				} else {
					break;
				}
			} catch (Exception e) {
				System.out.println(exceptionMessage);
				scan.nextLine();
			}
		}
	}

	private boolean isIntegerNotValid(int number, int lowestValue, int highestValue) {
		return number < lowestValue || number > highestValue;
	}

	private boolean isDoubleNotValid(double number, double lowestValue, double highestValue) {
		return number < lowestValue || number > highestValue;
	}

	public int getIntegerNumber() {
		return integerNumber;
	}

	public double getDoubleNumber() {
		return doubleNumber;
	}

}
