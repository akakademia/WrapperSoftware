package wrappersoftware;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Scanner;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TestGetInputFromUser {
	Scanner scan;
	GetInputFromUser input;
        
        void makeFakeIntNumberInput(){
            String testValue = "2\n";
            scan = new Scanner(testValue);
            input = new GetInputFromUser(scan);
        }
        
        void makeFakedoubleNumberInput(){
            String testValue = "2,5\n";
            scan = new Scanner(testValue);
            input = new GetInputFromUser(scan);
        }
        
        void makeFakeStringInput(){
            String testValue = "alma\n";
            scan = new Scanner(testValue);
            input = new GetInputFromUser(scan);
        }
        
        @AfterEach
	public void resetSystemIn() {
		scan = new Scanner(System.in);
		input = new GetInputFromUser(scan);
	}
        
        @Test
        @DisplayName("getPasswordFromUser() tesztelése")
        public void testGetPasswordFromUser(){
            makeFakeStringInput();
            assertEquals("alma", input.getPasswordFromUser());
        }

	@Test
	@DisplayName("GetValidIntegerFromUser tesztelése System.in megkerülésével, ha Valid")
	public void testGetValidIntegerFromUserWhenValid() {
            makeFakeIntNumberInput();
            assertEquals(2, input.getValidIntegerFromUser(0, 10), "ha a bemenet 2 akkor a kimenet 2?");
	}
	
	@Test
	@DisplayName("getValidDoubleFromUser tesztelése System.in megkerülésével, ha Valid")
	public void testgetValidDoubleFromUserWhenValid() {
            makeFakedoubleNumberInput();
            assertEquals(2.5, input.getValidDoubleFromUser(0, 10), "ha a bemenet 2.5 akkor a kimenet 2?");
	}

}
