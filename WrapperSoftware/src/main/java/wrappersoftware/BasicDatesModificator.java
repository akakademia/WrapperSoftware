package wrappersoftware;

import java.util.Scanner;

import wrappersoftware.admin.PasswordChanger;

public class BasicDatesModificator {

	public void modificationOfDates(BasicDates basicDates, Scanner scanner) {
		int menuPoint = -1;

		while (menuPoint != 0) {
			Menu menu = new Menu(MenuType.ADMIN);
			int categoryID = -1;
			int productID = -1;
			System.out.println(menu);
			int lowestValue = 0;
			int highestValue = menu.getFields().length - 1;
			GetInputFromUser getNumber = new GetInputFromUser(scanner, "Kérem, adja meg a menüpontot: ");
			menuPoint = getNumber.getValidIntegerFromUser(lowestValue, highestValue);
			System.out.println(menuPoint + " - " + menu.getFields()[menuPoint] + " - menüpontot választott!");
			if (menuPoint == 0) {
				continue;
			}
			if (menuPoint==1) {
				new PasswordChanger(scanner).initPasswordChanger();
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
			basicDates.setFieldsByMenu(categoryID, productID,scanner);
		}
	}

	private int chooseProduct(BasicDates basicDates, Scanner scanner, int categoryID) {
		Menu menu = new Menu(MenuType.PRODUCTS_LIST_FOR_DATE_CHANGE);
		menu.setAdditonalFields(basicDates.listProducts(categoryID));
		int menuPoint = -1;
		System.out.println(menu);
		int lowestValue = 0;
		int highestValue = menu.getFields().length - 1;
		GetInputFromUser getNumber = new GetInputFromUser(scanner, "Kérem, adja meg a menüpontot: ");
		menuPoint = getNumber.getValidIntegerFromUser(lowestValue, highestValue);
		System.out.println(menuPoint + " - " + menu.getFields()[menuPoint] + " - menüpontot választott!");
		if (menuPoint == 0) {
			return -1;
		}
		return menuPoint - menu.getNumberOfBasicFields();
	}

	private int chooseCategory(BasicDates basicDates, Scanner scanner) {
		Menu menu = new Menu(MenuType.CATEGORIES_FOR_DATE_CHANGE);
		menu.setAdditonalFields(basicDates.listCategories());
		int menuPoint = -1;
		System.out.println(menu);
		int lowestValue = 0;
		int highestValue = menu.getFields().length - 1;
		GetInputFromUser getNumber = new GetInputFromUser(scanner, "Kérem, adja meg a menüpontot: ");
		menuPoint = getNumber.getValidIntegerFromUser(lowestValue, highestValue);
		System.out.println(menuPoint + " - " + menu.getFields()[menuPoint] + " - menüpontot választott!");
		if (menuPoint == 0) {
			return -1;
		}
		return menuPoint - menu.getNumberOfBasicFields();
	}
}
