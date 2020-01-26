import java.util.Scanner;

public class GetNumber {
	private Scanner scan;
	private int integerNumber;
	private double doubleNumber;

	public GetNumber(Scanner scan) {
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

	public void getValidIntegerFromUser(String friendlyMessage, String incorrectInputMessage, String exceptionMessage, int lowestValue, int highestValue) {
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

	public void getValidDoubleFromUser(String friendlyMessage, String incorrectInputMessage, String exceptionMessage, double lowestValue, double highestValue) {
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
