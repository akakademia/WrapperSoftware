import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TestMenu {

	Menu m;
	
	@BeforeEach
	void init() {
		m = new Menu(MenuType.ADMIN);
		m.fields = new String[] {"teszt"};
		
	}
	
	@Test
	@DisplayName("getMenuType() return menuType? ")
	void testGetMenuType() {
		assertEquals(MenuType.ADMIN, m.getMenuType());
	}
	
	@Test
	@DisplayName("getFields() return fields? ")
	void testGetFields() {
		assertTrue(m.getFields().length==1, "fields mező mérete 1?");
	}
	
	@Test
	@DisplayName("setAdditonalFields() with a new value")
	void testSetAdditonalFieldsWithNewValue() {
		m.setAdditonalFields(new String[] {"test2"});
		assertEquals(2, m.fields.length, "fields tömb mérete 2?");
	}
	
	@Test
	@DisplayName("setAdditonalFields() with null")
	void testSetAdditonalFieldsWithNull() {
		m.setAdditonalFields(null);
		assertEquals(1, m.fields.length, "fields tömb mérete 1?");
	}
	
	
	
	@Test
	@DisplayName("toString tesztelése")
	void testToString() {
		assertEquals(String.format("%s%n%2d. %s%n", "Admin menü:", 0, "teszt"), m.toString());
	}
	
	
	
	
	
	
	
	
	

}
