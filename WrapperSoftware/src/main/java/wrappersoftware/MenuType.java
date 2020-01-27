package wrappersoftware;

public enum MenuType {
	ENTER("Belépési menü"),

	ADMIN("Admin menü"), CATEGORIES_FOR_DATE_CHANGE("Adatmódosítási menü"), PRODUCTS_LIST_FOR_DATE_CHANGE("Terméklista menü"),

	ORDER("Megrendelési menü"), PRODUCTS_LIST_TO_ADD("Termékek hozzáadási menüje"), PRODUCTS_LIST_TO_REMOVE("Termékek törlési menüje"),

	SAVE_FILE_RESTART_LOG_OUT("Kilépési menü");

	private String typeHUN;

	private MenuType(String typeHUN) {
		this.typeHUN = typeHUN;
	}

	public String[] getBasicFields(MenuType menuType) {
		switch (menuType) {
		case ENTER:
			return new String[] { "Felhasználó", "Adminisztrátor" };
		case ADMIN:
			return new String[] { "Tovább számításhoz", "Adatmódosítás" };
		case CATEGORIES_FOR_DATE_CHANGE:
			return new String[] { "Vissza az adatmódosítási menübe" };
		case PRODUCTS_LIST_FOR_DATE_CHANGE:
			return new String[] { "Vissza az adatmódosítási menübe" };
		case ORDER:
			return new String[] { "Termék hozzáadása megrendeléshez", "Termék törlése megrendelésről", "Kedvezmény %", "Számítás" };
		case PRODUCTS_LIST_TO_ADD:
			return new String[] { "Vissza a megrendelési menübe" };
		case PRODUCTS_LIST_TO_REMOVE:
			return new String[] { "Vissza a megrendelési menübe" };
		default:
			return new String[] { "Fenti árajánlat mentése", "Új megrendelés", "Kilépés" };
		}
	}

	public String getTypeHUN() {
		return typeHUN;
	}

}
