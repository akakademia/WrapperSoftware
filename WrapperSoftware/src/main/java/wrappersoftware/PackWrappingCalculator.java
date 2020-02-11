package wrappersoftware;

public class PackWrappingCalculator {

	private Box box1 = new Box(160, 155, 300); // is the highest and the widest
	private Box box2 = new Box(190, 120, 250);
	private Box box3 = new Box(250, 60, 180);
	private Box box4 = new Box(0, 0, 0);
	private PackOfGlasses packOfGlasses;

	public PackWrappingCalculator() {
	}

	public PackWrappingCalculator(PackOfGlasses packOfGlasses) {
		this.packOfGlasses = packOfGlasses;
	}

	public int calculateWrappingFee() { // need to add the sticker and airplus fee
		return calculateCardboardPrice();
	}

	private int calculateCardboardPrice() {
		if (packOfGlasses.getWeight() <= 5000) {
			return 20;
		} else if (packOfGlasses.getWeight() <= 10000) {
			return 30;
		} else {
			return 40;
		}
	}

	private Box toChooseBoxToThePack() { // it's neccesary to the stickers
		if (isPackFitsInTheBox(box1)) {
			return box1;
		} else if (isPackFitsInTheBox(box2)) {
			return box2;
		} else if (isPackFitsInTheBox(box3)) {
			return box3;
		} else {
			return box4;
		}
	}

	private boolean isPackFitsInTheBox(Box box) {
		return (packOfGlasses.getWidth() <= box.getWidth() && packOfGlasses.getLength() <= box.getLength() && (packOfGlasses.getHeigth() + 80) <= box.getHeigth()); // 80mm to the airplus
	}

	public Box[] getBoxesForCheck() {
		Box[] biggestBoxes = { box1 };
		biggestBoxes[0].setHeigth(box1.getHeigth() - 80); // '-80' is wrap thickness in pressed state
		return biggestBoxes;
	}

}
