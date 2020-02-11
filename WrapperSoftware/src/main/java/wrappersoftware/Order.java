package wrappersoftware;

import java.util.ArrayList;

public class Order {

	private ArrayList<GlassyProduct> products;
	private int discount;

	public Order() {
		this.products = new ArrayList<GlassyProduct>();
	}

	public ArrayList<GlassyProduct> getProducts() {
		return products;
	}

	public void setProducts(ArrayList<GlassyProduct> products) {
		this.products = products;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public ArrayList<GlassyProduct> getSortedProductsAbleToWrap(Box[] boxesForCheck) {
		ArrayList<GlassyProduct> productsToWrap = getAbleToWrap(boxesForCheck);
		sortByHeight(productsToWrap);
		return productsToWrap;
	}

	/**
	 * The highest is array[0], the lowest is in the end of array
	 * 
	 * @param productsToSort
	 */
	private void sortByHeight(ArrayList<GlassyProduct> productsToSort) {
		for (int i = 0; i < productsToSort.size(); i++) {
			for (int j = productsToSort.size() - 1; j > 0; j--) {
				if (productsToSort.get(j)
						.getHeight() > productsToSort.get(j - 1)
								.getHeight()) {
					GlassyProduct temporary = productsToSort.get(j - 1);
					productsToSort.add(j + 1, temporary);
					productsToSort.remove(j - 1);
				}
			}
		}
	}

	private ArrayList<GlassyProduct> getAbleToWrap(Box[] boxesForCheck) {
		ArrayList<GlassyProduct> ableToWrap = new ArrayList<GlassyProduct>();
		for (int i = 0; i < products.size(); i++) {
			if (isProductSmallerThenBox(products.get(i), boxesForCheck)) {
				ableToWrap.add(products.get(i));
			}
		}
		return ableToWrap;
	}

	private boolean isProductSmallerThenBox(GlassyProduct product, Box[] boxesForCheck) {
		for (int i = 0; i < boxesForCheck.length; i++) {
			if (product.getWidth() <= boxesForCheck[i].getWidth() && product.getWidth() <= boxesForCheck[i].getLength() && product.getHeight() <= boxesForCheck[i].getHeigth()) {
				return true;
			}
		}
		return false;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(String.format("%n"))
				.append("Megrendelés tartalma: ")
				.append(String.format("%n"));

		if (products.isEmpty()) {
			builder.append("üres.");
		} else {
			for (int i = 0; i < products.size(); i++) {
				if (products.get(i) != null) {
					builder.append(products.get(i))
							.append(" - ")
							.append(products.get(i)
									.getAmountInOrder());
					builder.append(" db.")
							.append(String.format("%n"));
				}
			}
		}

		builder.append(String.format("%n"))
				.append("Kedvezmény mértéke: ")
				.append(discount)
				.append("%");

		return builder.toString();
	}

}
