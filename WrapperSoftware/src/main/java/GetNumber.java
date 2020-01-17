import java.text.DecimalFormat;
import java.util.Scanner;

public class GetNumber {
	DecimalFormat format = new DecimalFormat("###.#");
	private double number;

	public GetNumber() {

	}

	public double getValidInteger(double lowestValue, double highestValue) {
		Scanner scan = new Scanner(System.in);
		double integer = 0;
		do {
			try {

				System.out.println("Kérem, adjon meg egy egész számot ami egyenlő vagy nagyobb mint " + format.format(lowestValue) + " és egyenlő kisebb mint " + format.format(highestValue) + ".");
				integer = scan.nextDouble();
				if (isIntegerNotValid(integer, lowestValue, highestValue)) {
					System.out.println("A megadott szám nem felel még a kritériumnak.");
				}
			} catch (Exception e) {
				System.out.println("Csak számot adhat meg.");
			}
		} while (isIntegerNotValid(integer, lowestValue, highestValue));
		scan.close();
		return integer;
	}

	public double getValidDouble(double lowestValue, double highestValue) {
		Scanner scan = new Scanner(System.in);
		double integer = 0;
		do {
			try {

				System.out.println("Kérem, adjon meg egy számot ami egyenlő vagy nagyobb mint " + format.format(lowestValue) + " és egyenlő vagy kisebb mint " + format.format(highestValue) + ".");
				integer = scan.nextDouble();
				if (isDoubleNotValid(integer, lowestValue, highestValue)) {
					System.out.println("A megadott szám nem felel meg a kritériumnak.");
				}
			} catch (Exception e) {
				System.out.println("Csak számot adhat meg.");
			}
		} while (isDoubleNotValid(integer, 1, 5));
		scan.close();
		return integer;
	}

	private boolean isIntegerNotValid(double number, double lowestValue, double highestValue) {
		return number % 1 != 0 || number < lowestValue || number > highestValue;
	}

	private boolean isDoubleNotValid(double number, double lowestValue, double highestValue) {
		return number < lowestValue || number > highestValue;
	}

	public double getNumber() {
		return number;
	}

	public void setNumber(double number) {
		this.number = number;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		if (number % 1 == 0) {
			builder.append("A megadott szám: ")
					.append(format.format(number));
		} else {
			builder.append("A megadott szám: ")
					.append(number);
		}
		return builder.toString();
	}

}
