import java.util.Arrays;
import java.util.Scanner;

import Login.GetInputFromUser;

public class WrapperSoftware {

	public static void main(String[] args) {

		new WrapperSoftware().run();

	}

	private void run() {

		Scanner scanner = new Scanner(System.in);
		System.out.println("Üdvözlöm a Team7 által létrehozott WrapperSoftwareben!");
		System.out.println("Welcome to the WrapperSoftware created by Team7!");
		Menu menu = new Menu(MenuType.ENTER); // ez a belépési rész
		System.out.println(menu);

		if ((new GetInputFromUser(scanner).getValidIntegerFromUser(0, menu.getFields().length - 1)) != 0) {
			chooseCategoryAndChangeDates(scanner); // ez az adatmódosítási rész
		}

		int menuPoint = -1;
		do {
			setOrder(scanner); // ez a megrendelési rész

			System.out.println(); // ez a számólási rész
			System.out.println("SZÁMÍTÁS....");
			System.out.println("EREDMÉNY....");
			System.out.println();

			menuPoint = saveFileRestartLogOut(scanner); // ez a fájlmentés/újraszámlalás vagy kilépés rész
		} while (menuPoint != 2);

		scanner.close(); // fontos hogy ez a sor mindig utolsó legyen
	}

	private int saveFileRestartLogOut(Scanner scanner) {
		int menuPoint = 0;
		while (menuPoint == 0) {
			Menu menu = new Menu(MenuType.SAVE_FILE_RESTART_LOG_OUT);
			System.out.println(menu);
			menuPoint = (int) new GetInputFromUser(scanner).getValidIntegerFromUser(0, menu.getFields().length - 1);
			if (menuPoint == 0) {
				System.out.println("Fájlba mentés....");
			}
			if (menuPoint == 1) {
				System.out.println("Az új megrendelés összeállítása:");
			}
		}
		return menuPoint;
	}

	private void setOrder(Scanner scanner) {
		Menu menu = new Menu(MenuType.ORDER);
		String[] productsAll = { "Termék A", "Termék B", "Termék C" }; // ez csak egy teszt tömb
		String[] productsInOrder = null; // ez csak egy teszt tömb
		int discount = 0;
		int menuPoint = -1;
		do {
			System.out.println("Megrendelés tartalma: ");
			System.out.println(Arrays.toString(productsInOrder));
			System.out.println("Kedvezmény mértéke: " + discount);
			System.out.println(menu);
			menuPoint = (int) new GetInputFromUser(scanner).getValidIntegerFromUser(0, menu.getFields().length - 1);
			System.out.println(menuPoint + " - " + menu.getFields()[menuPoint] + " - menüpóntót választótt!");
			if (menuPoint == 0) {
				productsInOrder = productAddToOrder(scanner, productsAll, productsInOrder);
			} else if (menuPoint == 1) {
				productsInOrder = productRemoveFromOrder(scanner, productsInOrder);
			} else if (menuPoint == 2) {
				System.out.println("Kedvezmény beállítása: ");
				discount = (int) new GetInputFromUser(scanner).getValidIntegerFromUser(0, 100);
				System.out.println("Az új kedvezmény mértéke: " + discount);
			}
		} while (menuPoint != 3);
	}

	private String[] productRemoveFromOrder(Scanner scanner, String[] productsInOrder) {
		Menu menu = new Menu(MenuType.PRODUCTS_LIST_TO_REMOVE);
		menu.setAdditonalFields(productsInOrder);
		System.out.println(menu);
		int menuPoint = (int) new GetInputFromUser(scanner).getValidIntegerFromUser(0, menu.getFields().length - 1);
		System.out.println(menuPoint + " - " + menu.getFields()[menuPoint] + " - menüpóntót választótt!");
		if (menuPoint != 0) {
			String[] newOrder = new String[productsInOrder.length - 1];
			int index = menuPoint - menu.getNumberOfBasicFields();
			for (int i = 0, j = 0; i < productsInOrder.length; i++) {
				if (i != index) {
					newOrder[j++] = productsInOrder[i];
				}
			}
			productsInOrder = newOrder;
		}
		return productsInOrder;
	}

