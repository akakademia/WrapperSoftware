package wrappersoftware;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TestCardboard {
	
	Cardboard cardboard1;
	Cardboard cardboard2;
	
	@BeforeEach
	public void init() {
		cardboard1 = new Cardboard();
		cardboard2 = new Cardboard("E-hullám(mikrohullám)", 100, 200, 1.5, 5.0, 20);
	}
	
	@Test
	@DisplayName("toString tesztelése")
	public void testToString() {
		assertTrue(cardboard2.toString().contains("Dekorkarton: " + cardboard2.getName()));
	}
}
