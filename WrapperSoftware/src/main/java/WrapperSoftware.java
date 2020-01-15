import java.util.Scanner;

public class WrapperSoftware {

	public static void main(String[] args) {

		new WrapperSoftware().run();

	}

	private void run() {

		Scanner scanner = new Scanner(System.in);

		// ez a belépési rész
		Menu menu = new Menu(MenuType.ENTER);
		System.out.println(menu);

		// ez az adatmódosítási rész
		menu = new Menu(MenuType.ADMIN);
		System.out.println(menu);

		menu = new Menu(MenuType.CATEGORIS_FOR_DATE_CHANGE);
		System.out.println(menu);

		String[] productsAll = { "Tea", "Méz", "Dzsem" }; // ez csak egy teszt tömb
		menu = new Menu(MenuType.PRODUCTS_LIST_FOR_DATE_CHANGE);
		menu.setAdditonalFields(productsAll);
		System.out.println(menu);

		String[] fieldsToChange = { "Ár", "Méret", "Név" }; // ez csak egy teszt tömb
		menu = new Menu(MenuType.FIELDS_FOR_DATE_CHANGE);
		menu.setAdditonalFields(fieldsToChange);
		System.out.println(menu);

		// ez a megrendelési rész
		menu = new Menu(MenuType.ORDER);
		System.out.println(menu);

		menu = new Menu(MenuType.PRODUCTS_LIST_TO_ADD);
		menu.setAdditonalFields(productsAll);
		System.out.println(menu);

		String[] productsInOrder = { "Tea" }; // ez csak egy teszt tömb
		menu = new Menu(MenuType.PRODUCTS_LIST_TO_REMOVE);
		menu.setAdditonalFields(productsInOrder);
		System.out.println(menu);

		// ez a számólási rész

		// ez a fájlmentés/újraszámlalás vagy kilépés rész
		menu = new Menu(MenuType.SAVE_FILE_RESTART_LOG_OUT);
		System.out.println(menu);

		scanner.close(); // fontos hogy ez a sor mindig utolsó legyen
	}

}
