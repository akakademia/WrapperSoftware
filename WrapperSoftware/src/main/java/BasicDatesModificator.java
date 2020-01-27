import java.util.Scanner;

public class BasicDatesModificator {

	public void modificationOfDates(BasicDates basicDates, Scanner scanner) {
		int menuPoint = -1;

		while (menuPoint != 0) {
			Menu menu = new Menu(MenuType.ADMIN);
			GetNumber getNumber = new GetNumber(scanner);
			int categoryID = -1;
			int productID = -1;
			System.out.println(menu);
			int lowestValue = 0;
			int highestValue = menu.getFields().length - 1;
			String friendlyMessage = "Kérem, adja meg a menüpontót: ";
			String incorrectInputMessage = "Figyelem! Csak " + lowestValue + " és " + highestValue + " között egész számot adhat!";
			String exceptionMessage = "HIBA!";
			getNumber.getValidIntegerFromUser(friendlyMessage, incorrectInputMessage, exceptionMessage, lowestValue, highestValue);
			menuPoint = getNumber.getIntegerNumber();
			System.out.println(menuPoint + " - " + menu.getFields()[menuPoint] + " - menüpóntót választótt!");
			if (menuPoint == 0) {
				continue;
			}
			categoryID = chooseCategory(basicDates, scanner);
			if (categoryID < 0) {
				continue;
			}
			productID = chooseProduct(basicDates, scanner, categoryID);
			if (productID < 0) {
				continue;
			}
			basicDates.setFieldsByMenu(categoryID, productID);
		}
	}

	private int chooseProduct(BasicDates basicDates, Scanner scanner, int categoryID) {
		Menu menu = new Menu(MenuType.PRODUCTS_LIST_FOR_DATE_CHANGE);
		GetNumber getNumber = new GetNumber(scanner);
		menu.setAdditonalFields(basicDates.listProducts(categoryID));
		int menuPoint = -1;
		System.out.println(menu);
		int lowestValue = 0;
		int highestValue = menu.getFields().length - 1;
		String friendlyMessage = "Kérem, adja meg a menüpontót: ";
		String incorrectInputMessage = "Figyelem! Csak " + lowestValue + " és " + highestValue + " között egész számot adhat!";
		String exceptionMessage = "HIBA!";
		getNumber.getValidIntegerFromUser(friendlyMessage, incorrectInputMessage, exceptionMessage, lowestValue, highestValue);
		menuPoint = getNumber.getIntegerNumber();
		System.out.println(menuPoint + " - " + menu.getFields()[menuPoint] + " - menüpóntót választótt!");
		if (menuPoint == 0) {
			return -1;
		}
		return menuPoint - menu.getNumberOfBasicFields();
	}

	private int chooseCategory(BasicDates basicDates, Scanner scanner) {
		Menu menu = new Menu(MenuType.CATEGORIES_FOR_DATE_CHANGE);
		GetNumber getNumber = new GetNumber(scanner);
		menu.setAdditonalFields(basicDates.listCategories());
		int menuPoint = -1;
		System.out.println(menu);
		int lowestValue = 0;
		int highestValue = menu.getFields().length - 1;
		String friendlyMessage = "Kérem, adja meg a menüpontót: ";
		String incorrectInputMessage = "Figyelem! Csak " + lowestValue + " és " + highestValue + " között egész számot adhat!";
		String exceptionMessage = "HIBA!";
		getNumber.getValidIntegerFromUser(friendlyMessage, incorrectInputMessage, exceptionMessage, lowestValue, highestValue);
		menuPoint = getNumber.getIntegerNumber();
		System.out.println(menuPoint + " - " + menu.getFields()[menuPoint] + " - menüpóntót választótt!");
		if (menuPoint == 0) {
			return -1;
		}
		return menuPoint - menu.getNumberOfBasicFields();
	}
}
