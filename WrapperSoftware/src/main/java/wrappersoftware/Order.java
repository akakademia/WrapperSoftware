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

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(String.format("%n")).append("Megrendelés tartalma: ").append(String.format("%n"));
		
		if (products.isEmpty()) {
			builder.append("üres.");
		} else {
			for (int i = 0; i < products.size(); i++) {
				if (products.get(i) != null) {
					builder.append(products.get(i)).append(" - ").append(products.get(i).getAmountInOrder());
					builder.append(" db.").append(String.format("%n"));
				}
			}
		}
		
		builder.append(String.format("%n")).append("Kedvezmény mértéke: ").append(discount).append("%");
		
		return builder.toString();
	}

}
