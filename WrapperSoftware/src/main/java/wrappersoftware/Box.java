package wrappersoftware;

public class Box {

	private String name;
	private int width;
	private int length;
	private int heigth;
	private int numberOfNeccesaryBoxes;

	public Box() {
	}

	public Box(String name, int width, int length, int heigth) {
		this.name = name;
		this.width = width;
		this.length = length;
		this.heigth = heigth;
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

	public int getHeigth() {
		return heigth;
	}

	public void setHeigth(int heigth) {
		this.heigth = heigth;
	}

	public int getNumberOfNeccesaryBoxes() {
		return numberOfNeccesaryBoxes;
	}
// ezt is jó lenne kivenni, de exlude-olni kellene az open pojoból!
	public void setNumberOfNeccesaryBoxes(int numberOfNeccesaryBoxes) {
		this.numberOfNeccesaryBoxes = numberOfNeccesaryBoxes;
	}

	@Override
	public String toString() {
		return "Doboz [megnevezése=" + name + ", szélessége=" + width + ", hosszúsága=" + length + ", magassága=" + heigth + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Box other = (Box) obj;
		if (heigth != other.heigth)
			return false;
		if (length != other.length)
			return false;
		if (width != other.width)
			return false;
		return true;
	}

	public void addOneBox() {
		this.numberOfNeccesaryBoxes++;
	}
}
