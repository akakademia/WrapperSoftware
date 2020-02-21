package wrappersoftware;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import wrappersoftware.Menu;
import wrappersoftware.MenuType;

class TestMenu {

	Menu menu;
	
	@BeforeEach
	void init() {
		menu = new Menu(MenuType.ADMIN);
	}
	
	@Test
	@DisplayName("getMenuType() return menuType? ")
	void testGetMenuType() {
		assertEquals(MenuType.ADMIN, menu.getMenuType());
	}
	
	@Test
	@DisplayName("getFields() return fields? ")
	void testGetFields() {
		assertTrue(menu.getFields().length==3, "fields mező mérete 3 MenuType.ADMIN esetén?");
	}
	
	@Test
	@DisplayName("getNumberOfBasicFields() return numberOfBasicFields")
	void testGetNumberOfBasicFields() {
		assertTrue(menu.getNumberOfBasicFields()==3, "getNumberOfBasicFields() return 3 MenuType.ADMIN esetén?");
	}
	
	@Test
	@DisplayName("setAdditonalFields() with a new value than fields size?")
	void testSetAdditonalFieldsThanFieldsSize() {
		menu.setAdditonalFields(new String[] {"test2"});
		
		assertEquals(4, menu.getFields().length, "getFields().length == 4?");
	}
	
	@Test
	@DisplayName("setAdditonalFields() with null")
	void testSetAdditonalFieldsWithNull() {
		menu.setAdditonalFields(null);
		assertEquals(3, menu.getFields().length, "fields tömb mérete 3?");
	}
	
	@Test
	@DisplayName("setAdditonalFields() with 0 length string")
	void testSetAdditonalFieldsWithZeroLengthString() {
		menu.setAdditonalFields(new String[] {""});
		assertEquals(3, menu.getFields().length, "fields tömb mérete 3?");
	}
	
	@Test
	@DisplayName("toString tesztelése")
	public void testToString() {
		assertTrue(menu.toString().contains("Admin menü:"));
	}
}
