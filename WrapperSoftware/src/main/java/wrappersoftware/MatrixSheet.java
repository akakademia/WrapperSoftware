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
	private int numberOfNeccesaryMatrixes;

	
	
	public MatrixSheet() {
	}

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

		public int getNumberOfNeccesaryMatrixes() {
		return numberOfNeccesaryMatrixes;
	}

	public void setNumberOfNeccesaryMatrixes(int numberOfNeccesaryMatrixes) {
		this.numberOfNeccesaryMatrixes = numberOfNeccesaryMatrixes;
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
	
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + lengthOfOneMatrix;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + pieceInSheet;
		result = prime * result + price;
		result = prime * result + widthOfOneMatrix;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MatrixSheet other = (MatrixSheet) obj;
		if (lengthOfOneMatrix != other.lengthOfOneMatrix)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (pieceInSheet != other.pieceInSheet)
			return false;
		if (price != other.price)
			return false;
		if (widthOfOneMatrix != other.widthOfOneMatrix)
			return false;
		return true;
	}

	public void addOneMatrix () {
		numberOfNeccesaryMatrixes++;
	}
	
	public int calculatePrice() {
		return calculateNeccesaryMatrixSheet() * price;
	}
	
	public int calculateNeccesaryMatrixSheet() {
		return (numberOfNeccesaryMatrixes+20)/21;
	}

}
