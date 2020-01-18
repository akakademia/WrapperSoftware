
public class Cardboard {

	int width;
	int length;
	int thickness;
	int price;

	public Cardboard() {
	}

	public Cardboard(int width, int length, int thickness, int price) {
		this.width = width;
		this.length = length;
		this.thickness = thickness;
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

	public int getThickness() {
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

}