	private String[] productAddToOrder(Scanner scanner, String[] productsAll, String[] productsInOrder) {
		Menu menu = new Menu(MenuType.PRODUCTS_LIST_TO_ADD);
		menu.setAdditonalFields(productsAll);
		System.out.println(menu);
		int menuPoint = (int) new GetInputFromUser(scanner).getValidIntegerFromUser(0, menu.getFields().length - 1);
		System.out.println(menuPoint + " - " + menu.getFields()[menuPoint] + " - menüpóntót választótt!");
		if (menuPoint != 0) {
			if (productsInOrder == null || productsInOrder.length < 1 || productsInOrder[0] == null) {
				productsInOrder = new String[] { menu.getFields()[menuPoint] };
			} else {
				String[] newOrder = new String[productsInOrder.length + 1];
				newOrder[0] = menu.getFields()[menuPoint];
				for (int i = 1; i < newOrder.length; i++) {
					newOrder[i] = productsInOrder[i - 1];
				}
				productsInOrder = newOrder;
			}
		}
		return productsInOrder;
	}

	private void chooseCategoryAndChangeDates(Scanner scanner) {
		Menu menu = new Menu(MenuType.ADMIN);
		int menuPoint = -1;
		System.out.println(menu);
		menuPoint = (int) new GetInputFromUser(scanner).getValidIntegerFromUser(0, menu.getFields().length - 1);
		System.out.println(menuPoint + " - " + menu.getFields()[menuPoint] + " - menüpóntót választótt!");
		if (menuPoint != 0) {
			chooseCategory(scanner);
		}
	}

	private void chooseCategory(Scanner scanner) {
		Menu menu = new Menu(MenuType.CATEGORIES_FOR_DATE_CHANGE);
		int menuPoint = -1;
		while (menuPoint != 0) {
			System.out.println(menu);
			menuPoint = (int) new GetInputFromUser(scanner).getValidIntegerFromUser(0, menu.getFields().length - 1);
			System.out.println(menuPoint + " - " + menu.getFields()[menuPoint] + " - menüpóntót választótt!");
			if (menuPoint != 0) {
				int category = menuPoint - menu.getNumberOfBasicFields();
				changeDates(scanner, category);
			}
		}
	}

	private void changeDates(Scanner scanner, int category) {

		String[] productsOfCategory = { "Termék A", "Termék B", "Termék C" }; // ez csak egy teszt tömb
		Menu menu = new Menu(MenuType.PRODUCTS_LIST_FOR_DATE_CHANGE);
		menu.setAdditonalFields(productsOfCategory);
		int menuPoint = -1;
		do {
			System.out.println(menu);
			menuPoint = (int) new GetInputFromUser(scanner).getValidIntegerFromUser(0, menu.getFields().length - 1);
			System.out.println(menuPoint + " - " + menu.getFields()[menuPoint] + " - menüpóntót választótt!");
			if (menuPoint != 0) {
				int productID = menuPoint;
				String productName = menu.getFields()[menuPoint];
				String[] fieldsToChange = { "Ár", "Méret", "Név" }; // ez csak egy teszt tömb
				int index = chooseFields(scanner, productID, fieldsToChange);
				if (index >= 0) {
					String productFieldName = fieldsToChange[index];
					changeField(productID, index, productName, productFieldName, scanner);
					System.out.println();
				}
			}
		} while (menuPoint != 0);
	}

	private int chooseFields(Scanner scanner, int productID, String[] fieldsToChange) {
		Menu menu = new Menu(MenuType.FIELDS_FOR_DATE_CHANGE);
		menu.setAdditonalFields(fieldsToChange);
		System.out.println(menu);
		int menuPoint = (int) new GetInputFromUser(scanner).getValidIntegerFromUser(0, menu.getFields().length - 1);
		System.out.println(menuPoint + " - " + menu.getFields()[menuPoint] + " - menüpóntót választótt!");
		return menuPoint - menu.getNumberOfBasicFields();
	}

	private void changeField(int productID, int index, String productName, String productFieldName, Scanner scanner) {
		System.out.println("Ez a metódus kiválasztót termék - " + productName + " adatát - " + productFieldName + " változtat...");
		System.out.println("productID = " + productID + ", fieldID = " + index);
		System.out.println("Kérem, adja meg az új " + productFieldName + " értékét: ");
		int newDate = (int) new GetInputFromUser(scanner).getValidIntegerFromUser(0, Integer.MAX_VALUE);
		System.out.println("A(z) " + productFieldName + " új értéke = " + newDate);
	}

}
