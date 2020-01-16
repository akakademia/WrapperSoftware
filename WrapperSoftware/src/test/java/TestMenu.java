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
		assertTrue(m.fields[0] == "teszt", "fields[0] == teszt");
		
	}
	
	@Test
	@DisplayName("setAdditonalFields()")
	void testSetAdditonalFields() {
		m.setAdditonalFields(new String[] {"test2"});
		assertEquals(2, m.fields.length, "fields tömb mérete 2?");
	}
	
	@Test
	@DisplayName("toString tesztelése")
	void testToString() {
		assertEquals(String.format("%s%n%2d. %s%n", "Admin menü:", 0, "teszt"), m.toString());
	}
	
	
	
	
	
	
	
	
	

}
