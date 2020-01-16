import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TestMenuType {

	@Test
	@DisplayName("MenuType enum tartalmának ellenőrzése")
	void testMenuTypeEnumContent() {

		MenuType[] menuTypes = MenuType.values();
		ArrayList<String> stringMenuType = new ArrayList<String>();
		for (MenuType headTitle : menuTypes) {
			stringMenuType.add(headTitle.toString());
		}

		assertTrue(stringMenuType.contains("ENTER"), "ENTER van benne?");
		assertTrue(stringMenuType.contains("ADMIN"), "ADMIN van benne?");
		assertTrue(stringMenuType.contains("CATEGORIS_FOR_DATE_CHANGE"), "CATEGORIS_FOR_DATE_CHANGE van benne?");
		assertTrue(stringMenuType.contains("PRODUCTS_LIST_FOR_DATE_CHANGE"), "PRODUCTS_LIST_FOR_DATE_CHANGE van benne?");
		assertTrue(stringMenuType.contains("FIELDS_FOR_DATE_CHANGE"), "FIELDS_FOR_DATE_CHANGE van benne?");
		assertTrue(stringMenuType.contains("ORDER"), "ORDER van benne?");
		assertTrue(stringMenuType.contains("PRODUCTS_LIST_TO_ADD"), "PRODUCTS_LIST_TO_ADD van benne?");
		assertTrue(stringMenuType.contains("PRODUCTS_LIST_TO_REMOVE"), "PRODUCTS_LIST_TO_REMOVE van benne?");
	}
	
}
