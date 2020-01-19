import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TestGetNumber {
	GetNumber number;
	private final InputStream systemIn = System.in;
	private ByteArrayInputStream testIn;
	
	@BeforeEach
	void init() {
		Scanner scan = new Scanner(System.in);
		number = new GetNumber(scan);
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
//	@DisplayName("GetValidIntegerFromUser")
//	void testGetValidIntegerFromUser() {
//		assertEquals(5, number.getValidIntegerFromUser(0, 10));
//		
//	}
	

//    @AfterAll
//    public void resetSystemIn() {
//        System.setIn(systemIn);
//    }

//    private void inputData(String data) {
//        testIn = new ByteArrayInputStream(data.getBytes());
//        System.setIn(testIn);
//    }
//
//    @Test
//    public void testchoosePlayers() {
//        inputData("5");
//        int actual = number.getValidIntegerFromUser(0, 10);
//        assertEquals(5, actual);
//     
//    }

}
