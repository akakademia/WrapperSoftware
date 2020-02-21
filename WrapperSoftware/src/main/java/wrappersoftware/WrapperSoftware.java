package wrappersoftware;

import java.util.Scanner;

import wrappersoftware.admin.Login;
import wrappersoftware.report.ReportGenerator;

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

			System.out.println();

			Results results = new Results(order, basicDates);
			results.printProductsNotPackable();
			System.out.println();
			results.printProductsAbleToPack();
			System.out.println();

			System.out.format("%nAz üvegek csomagolásához szükséges anyagok:%n%n");
			System.out.println("Dobozok száma: " + results.getNeedfulCardboards() + ", ezen belül kell:");
			for (Box box : results.getNeedfulBoxes()) {
				System.out.println(box.toString() + " típusú (db): " + box.getNumberOfNeccesaryBoxes());

			}
			System.out.println();
			System.out.println("Térkitöltő: " + results.getNeedfulAirplus() + " db");
			System.out.println();
			for (int i = 0; i < results.getNeedfulMatrixSheets().length; i++) {
				System.out.println(results.getNeedfulMatrixSheets()[i].getName() + " matricából szükséges (ív): " + results.getNeedfulMatrixSheets()[i].calculateNeccesaryMatrixSheet() + " db");
			}
			System.out.println();
			System.out.println("Ár-kalkuláció:");
			System.out.println();
			System.out.println("A dobozokhoz szükséges kartonok ára összesen: " + results.getCardboardsTotalCost() + " Ft.");
			for (int i = 0; i < results.getNeedfulMatrixSheets().length; i++) {
				System.out.println(results.getNeedfulMatrixSheets()[i].getName() + " matricák - ívek ára összesen: " + results.getNeedfulMatrixSheets()[i].calculatePrice() + " Ft.");
			}
			System.out.println("Térkitöltő ára: " + results.getAirplusTotalCost() + " Ft.");
			System.out.println("A csomagolás teljes költsége: " + results.getSumCostWithDiscont() + " Ft, " + order.getDiscount() + " %-os kedvezménnyel");
			System.out.println();

			new ReportGenerator(results, "teszt1").generateReport();

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
					String costumerName = new GetInputFromUser(scanner).getStringInputFromUser("Kérem adja meg a vásárló nevét: ");

					System.out.println("Fájlba mentés....");
					System.out.println();

					new ReportGenerator(results, costumerName).generateReport();
				}
			}
		}
	}
}