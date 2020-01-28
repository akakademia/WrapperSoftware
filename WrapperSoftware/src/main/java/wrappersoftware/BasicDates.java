package wrappersoftware;

import java.util.Scanner;

public class BasicDates {

	private GlassyProduct[] glassyProducts;
	private Cardboard[] cardboards;
	private MatrixSheet[] matrixSheets;
	private BubbleWrap bubbleWrap;

	{
		glassyProducts = new GlassyProduct[] { new GlassyProduct("Csatos", 10.6, 16.0, 0.77, 1000), new GlassyProduct("Csatos", 12.5, 21.6, 1.44, 2000),
				new GlassyProduct("Hatszögletes díszüveg", 5.7, 5.5, 0.1, 105), new GlassyProduct("Hatszögletes díszüveg", 10.4, 11.0, 0.2, 210),
				new GlassyProduct("Hatszögletes díszüveg", 15.2, 16.5, 0.3, 305), new GlassyProduct("Kerek díszüveg", 4.0, 7.0, 0.07, 40), new GlassyProduct("Kerek díszüveg", 5.0, 7.0, 0.09, 50),
				new GlassyProduct("Kerek díszüveg", 6.0, 8.0, 0.1, 100), new GlassyProduct("Kerek díszüveg", 11.0, 9.0, 0.2, 200), new GlassyProduct("Caviar üveg", 6.0, 8.0, 0.1, 100),
				new GlassyProduct("Caviar üveg", 12.0, 15.0, 0.21, 210) };

		cardboards = new Cardboard[] { new Cardboard("3 rétegű 'E'-hullám", 48, 68, 0.15, 5.0, 1), new Cardboard("3 rétegű 'B'-hullám", 48, 68, 0.3, 10.0, 1),
				new Cardboard("3 rétegű 'C'-hullám", 48, 68, 0.4, 15.0, 1), new Cardboard("5 rétegű 'BE'-hullám", 48, 68, 0.35, 20.0, 1), new Cardboard("5 rétegű 'BC'-hullám", 48, 68, 0.67, 30.0, 1),
				new Cardboard("5 rétegű 'AC'-hullám", 48, 68, 0.87, 40.0, 1), new Cardboard("5 rétegű 'BE'-hullám", 48, 68, 1.38, 50.0, 1), };

		matrixSheets = new MatrixSheet[] { new MatrixSheet("Kicsi", 3.8, 6.3, 21, 1), new MatrixSheet("Közepes", 7.4, 10.5, 21, 1), new MatrixSheet("Nagy", 11.0, 12.0, 21, 1),
				new MatrixSheet("Extra nagy", 0.5, 20.0, 21, 1), };

		bubbleWrap = new BubbleWrap("Airplus", 50, 50, 1.5, 250);
	}

	public GlassyProduct[] getGlassyProducts() {
		return glassyProducts;
	}

	public Cardboard[] getCardboards() {
		return cardboards;
	}

	public MatrixSheet[] getMatrixSheets() {
		return matrixSheets;
	}

	public BubbleWrap getBubbleWrap() {
		return bubbleWrap;
	}

	public String[] listCategories() {
		String[] list = new String[] { "Üveges termékek", "Dekorkartonok", "Matricák", "Térkitöltő" };
		return list;
	}

	public String[] listProducts(int categoryID) {
		if (categoryID == 0) {
			return listGlassyProducts();
		}
		if (categoryID == 1) {
			return listCardboards();
		}
		if (categoryID == 2) {
			return listMatrixSheets();
		} else {
			return listBubbleWraps();
		}
	}

	private String[] listGlassyProducts() {
		String[] list = new String[glassyProducts.length];
		for (int i = 0; i < list.length; i++) {
			list[i] = glassyProducts[i].toString();
		}
		return list;
	}

	private String[] listCardboards() {
		String[] list = new String[cardboards.length];
		for (int i = 0; i < list.length; i++) {
			list[i] = cardboards[i].toString();
		}
		return list;
	}

	private String[] listMatrixSheets() {
		String[] list = new String[matrixSheets.length];
		for (int i = 0; i < list.length; i++) {
			list[i] = matrixSheets[i].toString();
		}
		return list;
	}

	private String[] listBubbleWraps() {
		String[] list = new String[] { bubbleWrap.toString() };
		return list;
	}

