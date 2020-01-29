package wrappersoftware;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TestMatrixSheet {
	
	MatrixSheet matrixSheet;
	
	@BeforeEach
	public void init(){
		matrixSheet = new MatrixSheet("63 x 38 mm", 6.3, 3.8, 21, 450);
		
	}

	@Test
	@DisplayName("toString tesztelése")
	public void testToString() {
		assertTrue(matrixSheet.toString().contains("Matrica: " + matrixSheet.getName()));
	}

}
