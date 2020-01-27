import java.util.Scanner;

public class WrapperSoftware {

	public static void main(String[] args) {

		new WrapperSoftware().run();

	}

	private void run() {

		Scanner scanner = new Scanner(System.in);
		BasicDates basicDates = new BasicDates();

		if (true) { // ha adminként lépbe
			new BasicDatesModificator().modificationOfDates(basicDates, scanner);
		}

		boolean isProgramEnd = false;

		while (!isProgramEnd) {
			Order order = new Order();
			new OrderCompilator().setUpOrder(basicDates, order, scanner); // ez a megrendelés összeállítási rész

			System.out.println(); // ez a számólási rész
			System.out.println("SZÁMÍTÁS....");
			System.out.println("EREDMÉNY....");
			System.out.println();

			isProgramEnd = saveFileRestartLogOut(scanner); // ez a fájlmentés/újraszámlalás vagy kilépés rész

		}
		scanner.close();
	}

	private boolean saveFileRestartLogOut(Scanner scanner) {
		GetNumber getNumber = new GetNumber(scanner);
		int menuPoint = 0;
		while (menuPoint == 0) {
			Menu menu = new Menu(MenuType.SAVE_FILE_RESTART_LOG_OUT);
			System.out.println(menu);
			int lowestValue = 0;
			int highestValue = menu.getFields().length - 1;
			String friendlyMessage = "Kérem, adja meg a menüpontót: ";
			String incorrectInputMessage = "Figyelem! Csak " + lowestValue + " és " + highestValue + " között egész számot adhat!";
			String exceptionMessage = "HIBA!";
			getNumber.getValidIntegerFromUser(friendlyMessage, incorrectInputMessage, exceptionMessage, lowestValue, highestValue);
			menuPoint = getNumber.getIntegerNumber();
			if (menuPoint == 0) {
				System.out.println("Fájlba mentés....");
			}
			if (menuPoint == 1) {
				System.out.println("Az új megrendelés összeállítása:");
				return false;
			}
		}
		return true;
	}
}
