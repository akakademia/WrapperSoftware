package wrappersoftware;

public class PackWrappingCalculator {

	private Box box1 = new Box("box1", 160, 155, 300); // is the highest and the widest
	private Box box2 = new Box("box2", 190, 120, 250);
	private Box box3 = new Box("box3", 250, 60, 180);
	private Box box4 = new Box("null", 0, 0, 0);

	public PackWrappingCalculator() {
	}

	public int calculateCardboardPrice(PackOfGlasses packOfGlasses) {
		if (packOfGlasses.getWeight() <= 5000) {
			return 20;
		} else if (packOfGlasses.getWeight() <= 10000) {
			return 30;
		} else {
			return 40;
		}
	}

	public Box toChooseBoxToThePack(PackOfGlasses packOfGlasses) {
		if (isPackFitsInTheBox(box3, packOfGlasses)) {
			return box3;
		} else if (isPackFitsInTheBox(box2, packOfGlasses)) {
			return box2;
		} else if (isPackFitsInTheBox(box1, packOfGlasses)) {
			return box1;
		} else {
			return box4;
		}
	}

	public PackOfGlasses createANewPackWithNewProduct(PackOfGlasses packOfGlasses1, PackOfGlasses packOfGlasses2) {
		PackOfGlasses newPackOfGlasses = new PackOfGlasses();
		newPackOfGlasses.setWidth(packOfGlasses1.getWidth() + packOfGlasses2.getWidth());
		newPackOfGlasses.setLength(Math.max(packOfGlasses1.getLength(), packOfGlasses2.getLength()));
		newPackOfGlasses.setHeigth(Math.max(packOfGlasses1.getHeigth(), packOfGlasses2.getHeigth()));
		newPackOfGlasses.setWeight(packOfGlasses1.getWeight() + packOfGlasses2.getWeight());
		return newPackOfGlasses;
	}

	private boolean isPackFitsInTheBox(Box box, PackOfGlasses packOfGlasses) {
		return (packOfGlasses.getWidth() <= box.getWidth() && packOfGlasses.getLength() <= box.getLength() && (packOfGlasses.getHeigth() + 80) <= box.getHeigth()); // 80mm to the airplus
	}

	public Box[] getBoxesForCheck() {
		Box[] biggestBoxes = { box1 };
		biggestBoxes[0].setHeigth(box1.getHeigth() - 80); // '-80' is wrap thickness in pressed state
		return biggestBoxes;
	}

	public Box[] getAllPossibleBoxes() {
		return new Box[] { box1, box2, box3, box4 };
	}

}
