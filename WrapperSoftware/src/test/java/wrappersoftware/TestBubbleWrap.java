package wrappersoftware;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TestBubbleWrap {

	BubbleWrap bubblewrap;
	
	@BeforeEach
	public void init() {
		bubblewrap = new BubbleWrap("AirPlus", 50, 50, 9, 2, 250);
	}
	
	@Test
	@DisplayName("toString tesztelése")
	public void testToString() {
		assertTrue(bubblewrap.toString().contains("Térkitöltő: " + bubblewrap.getName()));
	}

}
