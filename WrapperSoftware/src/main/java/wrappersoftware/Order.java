package wrappersoftware;

import java.util.ArrayList;

public class Order {

	private ArrayList<GlassyProduct> order;

	public Order() {
		this.order = new ArrayList<GlassyProduct>();
	}

	public ArrayList<GlassyProduct> getOrder() {
		return order;
	}

	public void setOrder(ArrayList<GlassyProduct> order) {
		this.order = order;
	}

	public void printProducts() {
		StringBuilder builder = new StringBuilder();
		builder.append("Megrendelés tartalma: ");
		builder.append(String.format("%n"));
		for (int i = 0; i < order.size(); i++) {
			if (order.isEmpty()) {
				builder.append("üres.");
				break;
			}
			if (order.get(i) != null) {
				builder.append(order.get(i)
						.toString());
				builder.append(" - ");
				builder.append(order.get(i)
						.getAmountInOrder());
				builder.append("db.");
				builder.append(String.format("%n"));
			}
		}
	}
}
