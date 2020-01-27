package wrapppersoftware.login;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Scanner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import wrappersoftware.login.Login;

class TestLogin {
	Login login1;
	Login login2;
	
	@BeforeEach
	void init() {
		Scanner scan1 = new Scanner("Jelszó");
		Scanner scan2 = new Scanner("alma");
		login1 = new Login(scan1);
		login2 = new Login(scan2);
	}
	
	@Test
	@DisplayName("Login funkció tesztelése helyes jelszóval")
	void testLoginWithCorrectValue() {
		assertEquals(true, login1.isPasswordCorrect());
	}
	
	@Test
	@DisplayName("Login funkció tesztelése helytelen jelszóval")
	void testLoginWithIncorrectValue() {
		assertEquals(false, login2.isPasswordCorrect());
	}
}
