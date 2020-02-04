package wrapppersoftware.admin;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Scanner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import wrappersoftware.admin.Login;

class TestLogin {
	private Login login1;
	private Login login2;
	
	@BeforeEach
	public void init() {
		Scanner scan1 = new Scanner("Jelszó");
		Scanner scan2 = new Scanner("alma");
		login1 = new Login(scan1);
		login2 = new Login(scan2);
	}
	
//	@Test
//	@DisplayName("Login funkció tesztelése helyes jelszóval")
//	public void testLoginWithCorrectValue() {
//		assertEquals(true, login1.isPasswordCorrect());
//	}
//	
//	@Test
//	@DisplayName("Login funkció tesztelése helytelen jelszóval")
//	public void testLoginWithIncorrectValue() {
//		assertEquals(false, login2.isPasswordCorrect());
//	}
//	
//	@Test
//	@DisplayName("toString tesztelése várt eredménnyel")
//	public void testToString1() {
//		assertTrue(login1.toString().equals("true"));
//		assertTrue(login2.toString().equals("false"));
//	}
//	
//	@Test
//	@DisplayName("toString tesztelése nem várt eredménnyel")
//	public void testToString2() {
//		assertFalse(login1.toString().equals("false"));
//		assertFalse(login2.toString().equals("true"));
//	}
}
