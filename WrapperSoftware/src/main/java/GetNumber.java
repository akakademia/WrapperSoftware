import java.util.Scanner;

public class GetNumber {
	private Scanner scan;
	private int integerNumber;
	private double doubleNumber;
	private boolean isInputInvalid = true;

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

	public int getValidIntegerFromUser(int lowestValue, int highestValue) {
		while (isInputInvalid) {
			try {
				System.out.println("Kérem, adjon meg egy egész számot ami egyenlő vagy nagyobb mint " + lowestValue + " és egyenlő kisebb mint " + highestValue + ".");
				integerNumber = getIntegerFromUser();
				if (isIntegerNotValid(integerNumber, lowestValue, highestValue)) {
					System.out.println("A megadott szám nem felel még a kritériumnak.");
				} else {
					return integerNumber;
				}
			} catch (Exception e) {
				System.out.println("Csak egész számot adhat meg.");
				scan.nextLine();
			}
		}
		return integerNumber;
	}

	public double getValidDoubleFromUser(double lowestValue, double highestValue) {
		while (isInputInvalid) {
			try {
				System.out.println("Kérem, adjon meg egy egész számot ami egyenlő vagy nagyobb mint " + lowestValue + " és egyenlő kisebb mint " + highestValue + ".");
				doubleNumber = getDoubleFromUser();
				if (isDoubleNotValid(doubleNumber, lowestValue, highestValue)) {
					System.out.println("A megadott szám nem felel még a kritériumnak.");
				} else {
					return doubleNumber;
				}
			} catch (Exception e) {
				System.out.println("Csak egész számot adhat meg.");
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

	public int getIntegerNumber() {
		return integerNumber;
	}

	public double getDoubleNumber() {
		return doubleNumber;
	}

}