	public void setFieldsByMenu(int categoryID, int productID) {
		Scanner scan = new Scanner(System.in);
		if (categoryID == 0) {
			setGlassyProducts(productID, scan);
		} else if (categoryID == 1) {
			setCardboards(productID, scan);
		} else if (categoryID == 2) {
			setMatrixSheets(productID, scan);
		} else {
			setBubbleWraps(scan);
		}
	}

	private void setGlassyProducts(int productID, Scanner scan) {
		System.out.println();
		String friendlyMessage = null;
		double lowestValue = 1.0;
		double highestValue = 20.0;
		GetInputFromUser getNumber = new GetInputFromUser(scan, null);

		friendlyMessage = "Kérem, adja meg a termék nevét: ";
		String name = "ERRE MÉG NINCS METÓDUS";

		getNumber = new GetInputFromUser(scan, "Kérem, adja meg az üveg szélességét cm-ben melynek mérete " + lowestValue + " és " + highestValue + " közötti egész vagy tört szám lehet.: ");
		double widthInCentimetre = getNumber.getValidDoubleFromUser(lowestValue, highestValue);

		getNumber = new GetInputFromUser(scan, "Kérem, adja meg az üveg magasságát cm-ben melynek mérete " + lowestValue + " és " + highestValue + " közötti egész vagy tört szám lehet.: ");
		double heightInCentimetre = getNumber.getValidDoubleFromUser(lowestValue, highestValue);
		highestValue = 50.0;
		getNumber = new GetInputFromUser(scan, "Kérem, adja meg az üveg súlyát kg-ban ami " + lowestValue + " és " + highestValue + " közötti egész vagy tört szám lehet.: ");
		double weightInKilogram = getNumber.getValidDoubleFromUser(lowestValue, highestValue);

		highestValue = 3000.0;
		getNumber = new GetInputFromUser(scan, "Kérem, adja meg az üveg űrtartalmát ml-ben ami " + lowestValue + " és " + highestValue + " közötti egész vagy tört szám lehet.: ");
		double volumeInCubicCentimetre = getNumber.getValidDoubleFromUser(lowestValue, highestValue);

		glassyProducts[productID] = new GlassyProduct(name, widthInCentimetre, heightInCentimetre, weightInKilogram, volumeInCubicCentimetre);
		System.out.println("Ezek a modosított termék adatai: ");
		System.out.println(glassyProducts[productID].toString());
		System.out.println();
	}

	private void setCardboards(int productID, Scanner scan) {

		System.out.println();

		String friendlyMessage = null;
		int lowestValue = 0;
		int highestValue = 200;
		double lowestDoubleValue = 0.01;
		double highestDoubleValue = 10.0;
		GetInputFromUser getNumber = new GetInputFromUser(scan);

		friendlyMessage = "Kérem, adja meg a termék nevét: ";
		String name = "ERRE MÉG NINCS METÓDUS";

		getNumber = new GetInputFromUser(scan, "Kérem, adja meg a dekorkarton szélességét cm-ben ami " + lowestValue + " és " + highestValue + " közötti egész szám lehet: ");
		int width = getNumber.getValidIntegerFromUser(lowestValue, highestValue);

		getNumber = new GetInputFromUser(scan, "Kérem, adja meg a dekorkarton hosszúságát cm-ben ami " + lowestValue + " és " + highestValue + " közötti egész szám lehet: ");
		int length = getNumber.getValidIntegerFromUser(lowestValue, highestValue);

		getNumber = new GetInputFromUser(scan, "Kérem, adja meg a dekorkarton vastagságát cm-ben ami " + lowestDoubleValue + " és " + highestDoubleValue + " közötti tört vagy egész szám lehet.: ");
		double thickness = getNumber.getValidDoubleFromUser(lowestDoubleValue, highestDoubleValue);

		highestDoubleValue = 100.0;
		getNumber = new GetInputFromUser(scan, "Kérem, adja meg a dekorkarton teherbírásást kg-ban ami " + lowestDoubleValue + " és " + highestDoubleValue + " közötti tört vagy egész szám lehet.: ");
		double carryingCapacity = getNumber.getValidDoubleFromUser(lowestDoubleValue, highestDoubleValue);

		lowestDoubleValue = 0.0;
		highestDoubleValue = 1000000.0;
		getNumber = new GetInputFromUser(scan, "Kérem, adja meg a dekorkarton árát forintban ami " + lowestValue + " és " + highestValue + " közötti egész szám lehet.: ");
		int price = getNumber.getValidIntegerFromUser(lowestValue, highestValue);
		cardboards[productID] = new Cardboard(name, width, length, thickness, carryingCapacity, price);
		System.out.println("Ezek a modosított termék adatai: ");
		System.out.println(cardboards[productID].toString());
		System.out.println();
	}

