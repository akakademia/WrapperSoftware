package wrappersoftware;

public class BubbleWrap {

	/**
	 * @width is in millimeter
	 * @length is in millimeter
	 * @thickness is in millimeter
	 * @retraction is in millimeter
	 */

	private String name;
	private int width;
	private int length;
	private int thickness;
	private int retraction;
	private int price;

	public BubbleWrap(String name, int width, int length, int thickness, int retraction, int price) {
		this.name = name;
		this.width = width;
		this.length = length;
		this.thickness = thickness;
		this.retraction = retraction;
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

	public int getThickness() {
		return thickness;
	}

	public void setThickness(int thickness) {
		this.thickness = thickness;
	}

	public int getRetraction() {
		return retraction;
	}

	public void setRetraction(int retraction) {
		this.retraction = retraction;
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
		builder.append("Térkitöltő: ");
		builder.append(name);
		builder.append(", szélessége: ");
		builder.append(width);
		builder.append(" mm, hosszúsága: ");
		builder.append(length);
		builder.append(" mm, vastagsága: ");
		builder.append(thickness);
		builder.append(" mm, zsugorodás mértéke: ");
		builder.append(retraction);
		builder.append(" mm, ára: ");
		builder.append(price);
		builder.append(" Ft.");
		return builder.toString();
	}

}
