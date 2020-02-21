package wrappersoftware;

import java.util.ArrayList;

public class Results {

	private BasicDates basicDates;
	private ArrayList<GlassyProduct> productsFitInBox;
	private ArrayList<GlassyProduct> productsNotPackable;
	private ArrayList<Box> needfulBoxes = new ArrayList<>();
	private int needfulCardboards;
	private int cardboardsTotalCost;
	private int needfulAirplus;
	private int airplusTotalCost;
	private MatrixSheet[] needfulMatrixSheets;
	private int matrixSheetsTotalCost;
	private int discount;
	private int sumCostWithDiscont;

	public Results(Order order, BasicDates basicDates) {
		this.basicDates = basicDates;
		setProductsFitInBox(order);
		setProductsNotPackable(order);

		GlassyProduct productspackable[] = setArrayFromList();

		DefinitiveCalculator calculator = new DefinitiveCalculator(productspackable, basicDates);
		setNeedfulBoxes(calculator.getBoxes());
		needfulCardboards = calculator.getNumberOfBoxes();
		cardboardsTotalCost = calculator.getCardboardPrice();
		needfulAirplus = calculator.getNumberOfAirplus();
		airplusTotalCost = needfulAirplus * basicDates.getBubbleWrap()
				.getPrice();
		needfulMatrixSheets = calculator.getMatrixs();
		matrixSheetsTotalCost = calculator.getMatrixCost();

		discount = order.getDiscount();
		sumCostWithDiscont = (cardboardsTotalCost + airplusTotalCost + matrixSheetsTotalCost) * (100 - order.getDiscount()) / 100;
	}

	public BasicDates getBasicDates() {
		return basicDates;
	}

	public ArrayList<GlassyProduct> getProductsFitInBox() {
		return productsFitInBox;
	}

	public ArrayList<GlassyProduct> getProductsNotPackable() {
		return productsNotPackable;
	}

	public ArrayList<Box> getNeedfulBoxes() {
		return needfulBoxes;
	}

	public int getNeedfulCardboards() {
		return needfulCardboards;
	}

	public int getCardboardsTotalCost() {
		return cardboardsTotalCost;
	}

	public int getNeedfulAirplus() {
		return needfulAirplus;
	}

	public int getAirplusTotalCost() {
		return airplusTotalCost;
	}

	public MatrixSheet[] getNeedfulMatrixSheets() {
		return needfulMatrixSheets;
	}

	public int getMatrixSheetsTotalCost() {
		return matrixSheetsTotalCost;
	}

	public int getDiscount() {
		return discount;
	}

	public int getSumCostWithDiscont() {
		return sumCostWithDiscont;
	}

	private void setNeedfulBoxes(Box[] boxes) {
		for (int i = 0; i < boxes.length; i++) {
			if (boxes[i].getNumberOfNeccesaryBoxes() > 0) {
				needfulBoxes.add(boxes[i]);
			}
		}
	}

	private GlassyProduct[] setArrayFromList() {
		int length = lengthCalculate();
		GlassyProduct[] array = new GlassyProduct[length];
		int index = 0;
		for (int i = 0; i < productsFitInBox.size(); i++) {
			for (int j = 0; j < productsFitInBox.get(i)
					.getAmountInOrder(); j++) {
				array[index++] = productsFitInBox.get(i);
			}
		}
		return array;
	}

	private int lengthCalculate() {
		int length = 0;
		for (int i = 0; i < productsFitInBox.size(); i++) {
			length += productsFitInBox.get(i)
					.getAmountInOrder();
		}
		return length;
	}

	private void setProductsFitInBox(Order order) {
		int pressedWrapThickness = basicDates.getBubbleWrap()
				.getThickness()
				- basicDates.getBubbleWrap()
						.getRetraction();
		Box[] boxesForCheck = new PackWrappingCalculator().getBoxesForCheck(pressedWrapThickness);
		productsFitInBox = order.getSortedProductsAbleToWrap(boxesForCheck);

	}

	private void setProductsNotPackable(Order order) {
		int pressedWrapThickness = basicDates.getBubbleWrap()
				.getThickness()
				- basicDates.getBubbleWrap()
						.getRetraction();
		Box[] boxesForCheck = new PackWrappingCalculator().getBoxesForCheck(pressedWrapThickness);
		productsNotPackable = order.getProductsDisableToPack(boxesForCheck);
	}

	public void printProductsAbleToPack() {
		if (productsFitInBox.size() > 0) {
			System.out.println("Csomagolásra alkalmas termékek:");
			for (GlassyProduct product : productsFitInBox) {
				System.out.println(product + " - " + product.getAmountInOrder() + " db.");
			}
		}
	}

	public void printProductsNotPackable() {
		if (productsNotPackable.size() > 0) {
			System.out.println("Csomagolásra nem alkalmas termékek:");
			for (GlassyProduct product : productsNotPackable) {
				System.out.println(product + " - " + product.getAmountInOrder() + " db.");
			}
		}
	}

}
