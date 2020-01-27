
public class MatrixSheet {

	private String name;
	private double widthOfOneMatrixInCentimetre;
	private double lengthOfOneMatrixInCentimetre;
	private int piece;
	private int price;

	public MatrixSheet(String name, double widthOfOneMatrixInCentimetre, double lengthOfOneMatrixInCentimetre, int piece, int price) {
		this.name = name;
		this.widthOfOneMatrixInCentimetre = widthOfOneMatrixInCentimetre;
		this.lengthOfOneMatrixInCentimetre = lengthOfOneMatrixInCentimetre;
		this.piece = piece;
		this.price = price;
	}

	public double getWidthOfOneMatrix() {
		return widthOfOneMatrixInCentimetre;
	}

	public void setWidthOfOneMatrix(int widthOfOneMatrix) {
		this.widthOfOneMatrixInCentimetre = widthOfOneMatrix;
	}

	public double getLengthOfOneMatrix() {
		return lengthOfOneMatrixInCentimetre;
	}

	public void setLengthOfOneMatrix(int lengthOfOneMatrix) {
		this.lengthOfOneMatrixInCentimetre = lengthOfOneMatrix;
	}

	public int getPiece() {
		return piece;
	}

	public void setPiece(int piece) {
		this.piece = piece;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
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
		builder.append("Matrica: ");
		builder.append(name);
		builder.append(", szélessége: ");
		builder.append(widthOfOneMatrixInCentimetre);
		builder.append(" cm, hosszúsága: ");
		builder.append(lengthOfOneMatrixInCentimetre);
		builder.append(" cm, ");
		builder.append(piece);
		builder.append(" darab/1 íven");
		builder.append(", ára: ");
		builder.append(price);
		builder.append(" Ft.");
		return builder.toString();
	}

}
