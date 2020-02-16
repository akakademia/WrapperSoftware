package wrappersoftware;

import java.util.ArrayList;

public class Results {

	private ArrayList<GlassyProduct> productsFitInBox;
	private ArrayList<GlassyProduct> productsNotPackable;
	private int needfulCardboard;
	private int needfulCardboardCost;
	private int needfulAirplus;
	private int needfulAirplusCost;
	private MatrixSheet[] needfulMatrixSheet;
	private int needfulMatrixCost;
	private int sumCostWithDiscont;

	public Results(Order order) {
		setProductsFitInBox(order);
		setProductsNotPackable(order);

		GlassyProduct productspackable[] = setArrayFromList();

		VDTestClass2 vdTestClass2 = new VDTestClass2(productspackable);
		needfulCardboard = vdTestClass2.getNumberOfBoxes();
		needfulCardboardCost = vdTestClass2.getCardboardPrice();
		needfulAirplus = vdTestClass2.getNumberOfAirplus();
		needfulAirplusCost = needfulAirplus * 250;
		needfulMatrixSheet = vdTestClass2.getMatrixs();
		needfulMatrixCost = vdTestClass2.getMatrixCost();

		sumCostWithDiscont = (needfulCardboardCost + needfulAirplusCost + needfulMatrixCost) * (100 - order.getDiscount()) / 100;
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

	public ArrayList<GlassyProduct> getProductsFitInBox() {
		return productsFitInBox;
	}

	private void setProductsFitInBox(Order order) {
		Box[] boxesForCheck = new PackWrappingCalculator().getBoxesForCheck();
		productsFitInBox = order.getSortedProductsAbleToWrap(boxesForCheck);

	}

	public ArrayList<GlassyProduct> getProductsNotPackable() {
		return productsNotPackable;
	}

	private void setProductsNotPackable(Order order) {
		Box[] boxesForCheck = new PackWrappingCalculator().getBoxesForCheck();
		productsNotPackable = order.getProductsDisableToPack(boxesForCheck);
	}

	public int getNeedfulCardboard() {
		return needfulCardboard;
	}

	public int getNeedfulCardboardCost() {
		return needfulCardboardCost;
	}

	public int getNeedfulAirplus() {
		return needfulAirplus;
	}

	public int getNeedfulAirplusCost() {
		return needfulAirplusCost;
	}

	public MatrixSheet[] getNeedfulMatrixSheet() {
		return needfulMatrixSheet;
	}

	public int getNeedfulMatrixCost() {
		return needfulMatrixCost;
	}

	public int getSumCostWithDiscont() {
		return sumCostWithDiscont;
	}

	public void printProductsAbleToPack() {
		if (productsFitInBox.size() > 0) {
			System.out.println("Csomagolásra alkalmas termékek:");
			for (GlassyProduct product : productsFitInBox) {
				System.out.println(product);
			}
		}
	}

	public void printProductsNotPackable() {
		if (productsNotPackable.size() > 0) {
			System.out.println("Csomagolásra nem alkalmas termékek:");
			for (GlassyProduct product : productsNotPackable) {
				System.out.println(product);
			}
		}
	}

}
