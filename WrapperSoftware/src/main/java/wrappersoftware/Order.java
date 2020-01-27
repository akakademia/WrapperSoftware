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
		StringBuilder builder=new StringBuilder();
		for (int i = 0; i < order.size(); i++) {
			builder.append(order.get(i).toString());
			builder.append(" - ");
			builder.append(order.get(i).getAmountInOrder());
			builder.append(" db.");
		}
	}
	
}
