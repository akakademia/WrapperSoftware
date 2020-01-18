import java.text.DecimalFormat;
import java.util.Scanner;

public class GetNumber {
	private Scanner scan;

	public GetNumber(Scanner scan) {
		this.scan = scan;
	}

	private double getNumberFromUser() {
		double number = scan.nextDouble();
		scan.nextLine();
		return number;
	}

	public double getValidInteger(double lowestValue, double highestValue) {
		DecimalFormat format = new DecimalFormat("###.#");
		double integer = lowestValue - 1;
		do {
			try {

				System.out.println("Kérem, adjon meg egy egész számot ami egyenlő vagy nagyobb mint " + format.format(lowestValue) + " és egyenlő kisebb mint " + format.format(highestValue) + ".");
				integer = getNumberFromUser();
				if (isIntegerNotValid(integer, lowestValue, highestValue)) {
					System.out.println("A megadott szám nem felel még a kritériumnak.");
				}
			} catch (Exception e) {
				System.out.println("Csak számot adhat meg.");
				scan.nextLine();
			}
		} while (isIntegerNotValid(integer, lowestValue, highestValue));
		return integer;
	}

	public double getValidDouble(double lowestValue, double highestValue) {
		DecimalFormat format = new DecimalFormat("###.#");
		double number = lowestValue - 1;
		do {
			try {

				System.out.println("Kérem, adjon meg egy számot ami egyenlő vagy nagyobb mint " + format.format(lowestValue) + " és egyenlő vagy kisebb mint " + format.format(highestValue) + ".");
				number = getNumberFromUser();
				if (isDoubleNotValid(number, lowestValue, highestValue)) {
					System.out.println("A megadott szám nem felel meg a kritériumnak.");
				}
			} catch (Exception e) {
				System.out.println("Csak számot adhat meg.");
				scan.nextLine();
			}
		} while (isDoubleNotValid(number, lowestValue, highestValue));
		return number;
	}

	private boolean isIntegerNotValid(double number, double lowestValue, double highestValue) {
		return number % 1 != 0 || number < lowestValue || number > highestValue;
	}

	private boolean isDoubleNotValid(double number, double lowestValue, double highestValue) {
		return number < lowestValue || number > highestValue;
	}

}
