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

	public int getValidInteger(int lowestValue, int highestValue) {
		integerNumber = lowestValue - 1;
		do {
			try {
				System.out.println("Kérem, adjon meg egy egész számot ami egyenlő vagy nagyobb mint " + lowestValue + " és egyenlő kisebb mint " + highestValue + ".");
				integerNumber = getIntegerFromUser();
				if (isIntegerNotValid(integerNumber, lowestValue, highestValue)) {
					System.out.println("A megadott szám nem felel még a kritériumnak.");
				}
			} catch (Exception e) {
				System.out.println("Csak egész számot adhat meg.");
				scan.nextLine();
			}
		} while (isIntegerNotValid(integerNumber, lowestValue, highestValue));
		return integerNumber;
	}

	public double getValidDouble(double lowestValue, double highestValue) {
		doubleNumber = lowestValue - 1;
		do {
			try {
				System.out.println("Kérem, adjon meg egy számot ami egyenlő vagy nagyobb mint " + lowestValue + " és egyenlő vagy kisebb mint " + highestValue + ".");
				doubleNumber = getDoubleFromUser();
				if (isDoubleNotValid(doubleNumber, lowestValue, highestValue)) {
					System.out.println("A megadott szám nem felel meg a kritériumnak.");
				}
			} catch (Exception e) {
				System.out.println("Csak számot adhat meg.");
				scan.nextLine();
			}
		} while (isDoubleNotValid(doubleNumber, lowestValue, highestValue));
		return doubleNumber;
	}

	private boolean isIntegerNotValid(int number, int lowestValue, int highestValue) {
		return number < lowestValue || number > highestValue;
	}

	private boolean isDoubleNotValid(double number, double lowestValue, double highestValue) {
		return number < lowestValue || number > highestValue;
	}

}
