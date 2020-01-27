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
			String friendlyMessage = "Kérem, adja meg menüpontot: ";
			String incorrectInputMessage = "Helytelen szám";
			String exceptionMessage = "Hiba";
			GetInputFromUser getInput = new GetInputFromUser(scanner, friendlyMessage, incorrectInputMessage, exceptionMessage);
			getInput.getValidIntegerFromUser(0, menu.getFields().length - 1);
			menuPoint = getInput.getIntegerNumber();
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
			new OrderCompilator().setUpOrder(basicDates, order); // ez a megrendelés összeállítási rész

			System.out.println(); // ez a számólási rész
			System.out.println("SZÁMÍTÁS....");
			System.out.println("EREDMÉNY....");
			System.out.println();

			menuPoint = -1;
			while (menuPoint != 1) {
				Menu menu = new Menu(MenuType.SAVE_FILE_RESTART_LOG_OUT);
				System.out.println(menu);
				String friendlyMessage = "Kérem, adja meg menüpontot: ";
				String incorrectInputMessage = "Hibás szám!";
				String exceptionMessage = "Hiba!";
				GetInputFromUser getInput = new GetInputFromUser(scanner, friendlyMessage, incorrectInputMessage, exceptionMessage);
				getInput.getValidIntegerFromUser(0, menu.getFields().length - 1);
				menuPoint = getInput.getIntegerNumber();
				if (menuPoint == 2) {
					isProgramEnd = true;
					System.out.println("Viszlat!");
					break;
				}
				if (menuPoint == 1) {
					System.out.println("Az új megrendelés összeállítása:");
					continue;
				} else {
					System.out.println("Fájlba mentés....");
				}
			}
		}
	}
}