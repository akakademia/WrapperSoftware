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
	
	public void printOrder() {
		StringBuilder builder = new StringBuilder();
		builder.append("Megrendelés tartalma: ");
		builder.append(String.format("%n"));
		if (products.isEmpty()) {
			builder.append("üres.");
		} else {
			for (int i = 0; i < products.size(); i++) {
				if (products.get(i) != null) {
					builder.append(products.get(i)
							.toString());
					builder.append(" - ");
					builder.append(products.get(i)
							.getAmountInOrder());
					builder.append("db.");
					builder.append(String.format("%n"));
				}
			}
		}
		builder.append(String.format("%n"));
		builder.append("Kedvezmény mértéke: ");
		builder.append(discount);
		builder.append("%");
		
		System.out.println(builder);
	}

}
