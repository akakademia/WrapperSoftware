
public class Menu {

	MenuType menuType;
	String[] fields;

	public Menu() {
		menuType = MenuType.ENTER;
		fields = menuType.getBasicFields(MenuType.ENTER);
	}

	public Menu(String[] fields) {
		this();
		this.fields = merseArrays(this.fields, fields);
	}

	private String[] merseArrays(String[] arrayFirst, String[] arraySecond) {
		String[] mersedArray;
		if (arraySecond == null || (arraySecond.length == 1 && arraySecond[0].equals(""))) {
			mersedArray = arrayFirst;
			return mersedArray;
		} else {
			mersedArray = new String[arrayFirst.length + arraySecond.length];
		}
		for (int i = 0; i < arrayFirst.length; i++) {
			mersedArray[i] = arrayFirst[i];
		}
		for (int i = 0; i < arraySecond.length; i++) {
			mersedArray[arrayFirst.length + i] = arraySecond[i];
		}
		return mersedArray;
	}

	public void setMenuTypeAndFields(MenuType menuType, String[] fields) {
		this.menuType = menuType;
		this.fields = this.menuType.getBasicFields(MenuType.values()[this.menuType.ordinal()]);
		this.fields = merseArrays(this.fields, fields);
	}

	public void setMenuTypeAndFields(MenuType menuType) {
		this.menuType = menuType;
		this.fields = this.menuType.getBasicFields(MenuType.values()[this.menuType.ordinal()]);

	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(menuType.getTypeHUN())
				.append(":\n");
		for (int i = 0; i < fields.length; i++) {
			builder.append(String.format("%2d. %s%n", i, fields[i]));
		}
		return builder.toString();
	}

}
