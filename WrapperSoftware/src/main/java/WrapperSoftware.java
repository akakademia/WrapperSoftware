import java.util.Scanner;

public class WrapperSoftware {

	public static void main(String[] args) {

		new WrapperSoftware().run();

	}

	private void run() {

		Scanner scanner = new Scanner(System.in);

		// ez a belépési rész
		Menu menu = new Menu();
		System.out.println(menu);

		// ez az adatmódosítási rész
		menu.setMenuTypeAndFields(MenuType.ADMIN);
		System.out.println(menu);

		menu.setMenuTypeAndFields(MenuType.CATEGORIS_FOR_DATE_CHANGE);
		System.out.println(menu);

		String[] productsAll = { "Tea", "Méz", "Dzsem" }; // ez csak egy teszt tömb
		menu.setMenuTypeAndFields(MenuType.PRODUCTS_LIST_FOR_DATE_CHANGE, productsAll);
		System.out.println(menu);

		String[] fieldsToChange = { "Ár", "Méret", "Név" }; // ez csak egy teszt tömb
		menu.setMenuTypeAndFields(MenuType.FIELDS_FOR_DATE_CHANGE, fieldsToChange);
		System.out.println(menu);

		// ez a megrendelési rész
		menu.setMenuTypeAndFields(MenuType.ORDER);
		System.out.println(menu);

		menu.setMenuTypeAndFields(MenuType.PRODUCTS_LIST_TO_ADD, productsAll);
		System.out.println(menu);

		String[] productsInOrder = { "Tea" }; // ez csak egy teszt tömb
		menu.setMenuTypeAndFields(MenuType.PRODUCTS_LIST_TO_REMOVE, productsInOrder);
		System.out.println(menu);

		// ez a számólási rész

		// ez a fájlmentés/újraszámlalás vagy kilépés rész
		menu.setMenuTypeAndFields(MenuType.SAVE_FILE_RESTART_LOG_OUT);
		System.out.println(menu);

		scanner.close(); // fontos hogy ez a sor mindig utolsó legyen
	}

}
