
public class BubbleWrap {

	private String name;
	private int widthInCentimetre;
	private int lengthInCentimetre;
	private double thicknessInCentimetre;
	private int price;

	public BubbleWrap(String name, int widthInCentimetre, int lengthInCentimetre, double thicknessInCentimetre, int price) {
		this.name = name;
		this.widthInCentimetre = widthInCentimetre;
		this.lengthInCentimetre = lengthInCentimetre;
		this.thicknessInCentimetre = thicknessInCentimetre;
		this.price = price;
	}

	public double getThicknessInCentimetre() {
		return thicknessInCentimetre;
	}

	public void setThicknessInCentimetre(double thicknessInCentimetre) {
		this.thicknessInCentimetre = thicknessInCentimetre;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getWidthInCentimetre() {
		return widthInCentimetre;
	}

	public void setWidthInCentimetre(int widthInCentimetre) {
		this.widthInCentimetre = widthInCentimetre;
	}

	public int getLengthInCentimetre() {
		return lengthInCentimetre;
	}

	public void setLengthInCentimetre(int lengthInCentimetre) {
		this.lengthInCentimetre = lengthInCentimetre;
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
		builder.append(widthInCentimetre);
		builder.append(" cm, hosszúsága: ");
		builder.append(lengthInCentimetre);
		builder.append(" cm, vastagsága: ");
		builder.append(thicknessInCentimetre);
		builder.append(" cm, ára: ");
		builder.append(price);
		builder.append(" Ft.");
		return builder.toString();
	}

}
