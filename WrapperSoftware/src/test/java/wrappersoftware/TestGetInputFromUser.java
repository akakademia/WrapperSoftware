package wrappersoftware;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Scanner;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TestGetInputFromUser {
	Scanner scan;
	GetInputFromUser number;

	@BeforeEach
	void init() {
		String testValue = "2\n";
		scan = new Scanner(testValue);
		number = new GetInputFromUser(scan);
	}

	@AfterEach
	public void resetSystemIn() {
		scan = new Scanner(System.in);
		number = new GetInputFromUser(scan);
	}

	@Test
	@DisplayName("getIntegerNumber()")
	void testGetIntegerNumber() {
		assertEquals(0, number.getIntegerNumber());
	}

	@Test
	@DisplayName("getDoubleNumber()")
	void testGetDoubleNumber() {
		assertEquals(0.0, number.getDoubleNumber());
	}

//	@Test
//	@DisplayName("GetValidIntegerFromUser tesztelése System.in megkerülésével, ha Valid")
//	public void testGetValidIntegerFromUserWhenValid() {
//		assertEquals(2, number.getValidIntegerFromUser(0, 10), "ha a bemenet 2 akkor a kimenet 2?");
//	}
//	
//	@Test
//	@DisplayName("getValidDoubleFromUser tesztelése System.in megkerülésével, ha Valid")
//	public void testgetValidDoubleFromUserWhenValid() {
//		assertEquals(2, number.getValidDoubleFromUser(0, 10), "ha a bemenet 2 akkor a kimenet 2?");
//	}

}
