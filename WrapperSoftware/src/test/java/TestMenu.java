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
		assertEquals(MenuType.ADMIN, menu.getMenuType() );
		
	}

}
