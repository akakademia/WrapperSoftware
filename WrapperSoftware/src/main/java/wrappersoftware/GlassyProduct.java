package wrappersoftware;

public class GlassyProduct {

	private String name;
	private double widthInCentimetre;
	private double heightInCentimetre;
	private double weightInKilogram;
	private double volumeInCubicCentimetre;
	private boolean isInBox;
	private int amountInOrder;

	public GlassyProduct(String name, double widthInCentimetre, double heightInCentimetre, double weightInKilogram, double volumeInCubicCentimetre) {
		this.name = name;
		this.widthInCentimetre = widthInCentimetre;
		this.heightInCentimetre = heightInCentimetre;
		this.weightInKilogram = weightInKilogram;
		this.volumeInCubicCentimetre = volumeInCubicCentimetre;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getWidthInCentimetre() {
		return widthInCentimetre;
	}

	public void setWidthInCentimetre(double widthInCentimetre) {
		this.widthInCentimetre = widthInCentimetre;
	}

	public double getHeightInCentimetre() {
		return heightInCentimetre;
	}

	public void setHeightInCentimetre(double heightInCentimetre) {
		this.heightInCentimetre = heightInCentimetre;
	}

	public double getWeightInKilogram() {
		return weightInKilogram;
	}

	public void setWeightInKilogram(double weightInKilogram) {
		this.weightInKilogram = weightInKilogram;
	}

	public double getVolumeInCubicCentimetre() {
		return volumeInCubicCentimetre;
	}

	public void setVolumeInCubicCentimetre(double volumeInCubicCentimetre) {
		this.volumeInCubicCentimetre = volumeInCubicCentimetre;
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

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Üveges termék: ");
		builder.append(name);
		builder.append(", szélessége: ");
		builder.append(widthInCentimetre);
		builder.append(" cm, magassága: ");
		builder.append(heightInCentimetre);
		builder.append(" cm, súlya: ");
		builder.append(weightInKilogram);
		builder.append(" kg, űrtartalma: ");
		builder.append(volumeInCubicCentimetre);
		builder.append(" ml.");
		return builder.toString();
	}

}
