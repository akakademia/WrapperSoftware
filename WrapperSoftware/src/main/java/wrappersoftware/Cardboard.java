package wrappersoftware;

public class Cardboard {

	/**
	 * @width is in millimeter
	 * @length is in millimeter
	 * @thickness is in millimeter
	 * @carryingCapacity is in gram
	 * 
	 */

	private String name;
	private int width;
	private int length;
	private double thickness;
	private int carryingCapacity;
	private int price;

	public Cardboard(String name, int width, int length, double thickness, int carryingCapacity, int price) {
		this.name = name;
		this.width = width;
		this.length = length;
		this.thickness = thickness;
		this.carryingCapacity = carryingCapacity;
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

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public double getThickness() {
		return thickness;
	}

	public void setThickness(double thickness) {
		this.thickness = thickness;
	}

	public int getCarryingCapacity() {
		return carryingCapacity;
	}

	public void setCarryingCapacity(int carryingCapacity) {
		this.carryingCapacity = carryingCapacity;
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
		builder.append("Dekorkarton: ");
		builder.append(name);
		builder.append(", szélessége: ");
		builder.append(width);
		builder.append(" mm, hosszúsága: ");
		builder.append(length);
		builder.append(" mm, vastagsága: ");
		builder.append(thickness);
		builder.append(" mm, teherbírása: ");
		builder.append(carryingCapacity);
		builder.append(" g, ára: ");
		builder.append(price);
		builder.append(" Ft.");
		return builder.toString();
	}

}
