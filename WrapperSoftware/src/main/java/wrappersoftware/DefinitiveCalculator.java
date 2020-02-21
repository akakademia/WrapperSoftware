package wrappersoftware;

public class DefinitiveCalculator {

	private BasicDates basicDates;
	private Box[] boxes;
	private int numberOfBoxes;
	private int numberOfAirplus;
	private MatrixSheet[] matrixs;
	private int matrixSheetCost;
	private int cardboardPrice;

	public DefinitiveCalculator(GlassyProduct[] order, BasicDates basicDates) {
		this.basicDates = basicDates;
		PackWrappingCalculator packWrappingCalculator = new PackWrappingCalculator();
		boxes = packWrappingCalculator.getAllPossibleBoxes();
		matrixs = basicDates.getMatrixSheets();
		Box plannedBox = new Box();
		PackOfGlasses firstPack = new PackOfGlasses();
		PackOfGlasses secondPack;
		int index = 0;
		cardboardPrice = 0;
		int plannedCardboardPrice = 0;
		do {
			secondPack = new PackOfGlasses(order[index].getWidth(), order[index].getWidth(), order[index].getHeight(), order[index].getWeight());
			firstPack = packWrappingCalculator.createANewPackWithNewProduct(firstPack, secondPack);
			int pressedWrapThickness = basicDates.getBubbleWrap()
					.getThickness()
					- basicDates.getBubbleWrap()
							.getRetraction();
			Box boxToPack = packWrappingCalculator.toChooseBoxToThePack(firstPack, pressedWrapThickness);
			if (!boxToPack.equals(boxes[3])) {
				if (boxToPack.equals(boxes[0])) {
					plannedBox = boxes[0];
				} else if (boxToPack.equals(boxes[1])) {
					plannedBox = boxes[1];
				} else if (boxToPack.equals(boxes[2])) {
					plannedBox = boxes[2];
				}
				plannedCardboardPrice = packWrappingCalculator.calculateCardboardPrice(firstPack);
				index++;
			}
			if (boxToPack.equals(boxes[3]) || index == order.length) {
				if (plannedBox.equals(boxes[0])) {
					boxes[0].addOneBox();
				} else if (plannedBox.equals(boxes[1])) {
					boxes[1].addOneBox();
				} else if (plannedBox.equals(boxes[2])) {
					boxes[2].addOneBox();
				}
				cardboardPrice += plannedCardboardPrice;
				firstPack.toEmptyPackOfGlasses();
			}
		} while (index < order.length);

		numberOfBoxes = boxes[0].getNumberOfNeccesaryBoxes() + boxes[1].getNumberOfNeccesaryBoxes() + boxes[2].getNumberOfNeccesaryBoxes();
		numberOfAirplus = (numberOfBoxes + 1) / 2;

		matrixs[1].setNumberOfNeccesaryMatrixes(boxes[2].getNumberOfNeccesaryBoxes());
		matrixs[2].setNumberOfNeccesaryMatrixes(boxes[0].getNumberOfNeccesaryBoxes() + boxes[1].getNumberOfNeccesaryBoxes());

		matrixSheetCost = matrixs[1].calculatePrice() + matrixs[2].calculatePrice();
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
		return matrixSheetCost;
	}

	public BasicDates getBasicDates() {
		return basicDates;
	}

}
