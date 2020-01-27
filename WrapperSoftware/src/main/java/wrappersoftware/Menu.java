package wrappersoftware;

public class Menu {

	MenuType menuType;
	private String[] fields;
	private int numberOfBasicFields;

	public Menu(MenuType menuType) {
		this.menuType = menuType;
		fields = menuType.getBasicFields(menuType);
		numberOfBasicFields = fields.length;
	}

	public MenuType getMenuType() {
		return menuType;
	}

	public String[] getFields() {
		return fields;
	}

	public int getNumberOfBasicFields() {
		return numberOfBasicFields;
	}

	public void setAdditonalFields(String[] fieldsToAdd) {
		fields = uniteArrays(fields, fieldsToAdd);
	}

	private String[] uniteArrays(String[] arrayFirst, String[] arraySecond) {
		String[] unitedArray;
		if (arraySecond == null || (arraySecond.length == 1 && arraySecond[0].equals(""))) {
			unitedArray = arrayFirst;
			return unitedArray;
		} else {
			unitedArray = new String[arrayFirst.length + arraySecond.length];
		}
		for (int i = 0; i < arrayFirst.length; i++) {
			unitedArray[i] = arrayFirst[i];
		}
		for (int i = 0; i < arraySecond.length; i++) {
			unitedArray[arrayFirst.length + i] = arraySecond[i];
		}
		return unitedArray;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(menuType.getTypeHUN())
				.append(String.format(":%n"));
		for (int i = 0; i < fields.length; i++) {
			builder.append(String.format("%2d. %s%n", i, fields[i]));
		}
		return builder.toString();
	}

}
