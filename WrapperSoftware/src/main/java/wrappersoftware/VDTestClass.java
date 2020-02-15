package wrappersoftware;

public class VDTestClass {

	public static void main(String[] args) {

		// példa termékek
		GlassyProduct pro1 = new GlassyProduct("product1", 50, 60, 1000, 1, 1);
		GlassyProduct pro2 = new GlassyProduct("product2", 120, 100, 4050, 1, 1);
		GlassyProduct pro3 = new GlassyProduct("product3", 130, 90, 4500, 1, 1);
		GlassyProduct pro4 = new GlassyProduct("product3", 150, 30, 3, 1, 1);
		GlassyProduct pro5 = new GlassyProduct("product3", 110, 120, 16, 1, 1);
		GlassyProduct[] order = { pro1, pro2, pro3, pro4, pro5 };

		
		Box box1 = new Box("box1",160, 155, 300);
		Box box2 = new Box("box2",190, 120, 250);
		Box box3 = new Box("box3",250, 60, 180);
		Box box4 = new Box("null",0, 0, 0); // return value when there isn't proper box for the package
		Box plannedBox = new Box();

		MatrixSheet stickers1 = new MatrixSheet("kicsi", 74, 105, 21, 750); // for box3 only
		MatrixSheet stickers2 = new MatrixSheet("nagy", 120, 110, 21, 950); // for box1 box2

		PackOfGlasses firstPack = new PackOfGlasses();
		PackOfGlasses secondPack;
		PackWrappingCalculator packWrappingCalculator = new PackWrappingCalculator();
		int index = 0;
		int cardboardPrice = 0;
		int plannedCardboardPrice=0;

		do {
			System.out.format("%n" + (index+1) + ". üvegig csomagolás%n");
			secondPack = new PackOfGlasses(order[index].getWidth(), order[index].getWidth(), order[index].getHeight(),
					order[index].getWeight());
			firstPack = packWrappingCalculator.createANewPackWithNewProduct(firstPack, secondPack);
			System.out.println("Csomag paraméterei: " + firstPack);
			Box boxToPack = packWrappingCalculator.toChooseBoxToThePack(firstPack);
			if (!boxToPack.equals(box4)) {
				if (boxToPack.equals(box1)) {
					plannedBox = box1;
				} else if (boxToPack.equals(box2)) {
					plannedBox = box2;
				} else if (boxToPack.equals(box3)) {
					plannedBox = box3;
				}
				plannedCardboardPrice= packWrappingCalculator.calculateCardboardPrice(firstPack);
				index++;
				System.out.println("A csomag ebbe a dobozba fér bele: " + boxToPack);
			}
			if (boxToPack.equals(box4) || index == order.length) {
				System.out.println("A csomag egyik dobozba sem fér bele, vagy ez az utolsó üveg.");
				System.out.println("Lezárjuk a dobozt a " + index + ". üvegig, ez a csomag ebbe a dobozba fér bele: " + plannedBox);
				if (plannedBox.equals(box1)) {
					box1.addOneBox();
				} else if (plannedBox.equals(box2)) {
					box2.addOneBox();
				} else if (plannedBox.equals(box3)) {
					box3.addOneBox();
				}
				cardboardPrice+=plannedCardboardPrice;
				firstPack.toEmptyPackOfGlasses();
			}
		} while (index < order.length);

		int numberOfBoxes = box1.getNumberOfNeccesaryBoxes() + box2.getNumberOfNeccesaryBoxes()
				+ box3.getNumberOfNeccesaryBoxes();
		int numberOfAirplus = (numberOfBoxes + 1) / 2;
		
		stickers1.setNumberOfNeccesaryMatrixes(box3.getNumberOfNeccesaryBoxes());
		stickers2.setNumberOfNeccesaryMatrixes(box1.getNumberOfNeccesaryBoxes() + box2.getNumberOfNeccesaryBoxes());

		System.out.format("%nAz üvegek csomagolásához szükséges anyagok:%n%n");
		System.out.println("Dobozok száma: " + numberOfBoxes + ", ezen belül kell:");

		System.out.println("box 1 típusú doboz (db): " + box1.getNumberOfNeccesaryBoxes());
		System.out.println("box 2 típusú doboz (db): " + box2.getNumberOfNeccesaryBoxes());
		System.out.println("box 3 típusú doboz (db): " + box3.getNumberOfNeccesaryBoxes());
		System.out.println("Térkitöltő: " + numberOfAirplus + " db");

		System.out.println("Kicsi matricából szükséges (ív): " + stickers1.calculateNeccesaryMatrixSheet());
		System.out.println("Nagy matricából szükséges (ív): " + stickers2.calculateNeccesaryMatrixSheet());
		System.out.println();
		System.out.println("Ár-kalkuláció:");
		System.out.println();
		System.out.println("A dobozokhoz szükséges kartonok ára összesen: " + cardboardPrice);
		System.out.println("Kicsi matricák ára: " + stickers1.calculatePrice());
		System.out.println("Nagy matricák ára: " + stickers2.calculatePrice());
		System.out.println("Térkitöltő ára: " + numberOfAirplus*250);
		System.out.println("A csomagolás teljes költsége: " + (cardboardPrice + stickers1.calculatePrice() + stickers2.calculatePrice()+ numberOfAirplus*250));
		

	}

}