	private void setMatrixSheets(int productID, Scanner scan) {
		System.out.println();

		String friendlyMessage = null;
		int lowestValue = 1;
		int highestValue = 200;
		double lowestDoubleValue = 0.01;
		double highestDoubleValue = 50.0;
		GetInputFromUser getNumber = new GetInputFromUser(scan, friendlyMessage);

		friendlyMessage = "Kérem, adja meg a termék nevét: ";
		String name = "ERRE MÉG NINCS METÓDUS";

		getNumber = new GetInputFromUser(scan, "Kérem, adja meg a matrica szélességét cm-ben ami " + lowestDoubleValue + " és " + highestDoubleValue + " közötti tört vagy egész szám lehet.: ");
		double widthOfOneMatrixInCentimetre = getNumber.getValidDoubleFromUser(lowestDoubleValue, highestDoubleValue);

		getNumber = new GetInputFromUser(scan, "Kérem, adja meg a matrica hosszúságát cm-ben ami " + lowestDoubleValue + " és " + highestDoubleValue + " közötti tört vagy egész szám lehet.: ");
		double lengthOfOneMatrixInCentimetre = getNumber.getValidDoubleFromUser(lowestDoubleValue, highestDoubleValue);

		getNumber = new GetInputFromUser(scan, "Kérem, adja meg a matricák darabszámát egy íven ami " + lowestValue + " és " + highestValue + " közötti egész szám lehet.: ");
		int piece = getNumber.getValidIntegerFromUser(lowestValue, highestValue);
		highestValue = 10000;
		getNumber = new GetInputFromUser(scan, "Kérem, adja meg az egy matricaív árát forintban ami " + lowestValue + " és " + highestValue + " közötti egész szám lehet.: ");
		int price = getNumber.getValidIntegerFromUser(lowestValue, highestValue);
		matrixSheets[productID] = new MatrixSheet(name, widthOfOneMatrixInCentimetre, lengthOfOneMatrixInCentimetre, piece, price);
		System.out.println("Ezek a modosított termék adatai: ");
		System.out.println(matrixSheets[productID].toString());
		System.out.println();
	}

	private void setBubbleWraps(Scanner scan) {
		System.out.println();

		String friendlyMessage = null;
		int lowestValue = 1;
		int highestValue = 2000;
		double lowestDoubleValue = 0.01;
		double highestDoubleValue = 3.0;
		GetInputFromUser getNumber = new GetInputFromUser(scan, null);

		friendlyMessage = "Kérem, adja meg a termék nevét: ";
		String name = "ERRE MÉG NINCS METÓDUS";

		getNumber = new GetInputFromUser(scan, "Kérem, adja meg a térkitöltő lap szélességét cm-ben ami " + lowestValue + " és " + highestValue + " közötti egész szám lehet.: ");
		int widthInCentimetre = getNumber.getValidIntegerFromUser(lowestValue, highestValue);

		friendlyMessage = "Kérem, adja meg a térkitöltő lap hosszúságát (cm-ben és egész szám formátumban): ";
		getNumber = new GetInputFromUser(scan, "Kérem, adja meg a térkitöltő lap hosszúságát cm-ben ami " + lowestValue + " és " + highestValue + " közötti egész szám lehet.: ");
		int lengthInCentimetre = getNumber.getValidIntegerFromUser(lowestValue, highestValue);

		getNumber = new GetInputFromUser(scan, "Kérem, adja meg a dekorkarton vastagságát cm-ben ami " + lowestDoubleValue + " és " + highestDoubleValue + " közötti tört vagy egész szám lehet.: ");
		double thicknessInCentimetre = getNumber.getValidDoubleFromUser(lowestDoubleValue, highestDoubleValue);

		lowestValue = 0;
		highestValue = 100000;
		getNumber = new GetInputFromUser(scan, "Kérem, adja meg a dekorkarton árát forintban ami " + lowestValue + " és " + highestValue + " közötti egész szám lehet.: ");
		int price = getNumber.getValidIntegerFromUser(lowestValue, highestValue);
		bubbleWrap = new BubbleWrap(name, widthInCentimetre, lengthInCentimetre, thicknessInCentimetre, price);
		System.out.println("Ezek a módosított termék adatai: ");
		System.out.println(bubbleWrap.toString());
		System.out.println();
	}

}
