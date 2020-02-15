package wrappersoftware;

public class PackOfGlasses {

	private int width;
	private int length;
	private int heigth;
	private int weight;

	
	
	public PackOfGlasses() {
	}


	public PackOfGlasses(int width, int length, int heigth, int weight) {
		this.width = width;
		this.length = length;
		this.heigth = heigth;
		this.weight = weight;

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

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}


	@Override
	public String toString() {
		return "PackOfGlasses [width=" + width + ", length=" + length + ", heigth=" + heigth + ", weight=" + weight
				+ "]";
	}

	public void toEmptyPackOfGlasses () {
		width =0;
		length=0;
		heigth=0;
		weight=0;
	}



}
