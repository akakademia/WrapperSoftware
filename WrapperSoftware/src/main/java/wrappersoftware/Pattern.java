package wrappersoftware;

public class Pattern {

	private int width;
	private int length;

	public Pattern() {
	}

	public Pattern(int width, int length) {
		this.width = width;
		this.length = length;
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

	public int calculateWidthOfThePaperFromBoxSize(int widthOfTheBox, int heigthOfTheBox) {
		return 2 * heigthOfTheBox + widthOfTheBox;
	}

	public int calculateLengthOfThePaperFromBoxSize(int lengthOfTheBox, int heigthOfTheBox) {
		return 2 * heigthOfTheBox + 2 * lengthOfTheBox + 5;
	}
}
