package wrappersoftware;

public class Cardboard {

	private String name;
	private int width;
	private int length;
	private double thickness;
	private double carryingCapacity;
	private int price;

	public Cardboard() {
	}

	public Cardboard(String name, int width, int length, double thickness, double carryingCapacity, int price) {
		this.setName(name);
		this.width = width;
		this.length = length;
		this.thickness = thickness;
		this.carryingCapacity = carryingCapacity;
		this.price = price;
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

	public void setThickness(int thickness) {
		this.thickness = thickness;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public double getCarryingCapacity() {
		return carryingCapacity;
	}

	public void setCarryingCapacity(int carryingCapacity) {
		this.carryingCapacity = carryingCapacity;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Dekorkarton: ");
		builder.append(name);
		builder.append(", szélessége: ");
		builder.append(width);
		builder.append(" cm, hosszúsága: ");
		builder.append(length);
		builder.append(" cm, vastagsága: ");
		builder.append(thickness);
		builder.append(" cm, teherbírása: ");
		builder.append(carryingCapacity);
		builder.append(" kg, ára: ");
		builder.append(price);
		builder.append(" Ft.");
		return builder.toString();
	}

}
