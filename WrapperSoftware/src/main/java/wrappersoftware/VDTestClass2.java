package wrappersoftware;

public class VDTestClass2 {
	private Box[] boxes;
	private int numberOfBoxes;
	private int numberOfAirplus;
	private MatrixSheet[] matrixs;
	private int MatrixCost;
	private int cardboardPrice;

	public VDTestClass2(GlassyProduct[] order) {
		Box box1 = new Box("box1", 160, 155, 300);
		Box box2 = new Box("box2", 190, 120, 250);
		Box box3 = new Box("box3", 250, 60, 180);
		Box box4 = new Box("null", 0, 0, 0);
		boxes = new Box[] { box1, box2, box3, box4 };
		MatrixSheet stickers1 = new MatrixSheet("kicsi", 74, 105, 21, 750);
		MatrixSheet stickers2 = new MatrixSheet("nagy", 120, 110, 21, 950);
		matrixs = new MatrixSheet[] { stickers1, stickers2 };
		Box plannedBox = new Box();
		PackOfGlasses firstPack = new PackOfGlasses();
		PackOfGlasses secondPack;
		PackWrappingCalculator packWrappingCalculator = new PackWrappingCalculator();
		int index = 0;
		cardboardPrice = 0;
		int plannedCardboardPrice = 0;
		do {
			secondPack = new PackOfGlasses(order[index].getWidth(), order[index].getWidth(), order[index].getHeight(), order[index].getWeight());
			firstPack = packWrappingCalculator.createANewPackWithNewProduct(firstPack, secondPack);
			Box boxToPack = packWrappingCalculator.toChooseBoxToThePack(firstPack);
			if (!boxToPack.equals(box4)) {
				if (boxToPack.equals(box1)) {
					plannedBox = box1;
				} else if (boxToPack.equals(box2)) {
					plannedBox = box2;
				} else if (boxToPack.equals(box3)) {
					plannedBox = box3;
				}
				plannedCardboardPrice = packWrappingCalculator.calculateCardboardPrice(firstPack);
				index++;
			}
			if (boxToPack.equals(box4) || index == order.length) {
				if (plannedBox.equals(box1)) {
					box1.addOneBox();
				} else if (plannedBox.equals(box2)) {
					box2.addOneBox();
				} else if (plannedBox.equals(box3)) {
					box3.addOneBox();
				}
				cardboardPrice += plannedCardboardPrice;
				firstPack.toEmptyPackOfGlasses();
			}
		} while (index < order.length);

		numberOfBoxes = box1.getNumberOfNeccesaryBoxes() + box2.getNumberOfNeccesaryBoxes() + box3.getNumberOfNeccesaryBoxes();
		numberOfAirplus = (numberOfBoxes + 1) / 2;

		stickers1.setNumberOfNeccesaryMatrixes(box3.getNumberOfNeccesaryBoxes());
		stickers2.setNumberOfNeccesaryMatrixes(box1.getNumberOfNeccesaryBoxes() + box2.getNumberOfNeccesaryBoxes());
	
		MatrixCost=stickers1.calculatePrice()+stickers2.calculatePrice();
	}

	public Box[] getBoxes() {
		return boxes;
	}

	public int getNumberOfBoxes() {
		return numberOfBoxes;
	}

	public int getNumberOfAirplus() {
		return numberOfAirplus;
	}

	public MatrixSheet[] getMatrixs() {
		return matrixs;
	}

	public int getCardboardPrice() {
		return cardboardPrice;
	}

	public int getMatrixCost() {
		return MatrixCost;
	}
	
	

}
