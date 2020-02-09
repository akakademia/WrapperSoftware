package wrappersoftware;

public class GlassyProduct {

	/**
	 * @width is in millimeter
	 * @height is in millimeter
	 * @weight is in gram
	 * @volume is in milliliter
	 */

	private String name;
	private int width;
	private int height;
	private int weight;
	private int volume;
	private boolean isInBox;
	private int amountInOrder;
	private int price;

	public GlassyProduct(String name, int width, int height, int weight, int volume, int price) {
		this.name = name;
		this.width = width;
		this.height = height;
		this.weight = weight;
		this.volume = volume;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}

	public boolean isInBox() {
		return isInBox;
	}

	public void setInBox(boolean isInBox) {
		this.isInBox = isInBox;
	}

	public int getAmountInOrder() {
		return amountInOrder;
	}

	public void setAmountInOrder(int amountInOrder) {
		this.amountInOrder = amountInOrder;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Üveges termék: ");
		builder.append(name);
		builder.append(", szélessége: ");
		builder.append(width);
		builder.append(" mm, magassága: ");
		builder.append(height);
		builder.append(" mm, súlya: ");
		builder.append(weight);
		builder.append(" g, űrtartalma: ");
		builder.append(volume);
		builder.append(" ml, ára: ");
		builder.append(price);
		builder.append(" Ft.");
		return builder.toString();
	}

}
