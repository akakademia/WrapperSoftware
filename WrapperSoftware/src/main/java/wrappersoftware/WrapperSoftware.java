package wrappersoftware;

import java.util.Scanner;

import wrappersoftware.login.Login;

public class WrapperSoftware {

	public static void main(String[] args) {

		new WrapperSoftware().run();

	}

	private void run() {

		Scanner scanner = new Scanner(System.in);
		System.out.println("Üdvözlöm a Team7 által létrehozott WrapperSoftwareben!");
		System.out.println("Welcome to the WrapperSoftware created by Team7!");
		System.out.println();

		BasicDates basicDates = new BasicDates();
		int menuPoint = -1;

		do {
			Menu menu = new Menu(MenuType.ENTER); // ez a belépési rész
			System.out.println(menu);
			GetInputFromUser getInput = new GetInputFromUser(scanner, "Kérem, adja meg menüpontot: ");
			menuPoint = getInput.getValidIntegerFromUser(0, menu.getFields().length - 1);
			if (menuPoint == 1 && new Login(scanner).isPasswordCorrect()) {
				new BasicDatesModificator().modificationOfDates(basicDates, scanner); // Ez az adatmodosítás
				System.out.println();
				break;
			}
			System.out.println();
		} while (menuPoint != 0);

		boolean isProgramEnd = false;

		while (!isProgramEnd) {
			Order order = new Order();
			new OrderCompilator().setUpOrder(basicDates, order, scanner); // ez a megrendelés összeállítási rész

			System.out.println(); // ez a számolási rész
			System.out.println("SZÁMÍTÁS....");
			System.out.println("EREDMÉNY....");
			System.out.println();

			menuPoint = -1;
			while (menuPoint != 1) {
				Menu menu = new Menu(MenuType.SAVE_FILE_RESTART_LOG_OUT);
				System.out.println(menu);
				GetInputFromUser getInput = new GetInputFromUser(scanner, "Kérem, adja meg menüpontot: ");
				menuPoint = getInput.getValidIntegerFromUser(0, menu.getFields().length - 1);
				if (menuPoint == 2) {
					isProgramEnd = true;
					System.out.println("Viszlát!");
					break;
				}
				if (menuPoint == 1) {
					System.out.println("Az új megrendelés összeállítása:");
					System.out.println();
				} else {
					System.out.println("Fájlba mentés....");
					System.out.println();
				}
			}
		}
	}
}