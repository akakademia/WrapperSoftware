package wrappersoftware;

public class MatrixSheet {

	/**
	 * @widthOfOneMatrix is in millimeter
	 * @lengthOfOneMatrix is in millimeter
	 */

	private String name;
	private int widthOfOneMatrix;
	private int lengthOfOneMatrix;
	private int pieceInSheet;
	private int price;

	public MatrixSheet(String name, int widthOfOneMatrix, int lengthOfOneMatrix, int pieceInSheet, int price) {
		this.name = name;
		this.widthOfOneMatrix = widthOfOneMatrix;
		this.lengthOfOneMatrix = lengthOfOneMatrix;
		this.pieceInSheet = pieceInSheet;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getWidthOfOneMatrix() {
		return widthOfOneMatrix;
	}

	public void setWidthOfOneMatrix(int widthOfOneMatrix) {
		this.widthOfOneMatrix = widthOfOneMatrix;
	}

	public int getLengthOfOneMatrix() {
		return lengthOfOneMatrix;
	}

	public void setLengthOfOneMatrix(int lengthOfOneMatrix) {
		this.lengthOfOneMatrix = lengthOfOneMatrix;
	}

	public int getPieceInSheet() {
		return pieceInSheet;
	}

	public void setPieceInSheet(int pieceInSheet) {
		this.pieceInSheet = pieceInSheet;
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
		builder.append("Matrica: ");
		builder.append(name);
		builder.append(", szélessége: ");
		builder.append(widthOfOneMatrix);
		builder.append(" mm, hosszúsága: ");
		builder.append(lengthOfOneMatrix);
		builder.append(" mm, ");
		builder.append(pieceInSheet);
		builder.append(" darab/1 íven");
		builder.append(", ára: ");
		builder.append(price);
		builder.append(" Ft.");
		return builder.toString();
	}

}
