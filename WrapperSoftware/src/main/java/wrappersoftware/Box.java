package wrappersoftware;

public class Box {

	private int width;
	private int length;
	private int heigth;

	public Box() {
	}

	public Box(int width, int length, int heigth) {
		this.width = width;
		this.length = length;
		this.heigth = heigth;
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

	public int getHeigth() {
		return heigth;
	}

	public void setHeigth(int heigth) {
		this.heigth = heigth;
	}

	public int calculateWidthOfThePaperFromBoxSize(int width, int length) {
		return 2 * (width + length) + 50; // 50mm to the edge for glue 
	}

	public int calculateLengthOfThePaperFromBoxSize(int length, int heigth) {
		return length + heigth; 
	}
}
