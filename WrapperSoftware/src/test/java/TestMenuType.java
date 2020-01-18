import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TestMenuType {
	MenuType m;

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
		assertTrue(stringMenuType.contains("CATEGORIES_FOR_DATE_CHANGE"), "CATEGORIES_FOR_DATE_CHANGE van benne?");
		assertTrue(stringMenuType.contains("PRODUCTS_LIST_FOR_DATE_CHANGE"), "PRODUCTS_LIST_FOR_DATE_CHANGE van benne?");
		assertTrue(stringMenuType.contains("FIELDS_FOR_DATE_CHANGE"), "FIELDS_FOR_DATE_CHANGE van benne?");
		assertTrue(stringMenuType.contains("ORDER"), "ORDER van benne?");
		assertTrue(stringMenuType.contains("PRODUCTS_LIST_TO_ADD"), "PRODUCTS_LIST_TO_ADD van benne?");
		assertTrue(stringMenuType.contains("PRODUCTS_LIST_TO_REMOVE"), "PRODUCTS_LIST_TO_REMOVE van benne?");
	}
	
	
	@Test
	@DisplayName("getBasicFieldsWithENTER")
	void testGetBasicFieldsWithENTER() {
		m = MenuType.ENTER;
		assertTrue(m.getBasicFields(m) != null);
	}
	
	@Test
	@DisplayName("getBasicFieldsWithCATEGORIES_FOR_DATE_CHANGE")
	void testGetBasicFieldsWithCATEGORIES_FOR_DATE_CHANGE() {
		m = MenuType.CATEGORIES_FOR_DATE_CHANGE;
		assertTrue(m.getBasicFields(m) != null);
	}
	
	@Test
	@DisplayName("getBasicFieldsWithPRODUCTS_LIST_FOR_DATE_CHANGE")
	void testGetBasicFieldsWithPRODUCTS_LIST_FOR_DATE_CHANGE() {
		m = MenuType.PRODUCTS_LIST_FOR_DATE_CHANGE;
		assertTrue(m.getBasicFields(m) != null);
	}
	
	@Test
	@DisplayName("getBasicFieldsWithFIELDS_FOR_DATE_CHANGE")
	void testGetBasicFieldsWithFIELDS_FOR_DATE_CHANGE() {
		m = MenuType.FIELDS_FOR_DATE_CHANGE;
		assertTrue(m.getBasicFields(m) != null);
	}
	
	@Test
	@DisplayName("getBasicFieldsWithORDER")
	void testGetBasicFieldsWithORDER() {
		m = MenuType.ORDER;
		assertTrue(m.getBasicFields(m) != null);
	}
	
	@Test
	@DisplayName("getBasicFieldsWithPRODUCTS_LIST_TO_ADD")
	void testGetBasicFieldsWithPRODUCTS_LIST_TO_ADD() {
		m = MenuType.PRODUCTS_LIST_TO_ADD;
		assertTrue(m.getBasicFields(m) != null);
	}
	
	@Test
	@DisplayName("getBasicFieldsWithPRODUCTS_LIST_TO_REMOVE")
	void testGetBasicFieldsWithPRODUCTS_LIST_TO_REMOVE() {
		m = MenuType.PRODUCTS_LIST_TO_REMOVE;
		assertTrue(m.getBasicFields(m) != null);
	}
		
	@Test
	@DisplayName("getBasicFieldsWithDefault")
	void testGetBasicFieldsWithSAVE_FILE_RESTART_LOG_OUT() {
		m = MenuType.SAVE_FILE_RESTART_LOG_OUT;
		assertTrue(m.getBasicFields(m) != null);
	}
}
