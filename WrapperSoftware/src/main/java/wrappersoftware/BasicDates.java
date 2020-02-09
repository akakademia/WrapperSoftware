package wrappersoftware;

import java.util.Scanner;

public class BasicDates {

	private GlassyProduct[] glassyProducts;
	private Cardboard[] cardboards;
	private MatrixSheet[] matrixSheets;
	private BubbleWrap bubbleWrap;

	{
		glassyProducts = new GlassyProduct[] { 
				new GlassyProduct("Csatos", 106, 160, 1770, 1000, 300), 
				new GlassyProduct("Csatos", 125, 216, 3440, 2000, 400),
				new GlassyProduct("Hatszögletes díszüveg", 57, 55, 205, 105, 160), 
				new GlassyProduct("Hatszögletes díszüveg", 104, 110, 410, 210, 170),
				new GlassyProduct("Hatszögletes díszüveg", 152, 165, 605, 305, 190), 
				new GlassyProduct("Kerek díszüveg", 40, 70, 110, 40, 200),
				new GlassyProduct("Kerek díszüveg", 50, 70, 140, 50, 300), 
				new GlassyProduct("Kerek díszüveg", 60, 80, 200, 100, 400), 
				new GlassyProduct("Kerek díszüveg", 110, 90, 400, 200, 500),
				new GlassyProduct("Caviar üveg", 60, 80, 200, 100, 200), 
				new GlassyProduct("Caviar üveg", 120, 150, 420, 210, 300) 
				};

		cardboards = new Cardboard[] { 
				new Cardboard("3 rétegű 'E'-hullám", 480, 680, 0.15, 5000, 20), 
				new Cardboard("3 rétegű 'B'-hullám", 480, 680, 0.3, 10000, 30),
				new Cardboard("3 rétegű 'C'-hullám", 480, 680, 0.4, 15000, 40), 
				new Cardboard("5 rétegű 'BE'-hullám", 480, 680, 0.35, 20000, 50),
				new Cardboard("5 rétegű 'BC'-hullám", 480, 680, 0.67, 30000, 60), 
				new Cardboard("5 rétegű 'AC'-hullám", 480, 680, 0.87, 40000, 70),
				new Cardboard("7 rétegű 'AAC'-hullám", 480, 680, 1.38, 50000, 110) 
				};

		matrixSheets = new MatrixSheet[] { 
				new MatrixSheet("Kicsi", 38, 63, 21, 450), 
				new MatrixSheet("Közepes", 74, 105, 21, 750), 
				new MatrixSheet("Nagy", 110, 120, 21, 950),
				new MatrixSheet("Extra nagy", 50, 200, 21, 1120) 
				};

		bubbleWrap = new BubbleWrap("Airplus", 500, 500, 100, 20, 250);
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

	public void setFieldsByMenu(int categoryID, int productID, Scanner scan) {
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
		int lowestValue = 20;
		int highestValue = 300;
		GetInputFromUser getNumber = new GetInputFromUser(scan);

		String name = getNumber.getStringInputFromUser("Kérem, adja meg a termék nevét: ");
		glassyProducts[productID].setName(name);

		getNumber = new GetInputFromUser(scan, "Kérem, adja meg az üveg magasságát mm-ben melynek mérete " + lowestValue + " és " + highestValue + " közötti egész szám lehet.: ");
		int height = getNumber.getValidIntegerFromUser(lowestValue, highestValue);
		glassyProducts[productID].setHeight(height);

		getNumber = new GetInputFromUser(scan, "Kérem, adja meg az üveg szélességét mm-ben melynek mérete " + lowestValue + " és " + highestValue + " közötti egész szám lehet.: ");
		int width = getNumber.getValidIntegerFromUser(lowestValue, highestValue);
		glassyProducts[productID].setWidth(width);

		int volume = 3 * width / 2 * width / 2 * height / 1000;
		glassyProducts[productID].setVolume(volume);

		int weight = (int) (volume * 1.5);
		glassyProducts[productID].setWeight(weight);

		System.out.println("Ezek a modosított termék adatai: ");
		System.out.println(glassyProducts[productID]);
		System.out.println();
	}

	private void setCardboards(int productID, Scanner scan) {
		System.out.println();
		int lowestValue = 0;
		int highestValue = 2000;
		GetInputFromUser getNumber = new GetInputFromUser(scan);

		String name = getNumber.getStringInputFromUser("Kérem, adja meg a termék nevét: ");
		cardboards[productID].setName(name);

		getNumber = new GetInputFromUser(scan, "Kérem, adja meg a dekorkarton árát forintban ami " + lowestValue + " és " + highestValue + " közötti egész szám lehet.: ");
		int price = getNumber.getValidIntegerFromUser(lowestValue, highestValue);
		cardboards[productID].setPrice(price);

		System.out.println("Ezek a modosított termék adatai: ");
		System.out.println(cardboards[productID]);
		System.out.println();
	}

	private void setMatrixSheets(int productID, Scanner scan) {
		System.out.println();
		int lowestValue = 1;
		int highestValue = 200;
		GetInputFromUser getNumber = new GetInputFromUser(scan);

		String name = getNumber.getStringInputFromUser("Kérem, adja meg a termék nevét: ");
		matrixSheets[productID].setName(name);

		getNumber = new GetInputFromUser(scan, "Kérem, adja meg a matrica szélességét mm-ben ami " + lowestValue + " és " + highestValue + " közötti egész szám lehet.: ");
		int widthOfOneMatrix = getNumber.getValidIntegerFromUser(lowestValue, highestValue);
		matrixSheets[productID].setWidthOfOneMatrix(widthOfOneMatrix);

		getNumber = new GetInputFromUser(scan, "Kérem, adja meg a matrica hosszúságát mm-ben ami " + lowestValue + " és " + highestValue + " közötti egész szám lehet.: ");
		int lengthOfOneMatrix = getNumber.getValidIntegerFromUser(lowestValue, highestValue);
		matrixSheets[productID].setLengthOfOneMatrix(lengthOfOneMatrix);

		getNumber = new GetInputFromUser(scan, "Kérem, adja meg a matricák darabszámát egy íven ami " + lowestValue + " és " + highestValue + " közötti egész szám lehet.: ");
		int pieceInSheet = getNumber.getValidIntegerFromUser(lowestValue, highestValue);
		matrixSheets[productID].setPieceInSheet(pieceInSheet);

		highestValue = 10000;
		getNumber = new GetInputFromUser(scan, "Kérem, adja meg az egy matricaív árát forintban ami " + lowestValue + " és " + highestValue + " közötti egész szám lehet.: ");
		int price = getNumber.getValidIntegerFromUser(lowestValue, highestValue);
		matrixSheets[productID].setPrice(price);

		System.out.println("Ezek a modosított termék adatai: ");
		System.out.println(matrixSheets[productID]);
		System.out.println();
	}

	private void setBubbleWraps(Scanner scan) {
		System.out.println();
		int lowestValue = 1;
		int highestValue = 2000;
		GetInputFromUser getNumber = new GetInputFromUser(scan);

		String name = getNumber.getStringInputFromUser("Kérem, adja meg a termék nevét: ");
		bubbleWrap.setName(name);

		getNumber = new GetInputFromUser(scan, "Kérem, adja meg a térkitöltő lap szélességét mm-ben ami " + lowestValue + " és " + highestValue + " közötti egész szám lehet.: ");
		int width = getNumber.getValidIntegerFromUser(lowestValue, highestValue);
		bubbleWrap.setWidth(width);

		getNumber = new GetInputFromUser(scan, "Kérem, adja meg a térkitöltő lap hosszúságát mm-ben ami " + lowestValue + " és " + highestValue + " közötti egész szám lehet.: ");
		int length = getNumber.getValidIntegerFromUser(lowestValue, highestValue);
		bubbleWrap.setLength(length);

		highestValue = 200;
		getNumber = new GetInputFromUser(scan, "Kérem, adja meg a térkitöltő lap vastagságát mm-ben ami " + lowestValue + " és " + highestValue + " közötti egész szám lehet.: ");
		int thickness = getNumber.getValidIntegerFromUser(lowestValue, highestValue);
		bubbleWrap.setThickness(thickness);

		lowestValue = 0;
		highestValue = thickness - 1;
		getNumber = new GetInputFromUser(scan, "Kérem, adja meg a térkitöltő lap zsugorodási mértékét mm-ben ami " + lowestValue + " és " + highestValue + " közötti egész szám lehet.: ");
		int retraction = getNumber.getValidIntegerFromUser(lowestValue, highestValue);
		bubbleWrap.setRetraction(retraction);

		highestValue = 100000;
		getNumber = new GetInputFromUser(scan, "Kérem, adja meg a térkitöltő lap árát forintban ami " + lowestValue + " és " + highestValue + " közötti egész szám lehet.: ");
		int price = getNumber.getValidIntegerFromUser(lowestValue, highestValue);
		bubbleWrap.setPrice(price);

		System.out.println("Ezek a módosított termék adatai: ");
		System.out.println(bubbleWrap);
		System.out.println();
	}

}
