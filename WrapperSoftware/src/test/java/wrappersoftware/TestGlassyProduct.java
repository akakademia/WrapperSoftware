package wrappersoftware;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TestGlassyProduct {

	GlassyProduct glassyProduct;
	
	@BeforeEach
	public void init() {
		glassyProduct = new GlassyProduct("csatos üvegek", 10.6, 16, 0.77, 1000);
	}
	
	@Test
	@DisplayName("toString tesztelése")
	public void testToString() {
		assertTrue(glassyProduct.toString().contains("Üveges termék: " + glassyProduct.getName()));
	}

}
