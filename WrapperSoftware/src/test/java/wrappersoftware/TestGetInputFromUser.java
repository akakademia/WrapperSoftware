package wrappersoftware;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Scanner;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TestGetInputFromUser {
	Scanner scan;
	GetInputFromUser input1;
	GetInputFromUser input2;
	

	public void makeFakeIntNumberInput() {
		String testValue = "2\n";
		scan = new Scanner(testValue);
		input1 = new GetInputFromUser(scan);
	}

	public void makeFakedoubleNumberInput() {
		String testValue = "2,5\n";
		scan = new Scanner(testValue);
		input1 = new GetInputFromUser(scan);
	}

	public void makeFakeStringInput() {
		String testValue = "alma\n";
		scan = new Scanner(testValue);
		input1 = new GetInputFromUser(scan);
	}
	
	@BeforeEach
	public void initInput2() {
		input2 = new GetInputFromUser(scan, "üzenet");
	} 

	@AfterEach
	public void resetSystemIn() {
		scan = new Scanner(System.in);
		input1 = new GetInputFromUser(scan);
	}

	@Test
	@DisplayName("getStringInputFromUser() tesztelése")
	public void testGetStringInputFromUser() {
		makeFakeStringInput();
		assertEquals("alma", input1.getStringInputFromUser("üzenet"));
	}

	@Test
	@DisplayName("GetValidIntegerFromUser tesztelése System.in megkerülésével, ha Valid")
	public void testGetValidIntegerFromUserWhenValid() {
		makeFakeIntNumberInput();
		assertEquals(2, input1.getValidIntegerFromUser(0, 10), "ha a bemenet 2 akkor a kimenet 2?");
	}

	@Test
	@DisplayName("getValidDoubleFromUser tesztelése System.in megkerülésével, ha Valid")
	public void testgetValidDoubleFromUserWhenValid() {
		makeFakedoubleNumberInput();
		assertEquals(2.5, input1.getValidDoubleFromUser(0, 10), "ha a bemenet 2.5 akkor a kimenet 2?");
	}

	@Test
	@DisplayName("Exception a getValidIntegerFromUser-nél")
	public void testGetValidIntegerFromUserWhenExceptionGenerated() {
		makeFakeStringInput();
		assertThrows(Exception.class, () -> {
			input1.getValidIntegerFromUser(0, 10);
		});
	}
	
	@Test
	@DisplayName("Exception a getValidDoubleFromUser-nél")
	public void testGetValidDoubleFromUserWhenExceptionGenerated() {
		makeFakeStringInput();
		assertThrows(Exception.class, () -> {
			input1.getValidDoubleFromUser(0, 10);
		});
	}

	
	
}
