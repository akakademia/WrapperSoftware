import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
		assertTrue(menu.getFields().length==2, "fields mező mérete 2 MenuType.ADMIN esetén?");
	}
	
	@Test
	@DisplayName("getNumberOfBasicFields() return numberOfBasicFields")
	void testGetNumberOfBasicFields() {
		assertTrue(menu.getNumberOfBasicFields()==2, "getNumberOfBasicFields() return 2 MenuType.ADMIN esetén?");
	}
	
	@Test
	@DisplayName("setAdditonalFields() with a new value than fields size?")
	void testSetAdditonalFieldsThanFieldsSize() {
		menu.setAdditonalFields(new String[] {"test2"});
		
		assertEquals(3, menu.getFields().length, "getFields().length == 3?");
	}
	
	@Test
	@DisplayName("setAdditonalFields() with null")
	void testSetAdditonalFieldsWithNull() {
		menu.setAdditonalFields(null);
		assertEquals(2, menu.getFields().length, "fields tömb mérete 2?");
	}
	
	@Test
	@DisplayName("setAdditonalFields() with 0 length string")
	void testSetAdditonalFieldsWithZeroLengthString() {
		menu.setAdditonalFields(new String[] {""});
		assertEquals(2, menu.getFields().length, "fields tömb mérete 2?");
	}
	
	@Test
	@DisplayName("toString tesztelése")
	void testToString() {
		assertEquals(String.format("%s%n%2d. %s%n%2d. %s%n", "Admin menü:", 0, "Tovább számításhoz", 1, "Adatmódosítás"), menu.toString());
	}
	
	
	
	
	
	
	
	
	

}
